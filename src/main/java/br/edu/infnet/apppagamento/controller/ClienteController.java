package br.edu.infnet.apppagamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @GetMapping(value = "/cliente/lista")
    public String telaCliente() {
        return "cliente/lista";
    }
}
