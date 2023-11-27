package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Contact;
import com.eazybytes.springsecuritybasic.repository.ContactRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Random;

@RestController
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    private String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }

    @PostMapping(
            value = "/contact",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Contact> saveContactInquiryDetails(@RequestBody Contact contact) {

        System.out.println("Inquiry details are saved to the DB");
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return ResponseEntity.ok(
                contactRepository.save(contact)
        );
    }

}
