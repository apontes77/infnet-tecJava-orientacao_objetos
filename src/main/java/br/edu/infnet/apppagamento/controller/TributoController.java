package br.edu.infnet.apppagamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TributoController {

    @GetMapping(value = "/tributo/lista")
    public String telaTributo() {
        return "tributo/lista";
    }
}
