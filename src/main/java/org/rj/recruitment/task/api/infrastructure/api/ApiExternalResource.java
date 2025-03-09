package org.rj.recruitment.task.api.infrastructure.api;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("api/v1/users")
public class ApiExternalResource {

    @Inject
    ApiExternalFacade apiGetService;

    @GET
    @Path("/{username}")
    @PermitAll
    @Blocking
    public Uni<Response> getRepositoryUser(@PathParam("username") String username) {
        return apiGetService.getRepositories(username);
    }
}
