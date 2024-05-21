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

    @PostMapping("/login")
    public String login(
            @RequestParam("loginType") String loginType,
            @RequestParam("brugernavn") String username,
            @RequestParam("adgangskode") String password,
            Model model) {

        if ("FDM".equalsIgnoreCase(loginType) && "fdmuser".equals(username) && "fdmpass".equals(password)) {
            return "redirect:/report";
        } else if (("Medarbejder".equalsIgnoreCase(loginType) || "Admin".equalsIgnoreCase(loginType))
                && "user".equals(username) && "pass".equals(password)) {
            return "redirect:/dataregistrering";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/dataregistrering")
    public String dataregistrering() {
        return "dataregistrering";
    }

    @GetMapping("/raport")
    public String report() {
        return "raport";
    }
}



