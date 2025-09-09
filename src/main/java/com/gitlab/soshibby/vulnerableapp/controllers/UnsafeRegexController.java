package com.gitlab.soshibby.vulnerableapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@RequestMapping("regex")
public class UnsafeRegexController {

    @GetMapping("/simple")
    public String greeting(@RequestParam(value="name") String name) {
        String pattern = "(a+)+";

        boolean matches = Pattern.compile(pattern)
                .matcher(name)
                .matches();

        return matches ? name + " matches the regular expression." : name + " doesn't match the regular expression";
    }

    @GetMapping("/validate-email")
    public String validateEmail(@RequestParam(value="email") String email) {
        String pattern = "^([a-zA-Z0-9])(([\\-.]|[_]+)?([a-zA-Z0-9]+))*(@){1}[a-z0-9]+[.]{1}(([a-z]{2,3})|([a-z]{2,3}[.]{1}[a-z]{2,3}))$";

        boolean isValidMailAddress = Pattern.compile(pattern)
                .matcher(email)
                .matches();

        return isValidMailAddress ? email + " is a valid mail address." : email + " is an invalid mail address.";
    }

}
