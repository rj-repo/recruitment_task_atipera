package org.rj.recruitment.task.api.application.github.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.rj.recruitment.task.api.application.github.repository.model.GithubRepository;
import org.rj.recruitment.task.api.application.github.repository.model.GithubRepositoryBranch;
import org.rj.recruitment.task.api.infrastructure.api.AuthorizationHeaderFilter;

import java.util.List;

@RegisterRestClient
@ApplicationScoped
@RegisterProvider(AuthorizationHeaderFilter.class)
public interface GithubRestClient {


    @GET
    @Path("/users/{username}/repos")
    @Produces(MediaType.APPLICATION_JSON)
    List<GithubRepository> getUserRepositories(@PathParam("username") String username);


    @GET
    @Path("/repos/{owner}/{repo}/branches")
    @Produces(MediaType.APPLICATION_JSON)
    List<GithubRepositoryBranch> getRepositoryBranches(@PathParam("owner") String owner,
                                                       @PathParam("repo") String repo);

}
