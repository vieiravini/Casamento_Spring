package com.casamento.demo.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.casamento.demo.domain.Festa;
import com.casamento.demo.service.FestaService;

@Component
public class StringToFestaConverter implements Converter<String, Festa>{

	@Autowired
	private FestaService service;
	
	@Override
	public Festa convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
