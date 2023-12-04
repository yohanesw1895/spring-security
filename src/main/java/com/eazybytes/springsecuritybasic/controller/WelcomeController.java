package com.eazybytes.springsecuritybasic.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String sayWelcome(OAuth2AuthenticationToken token) {

        System.out.println("Welcome to Spring Application with Security : " + token.getPrincipal());
        return "secure.html";
    }

}
