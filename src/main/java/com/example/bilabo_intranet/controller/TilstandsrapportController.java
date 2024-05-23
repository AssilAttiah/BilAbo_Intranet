package com.example.bilabo_intranet.controller;

import com.example.bilabo_intranet.model.TilstandsrapportModel;
import com.example.bilabo_intranet.service.TilstandsrapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
