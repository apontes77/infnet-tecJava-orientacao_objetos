package br.edu.infnet.apppagamento.controller;

import br.edu.infnet.apppagamento.model.domain.Pagamento;
import br.edu.infnet.apppagamento.model.service.ClienteService;
import br.edu.infnet.apppagamento.model.service.ContaService;
import br.edu.infnet.apppagamento.model.service.PagamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PagamentoController {
	private PagamentoService pagamentoService;

	private ClienteService clienteService;

	private ContaService contaService;

	public PagamentoController(PagamentoService service, ClienteService clienteService, ContaService contaService) {
		this.pagamentoService = service;
		this.clienteService = clienteService;
		this.contaService = contaService;
	}

	@GetMapping(value = "/pagamento/lista")
    public String telaPagamento(Model model) {
    	model.addAttribute("listagem", pagamentoService.obterLista());
    	
        return "pagamento/lista";
    }

	@GetMapping(value = "/pagamento")
	public String telaCadastro(Model model) {
		model.addAttribute("clientes", clienteService.obterLista());
		model.addAttribute("contas", contaService.obterLista());

		return "pagamento/cadastro";
	}
    
    @PostMapping(value = "/pagamento/incluir")
	public String inclusao(Pagamento pagamento) {
		
    	pagamentoService.incluir(pagamento);
		
		return "redirect:/";
	}
    
    @GetMapping(value = "/pagamento/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
    	pagamentoService.excluir(id);
    	return "redirect:/pagamento/lista";
    }
}
