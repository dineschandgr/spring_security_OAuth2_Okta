package io.spring.security.springsecurity.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestResourceController {
    @GetMapping("/mod")
    @PreAuthorize("#oauth2.hasScope('custom_mod')")
    public String getMessageOfTheDay(Principal principal) {
        return "The message of the day from Resource Server 2: " + principal.getName();
    }
}