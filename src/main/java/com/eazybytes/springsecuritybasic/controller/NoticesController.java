package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Notice;
import com.eazybytes.springsecuritybasic.repository.NoticeRepository;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {

    private final NoticeRepository noticeRepository;

    public NoticesController(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @GetMapping(
            value = "/notices",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Notice>> getNotices() {

        System.out.println("Here are the notices details from the DB");
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(noticeRepository.findAllActiveNotices());
    }

}
