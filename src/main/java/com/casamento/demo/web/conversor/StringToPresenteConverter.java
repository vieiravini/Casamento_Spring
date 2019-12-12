package com.casamento.demo.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.casamento.demo.domain.Presente;
import com.casamento.demo.service.PresenteService;


@Component
public class StringToPresenteConverter implements Converter<String, Presente>{

	@Autowired
	private PresenteService service;
	
	@Override
	public Presente convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
