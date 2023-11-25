package com.eazybytes.springsecuritybasic.config;

import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EazyBankUserDetails implements UserDetailsService {


    private final CustomerRepository customerRepository;

    public EazyBankUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return customerRepository.findOneByEmail(username)
                .map(d -> {
                    List<GrantedAuthority> authorities = new ArrayList<>();
                    authorities.add(new SimpleGrantedAuthority(d.getRole()));

                    return new User(d.getEmail(), d.getPassword(), authorities);

                })
                .orElseThrow(() -> new UsernameNotFoundException("User details not found for the user : " + username));

    }
}
