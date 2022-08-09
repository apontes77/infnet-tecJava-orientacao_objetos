package br.edu.infnet.apppagamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContaController {

    @GetMapping(value = "/conta/lista")
    public String telaConta() {
        return "conta/lista";
    }
}
