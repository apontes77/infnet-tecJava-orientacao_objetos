package br.edu.infnet.apppagamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExtraController {

    @GetMapping(value = "/extra/lista")
    public String telaExtra() {
        return "extra/lista";
    }
}
