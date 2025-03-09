package org.rj.recruitment.task.api.infrastructure.api.model.error;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.Getter;


@Getter
public class InternalErrorResponseException extends WebApplicationException {

    private final String message;
    public InternalErrorResponseException(String message) {
        this.message = message;
    }

    @Override
    public Response getResponse() {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(500, message);
        return Response.status(500).entity(apiErrorResponse).build();
    }
}
