package com.casamento.demo.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casamento.demo.domain.Festa;
import com.casamento.demo.service.FestaService;


@Controller
@RequestMapping("/festas")
public class FestaController {
	
	@Autowired
	private FestaService festaService;
	
	@GetMapping("/cadastrar")
	public String cadastroFesta(Festa festa) {
		return "/festa/cadastrar";
	}
	
	
	@GetMapping("/listar")
	public String listarFesta(ModelMap model) {
		model.addAttribute("festas", festaService.buscarTodos());
		return "/festa/listar"; 
	}
	
	@PostMapping("/salvar")
	public String salvarFesta(@Valid Festa festa,BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/festa/cadastrar";
		}
		
		festaService.salvar(festa);
		attr.addFlashAttribute("success", "Festa cadastrada com sucesso.");
		return "redirect:/festas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditarFesta(@PathVariable("id") Long id, ModelMap model, Festa festa) {
		model.addAttribute("festa", festaService.buscarPorId(id));
		return "/festa/cadastrar";
	}
	
	@PostMapping("/editar")
	public String editarFesta(@Valid Festa festa, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/festa/cadastrar";
		}
		
		festaService.editar(festa);
		attr.addFlashAttribute("success", "Festa editado com sucesso.");
		return "redirect:/festas/cadastrar";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		try {
			festaService.excluir(id);
			model.addAttribute("success", "Festa removida com sucesso.");
		}catch(Exception e) {
			model.addAttribute("fail", "Festa nao removida.");
		}
		return listarFesta(model);
	}
	
	
	
}
