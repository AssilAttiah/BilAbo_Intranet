package com.example.bilabo_intranet.controller;

import com.example.bilabo_intranet.service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class myController {


@Autowired
    BilService bilService;



    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }


}



