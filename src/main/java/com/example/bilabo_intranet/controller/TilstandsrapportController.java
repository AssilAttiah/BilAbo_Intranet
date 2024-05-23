package com.example.bilabo_intranet.controller;

import com.example.bilabo_intranet.model.TilstandsrapportModel;
import com.example.bilabo_intranet.service.TilstandsrapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class TilstandsrapportController {

    @Autowired
    private TilstandsrapportService tilstandsrapportService;

    @GetMapping("/rapport")
    public String viewRapportPage(Model model) {
        List<TilstandsrapportModel> rapporter = tilstandsrapportService.findAllTr();
        model.addAttribute("rapporter", rapporter);
        return "rapport";
    }


    @PostMapping("/tilstandsrapport/beregn-samlet-pris")
    public String beregnSamletPris(
            @RequestParam("skadePris1") double skadePris1,
            @RequestParam("skadePris2") double skadePris2,
            @RequestParam("skadePris3") double skadePris3,
            @RequestParam("skadePris4") double skadePris4,
            @RequestParam("skadePris5") double skadePris5,
            @RequestParam("skadePris6") double skadePris6,
            Model model) {


        double samletPris = tilstandsrapportService.beregnSamletPris(skadePris1, skadePris2, skadePris3, skadePris4, skadePris5, skadePris6);
        model.addAttribute("samletPris", samletPris);

        return "tilfojTR"; // Returner til den samme side for at vise den samlede pris
    }
}
