package com.mettl.resourceserverpoc.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping("/request1")
    @Secured("ROLE_USER1")
    public String request1() {
        return "request1";
    }

    @GetMapping("/request2")
//    @Secured("ROLE_ADMIN")
    public String request2() {
        return "request2";
    }
}

