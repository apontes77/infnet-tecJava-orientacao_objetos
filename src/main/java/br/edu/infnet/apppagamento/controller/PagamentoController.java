package br.edu.infnet.apppagamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagamentoController {

    @GetMapping(value = "/pagamento/lista")
    public String telaPagamento() {
        return "pagamento/lista";
    }
}
