package com.example.bilabo_intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class myController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value="loginType", defaultValue = "")String loginType) {
        if (loginType.equals("Medarbejder")) {
            return "dataregistrering";
        } else if (loginType.equals("FDM")) {
            return "dataregistrering";
        } else if (loginType.equals("Admin")) {
            return "forretning";
        } else {
            return "Forkert login";
        }
    }
}

