package com.eazybytes.springsecuritybasic.repository;

import com.eazybytes.springsecuritybasic.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
