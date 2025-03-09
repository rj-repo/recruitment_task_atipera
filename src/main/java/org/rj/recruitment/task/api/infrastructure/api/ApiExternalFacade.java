package org.rj.recruitment.task.api.infrastructure.api;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.rj.recruitment.task.api.domain.business.ExternalApiGetService;
import org.rj.recruitment.task.api.infrastructure.api.model.RepositoriesUserResponse;

@ApplicationScoped
public class ApiExternalFacade {

    @Inject
    ExternalApiGetService externalApiGetService;

    public Uni<Response> getRepositories(String username) {
        return Uni.createFrom()
                .item(externalApiGetService.getRepositoriesForUser(username))
                .map(repositories -> Response.ok(RepositoriesUserResponse.of(repositories)).build());
    }


}
