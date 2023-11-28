package com.eazybytes.springsecuritybasic.config;

import com.eazybytes.springsecuritybasic.model.Authority;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public EazyBankUsernamePwdAuthenticationProvider(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        return authorities
                .stream()
                .map(d -> new SimpleGrantedAuthority(d.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String
            username = authentication.getName(),
            pwd = authentication.getCredentials().toString();

        return customerRepository.findOneByEmail(username)
                .map(d -> {

                    if (passwordEncoder.matches(pwd, d.getPassword())) {

                        List<GrantedAuthority> authorities = getGrantedAuthorities(d.getAuthorities());

                        return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
                    }
                    else {
                        throw new BadCredentialsException("Invalid Password");
                    }

                })
                .orElseThrow(() -> new BadCredentialsException("No user registered with thi details"));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
