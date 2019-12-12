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

import com.casamento.demo.domain.Presente;
import com.casamento.demo.service.PresenteService;

@Controller
@RequestMapping("/presente")
public class PresenteController {
	
	@Autowired
	private PresenteService presenteService;
	
	@GetMapping("/cadastrar")
	public String cadastroPresente(Presente presente) {
		return "/presente/cadastrar";
	}
	
	
	@GetMapping("/listar")
	public String listarPresentes(ModelMap model) {
		model.addAttribute("presentes", presenteService.buscarTodos());
		return "/presente/listar"; 
	}
	
	@PostMapping("/salvar")
	public String salvarPresente(@Valid Presente presente,BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/presente/cadastrar";
		}
		
		presenteService.salvar(presente);
		attr.addFlashAttribute("success", "Presente cadastrada com sucesso.");
		return "redirect:/presente/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditarPresente(@PathVariable("id") Long id, ModelMap model, Presente presente) {
		model.addAttribute("presente", presenteService.buscarPorId(id));
		return "/presente/cadastrar";
	}
	
	@PostMapping("/editar")
	public String editarPresente(@Valid Presente presente, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/presente/cadastrar";
		}
		
		presenteService.editar(presente);
		attr.addFlashAttribute("success", "Presente editado com sucesso.");
		return "redirect:/presente/cadastrar";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		try {
			presenteService.excluir(id);
			model.addAttribute("success", "Presente removida com sucesso.");
		}catch(Exception e) {
			model.addAttribute("fail", "Presente nao removida.");
		}
		return listarPresentes(model);
	}
	
}