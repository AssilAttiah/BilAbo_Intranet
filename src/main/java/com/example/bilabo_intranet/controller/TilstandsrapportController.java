package com.example.bilabo_intranet.controller;

import com.example.bilabo_intranet.model.TilstandsrapportModel;
import com.example.bilabo_intranet.service.TilstandsrapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller

public class TilstandsrapportController {

    @Autowired
    private TilstandsrapportService tilstandsrapportService;


// viser alle tilstandsrapporter
    @GetMapping("/rapport")
    public String viewRapportPage(Model model) {
        List<TilstandsrapportModel> rapporter = tilstandsrapportService.findAllTr();
        model.addAttribute("rapporter", rapporter);
        return "rapport";
    }

// Beregner samlet værdi og derefter gemmer den med stelnummer og skade og mangler
    @PostMapping("/tilstandsrapport/gem")
    public String beregnSamletPris(
            @RequestParam("stelnummer") String stelnummer,
            @RequestParam("skadePris1") double skadePris1,
            @RequestParam("skadePris2") double skadePris2,
            @RequestParam("skadePris3") double skadePris3,
            @RequestParam("skadePris4") double skadePris4,
            @RequestParam("skadePris5") double skadePris5,
            @RequestParam("skadePris6") double skadePris6,
            @RequestParam("skadeOgMangler") String skadeOgMangler,
            Model model) {


        // Beregner samlet pris
        double samletPris = tilstandsrapportService.beregnSamletPris(skadePris1, skadePris2, skadePris3, skadePris4, skadePris5, skadePris6);
        model.addAttribute("samletPris", samletPris);

        // Gemmer den samlede pris, stelnummer og skade og mangler
        TilstandsrapportModel nyRapport = new TilstandsrapportModel(null, BigDecimal.valueOf(samletPris), stelnummer, skadeOgMangler);
        tilstandsrapportService.saveTr(nyRapport);


        model.addAttribute("samletPris",samletPris);
        return "tilfojTR";
    }
}
