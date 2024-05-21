package com.example.bilabo_intranet.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class myController {

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(value="loginType", defaultValue = "") String loginType,
                        @RequestParam("brugernavn") String username,
                        @RequestParam("adgangskode") String adgangskode,
                        HttpSession session) {
        session.setAttribute("username", username);
        session.setAttribute("adgangskode", adgangskode);

        if (loginType.equals("Medarbejder")) {
            return "forside";
        } else if (loginType.equals("FDM")) {
            return "tilfojTR";
        } else if (loginType.equals("Admin")) {
            return "forside";
        } else {
            return "Forkert login";
        }
    }
}

