package org.rj.recruitment.task.api.infrastructure.api.model.error;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.Getter;


@Getter
public class UserNotFoundResponseException extends WebApplicationException {

    private final String message;
    public UserNotFoundResponseException(String message) {
        this.message = message;
    }

    @Override
    public Response getResponse() {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(404, message);
        return Response.status(404).entity(apiErrorResponse).build();
    }
}
