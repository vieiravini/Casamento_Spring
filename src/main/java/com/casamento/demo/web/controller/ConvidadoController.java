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

import com.casamento.demo.domain.Convidado;
import com.casamento.demo.service.ConvidadoService;
import com.casamento.demo.service.FestaService;
import com.casamento.demo.service.PresenteService;

@Controller
@RequestMapping("/convidado")
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService convidadoService;
	
	@Autowired
	private PresenteService presenteService;

	@Autowired
	private FestaService festaService;
	
	
	@GetMapping("/cadastrar")
	public String cadastroConvidado(Convidado convidado,ModelMap model) {
		model.addAttribute("presentes", presenteService.buscarTodos());
		model.addAttribute("festas", festaService.buscarTodos());
		return "/convidado/cadastrar";
	}
	
	
	@GetMapping("/listar")
	public String listarConvidados(ModelMap model) {
		model.addAttribute("convidados", convidadoService.buscarTodos());
		return "/convidado/listar"; 
	}
	
	@GetMapping("/perfil/{id}")
	public String listarConvidados(@PathVariable("id") Long id, ModelMap model) {
		String festa = convidadoService.buscarPorId(id).getFesta().toString().replaceAll("\\D+","");
		String presente = convidadoService.buscarPorId(id).getFesta().toString().replaceAll("\\D+","");
		model.addAttribute("convidado", convidadoService.buscarPorId(id));
		model.addAttribute("festa", festaService.buscarPorId(Long.parseLong(festa)));
		model.addAttribute("presente", presenteService.buscarPorId(Long.parseLong(presente)));
		return "/convidado/perfil"; 
	}
	
	@PostMapping("/salvar")
	public String salvarConvidado(@Valid Convidado convidado, BindingResult result, RedirectAttributes attr, ModelMap model) {
		
		if(result.hasErrors()) {
			model.addAttribute("presentes", presenteService.buscarTodos());
			model.addAttribute("festas", festaService.buscarTodos());
			return "/convidado/cadastrar";
		}

		convidadoService.salvar(convidado);
		attr.addFlashAttribute("success", "Convidado cadastrado com sucesso.");
		return "redirect:/convidado/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
			convidadoService.excluir(id);
			model.addAttribute("success", "Convidado excluído com sucesso.");
		return listarConvidados(model);
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("convidado", convidadoService.buscarPorId(id));
		model.addAttribute("presentes", presenteService.buscarTodos());
		model.addAttribute("festas", festaService.buscarTodos());
		return "/convidado/cadastrar";
	}
	
	@PostMapping("/editar")
	public String editar(Convidado convidado, RedirectAttributes attr, ModelMap model) {
		convidadoService.editar(convidado);
		attr.addFlashAttribute("success", "Convidado editado com sucesso.");
		return "redirect:/convidado/cadastrar";
	}
	
	
	
}
