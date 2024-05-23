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

