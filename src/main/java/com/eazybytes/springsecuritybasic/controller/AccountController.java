package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Customer;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import org.apache.catalina.security.SecurityUtil;
import org.keycloak.KeycloakPrincipal;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final CustomerRepository customerRepository;

    public AccountController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(
            value = "/myAccount",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Customer> getMyAccount(@RequestParam String email, Authentication authentication) throws Exception {

        System.out.println("Principal class: " + authentication.getPrincipal().getClass().getName());

        Jwt jwt = (Jwt) authentication.getPrincipal();
        // Extract information from JWT claims
        String username = jwt.getClaimAsString("preferred_username");
        // Other claims...


//        KeycloakPrincipal<?> keycloakPrincipal = (KeycloakPrincipal<?>) authentication.getPrincipal();
//
//        // You can now access user information from the KeycloakPrincipal object
//        // For example, to get the username (subject ID in Keycloak terms)
//        String username = keycloakPrincipal.getName();

        System.out.println("Here are the account details from the DB, username : " + username);
        return ResponseEntity.ok(
                customerRepository.findOneByEmail(email)
                        .orElseThrow(() -> new Exception("data not found"))
        );
    }

}
