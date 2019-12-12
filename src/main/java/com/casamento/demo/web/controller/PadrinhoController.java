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

import com.casamento.demo.domain.Padrinho;
import com.casamento.demo.domain.Presente;
import com.casamento.demo.service.FestaService;
import com.casamento.demo.service.PadrinhoService;
import com.casamento.demo.service.PresenteService;

@Controller
@RequestMapping("/padrinho")
public class PadrinhoController {
	
	@Autowired
	private PadrinhoService padrinhoService;

	@Autowired
	private PresenteService presenteService;
	
	@Autowired
	private FestaService festaService;
	
	@GetMapping("/cadastrar")
	public String cadastroPadrinho(Padrinho padrinho, Presente presente, ModelMap model) {
		model.addAttribute("presentes", presenteService.buscarTodos());
		model.addAttribute("festas", festaService.buscarTodos());
		return "/padrinho/cadastrar";
	}
	
	
	@GetMapping("/listar")
	public String listarPadrinhos(ModelMap model) {
		
		
		model.addAttribute("padrinhos", padrinhoService.buscarTodos() );
		return "/padrinho/listar"; 
	}
	
	@PostMapping("/salvar")
	public String salvarPadrinho(@Valid Padrinho padrinho, BindingResult result, RedirectAttributes attr, ModelMap model) {
		
		if(result.hasErrors()) {
			model.addAttribute("presentes", presenteService.buscarTodos());
			return "/padrinho/cadastrar";
		}
		
		padrinhoService.salvar(padrinho);
		
		attr.addFlashAttribute("success", "Padrinho / Madrinha cadastrado com sucesso.");
		return "redirect:/padrinho/cadastrar";
	}
	
	
	
	@GetMapping("/perfil/{id}")
	public String PerfilPadrinho(@PathVariable("id") Long id, ModelMap model) {
		String festa = padrinhoService.buscarPorId(id).getFesta().toString().replaceAll("\\D+","");
		String presente = padrinhoService.buscarPorId(id).getFesta().toString().replaceAll("\\D+","");
		model.addAttribute("padrinho", padrinhoService.buscarPorId(id));
		model.addAttribute("festa", festaService.buscarPorId(Long.parseLong(festa)));
		model.addAttribute("presente", presenteService.buscarPorId(Long.parseLong(presente)));
		return "/padrinho/perfil"; 
	}
	
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		padrinhoService.excluir(id);
			model.addAttribute("success", "Padrinho / Madrinha excluído com sucesso.");
		return listarPadrinhos(model);
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("padrinho", padrinhoService.buscarPorId(id));
		model.addAttribute("presentes", presenteService.buscarTodos());
		model.addAttribute("festas", festaService.buscarTodos());
		return "/padrinho/cadastrar";
	}
	
	@PostMapping("/editar")
	public String editar(Padrinho padrinho, RedirectAttributes attr, ModelMap model) {
		padrinhoService.editar(padrinho);
		attr.addFlashAttribute("success", "Padrinho / Madrinha editado com sucesso.");
		return "redirect:/padrinho/cadastrar";
	}
	
	
}
