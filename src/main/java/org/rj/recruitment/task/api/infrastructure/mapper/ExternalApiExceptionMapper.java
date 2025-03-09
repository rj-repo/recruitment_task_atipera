package org.rj.recruitment.task.api.infrastructure.mapper;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.rj.recruitment.task.api.infrastructure.api.model.error.InternalErrorResponseException;
import org.rj.recruitment.task.api.infrastructure.api.model.error.NotAuthorizedResponseException;
import org.rj.recruitment.task.api.infrastructure.api.model.error.RequestLimitResponseException;
import org.rj.recruitment.task.api.infrastructure.api.model.error.UserNotFoundResponseException;

@Provider
@Slf4j
public class ExternalApiExceptionMapper implements ResponseExceptionMapper<WebApplicationException> {

    @Override
    public WebApplicationException toThrowable(Response response) {
        String errorMessage = response.readEntity(String.class);
        return switch (response.getStatus()) {
            case 404 -> logAndReturn(new UserNotFoundResponseException("User not found"));
            case 401 -> logAndReturn(new NotAuthorizedResponseException("Not authorized or wrong token"));
            case 403 -> logAndReturn(new RequestLimitResponseException("Too many requests - try using a token"));
            default -> logAndReturn(new InternalErrorResponseException("Internal Error: " + errorMessage));
        };
    }

    private WebApplicationException logAndReturn(WebApplicationException ex) {
        log.error("[{}] - {}: {}", ex.getClass().getSimpleName(), ex.getMessage(), ex.getResponse().getStatus());
        return ex;
    }
}
