package org.rj.recruitment.task.api.infrastructure.api.model.error;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.Getter;


@Getter
public class RequestLimitResponseException extends WebApplicationException {

    private final String message;
    public RequestLimitResponseException(String message) {
        this.message = message;
    }

    @Override
    public Response getResponse() {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(403, message);
        return Response.status(403).entity(apiErrorResponse).build();
    }
}
