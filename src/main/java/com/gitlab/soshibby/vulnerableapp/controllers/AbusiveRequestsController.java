package com.gitlab.soshibby.vulnerableapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/rate-limiter")
public class AbusiveRequestsController {

    @GetMapping("/current-date")
    public String test() {
        return new Date().toString();
    }

}
