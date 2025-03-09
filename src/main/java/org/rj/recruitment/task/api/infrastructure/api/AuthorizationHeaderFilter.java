package org.rj.recruitment.task.api.infrastructure.api;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AuthorizationHeaderFilter implements ClientRequestFilter {

    @Context
    private HttpHeaders httpHeaders;

    @Override
    public void filter(ClientRequestContext requestContext) {
        String authorizationValue = getDynamicAuthorizationToken();

        if (authorizationValue != null && !authorizationValue.isEmpty()) {
            requestContext.getHeaders().add("Authorization", authorizationValue);
        }
    }

    private String getDynamicAuthorizationToken() {
        return httpHeaders.getHeaderString("Authorization");
    }
}
