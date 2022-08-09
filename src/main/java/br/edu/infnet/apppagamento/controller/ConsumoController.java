package br.edu.infnet.apppagamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsumoController {

    @GetMapping(value = "/consumo/lista")
    public String telaConsumo() {
        return "consumo/lista";
    }
}
