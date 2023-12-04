package com.eazybytes.springsecuritybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests.anyRequest().authenticated()).oauth2Login(Customizer.withDefaults());
        return http.build();
    }

//    @Bean
//    public ClientRegistrationRepository clientRepository() {
//        ClientRegistration clientReg = clientRegistration();
//        return new InMemoryClientRegistrationRepository(clientReg);
//    }
//
//    private ClientRegistration clientRegistration() {
//		return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("b24e5d7a3b3ecdc6426b")
//	           .clientSecret("32ae1fe47799fb93928b3ff0949464f40d8322c6").build();
//	 }


}
