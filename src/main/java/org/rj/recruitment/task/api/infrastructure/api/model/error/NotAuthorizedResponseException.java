package org.rj.recruitment.task.api.infrastructure.api.model.error;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.Getter;


@Getter
public class NotAuthorizedResponseException extends WebApplicationException {

    private final String message;
    public NotAuthorizedResponseException(String message) {
        this.message = message;
    }

    @Override
    public Response getResponse() {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(401, message);
        return Response.status(401).entity(apiErrorResponse).build();
    }
}
