package com.eazybytes.springsecuritybasic.util;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static KeycloakPrincipal<?> getKeycloakPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof KeycloakAuthenticationToken keycloakAuthenticationToken) {
            if (keycloakAuthenticationToken.getPrincipal() instanceof KeycloakPrincipal) {
                return (KeycloakPrincipal<?>) keycloakAuthenticationToken.getPrincipal();
            }
        }
        throw new IllegalStateException("User not authenticated with Keycloak.");
    }

    // You can add more utility methods here to fetch other details as needed
}