package com.example.bilabo_intranet.controller;

import com.example.bilabo_intranet.service.BilService;
import com.example.bilabo_intranet.service.LeasingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    private LeasingService leasingService;

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
                        HttpSession session, Model model) {
        // Check om brugernavn og adgangskode er korrekte baseret på loginType
        if ("Admin".equals(loginType) && "admin".equals(username) && "admin".equals(adgangskode)) {
            session.setAttribute("username", username);
            session.setAttribute("adgangskode", adgangskode);
            return "forside";
        } else if ("FDM".equals(loginType) && "fdm".equals(username) && "fdm".equals(adgangskode)) {
            session.setAttribute("username", username);
            session.setAttribute("adgangskode", adgangskode);
            return "tilfojTR";
        } else if ("Medarbejder".equals(loginType) && "medarbejder".equals(username) && "medarbejder".equals(adgangskode)) {
            session.setAttribute("username", username);
            session.setAttribute("adgangskode", adgangskode);
            return "forside";
        } else {
            model.addAttribute("errorMessage", "Forkert username eller password");
            return "forkertLogin";
        }
    }



    @GetMapping("/forside")
    public String forside() {
        return "forside";
    }

    @GetMapping("/forretning")
    public String forretning(Model model) {
        int leasedCarCount = leasingService.countLeasedCars();
        double totalPrice = leasingService.calculateTotalPrice();

        model.addAttribute("leasedCarCount", leasedCarCount);
        model.addAttribute("totalPrice", totalPrice);

        return "forretning";
    }

    @GetMapping("fjernTR")
    public String fjernTR() {
        return "fjernTR";
    }

    @GetMapping("leasTR")
    public String leasTR() {
        return "leasTR";
    }

    @GetMapping("redigerTR")
    public String redigerTR() {
        return "redigerTR";
    }

    @GetMapping("tilfojTR")
    public String tilfojTR() {
        return "tilfojTR";
    }
}

