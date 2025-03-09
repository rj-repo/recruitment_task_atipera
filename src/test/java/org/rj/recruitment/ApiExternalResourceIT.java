package org.rj.recruitment;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.hamcrest.Matchers.*;
import static org.mockserver.model.JsonBody.json;

@QuarkusTest
public class ApiExternalResourceIT {

    private static ClientAndServer mockServer;

    @BeforeAll
    static void startMockServer() {
        mockServer = ClientAndServer.startClientAndServer(1000);

        mockServer.when(HttpRequest.request()
                        .withMethod("GET")
                        .withPath("/users/octocat/repos"))
                .respond(HttpResponse.response()
                        .withStatusCode(200)
                        .withBody(json("""
                    [
                        {
                            "name": "test-repo",
                            "owner": { "login": "octocat" },
                            "fork": false
                        }
                    ]
                """)));

        mockServer.when(HttpRequest.request()
                        .withMethod("GET")
                        .withPath("/repos/octocat/test-repo/branches"))
                .respond(HttpResponse.response()
                        .withStatusCode(200)
                        .withBody(json("""
                    [
                        {
                            "name": "main",
                            "commit": { "sha": "abc123" }
                        }
                    ]
                """)));

        mockServer.when(HttpRequest.request()
                        .withMethod("GET")
                        .withPath("/users/nonexistent-user/repos"))
                .respond(HttpResponse.response()
                        .withStatusCode(404)
                        .withBody(json("""
                    {
                        "message": "Not Found"
                    }
                """)));
    }

    @AfterAll
    static void stopMockServer() {
        if (mockServer != null) {
            mockServer.stop();
        }
    }

    @Test
    public void testGetRepositories_HappyPath() {
        RestAssured.given()
                .when().get("/api/v1/users/octocat")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("username", equalTo("octocat"))
                .body("repositoryUserList", not(empty()))
                .body("repositoryUserList[0].repoName", equalTo("test-repo"))
                .body("repositoryUserList[0].branches", not(empty()))
                .body("repositoryUserList[0].branches[0].branchName", equalTo("main"))
                .body("repositoryUserList[0].branches[0].lastCommitSHA", equalTo("abc123")) ;
    }


    @Test
    public void testGetRepositories_UserNotFound() {
        RestAssured.given()
                .when().get("api/v1/users/nonexistent-user")
                .then()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .body("status", equalTo(404))
                .body("message", equalTo("User not found"));
    }
}
