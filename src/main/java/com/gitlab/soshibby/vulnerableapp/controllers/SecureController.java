package com.gitlab.soshibby.vulnerableapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("secure")
public class SecureController {

    @GetMapping
    public String secure() {
        return "secure/index";
    }

}

