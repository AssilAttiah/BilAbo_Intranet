package com.example.bilabo_intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class myController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
