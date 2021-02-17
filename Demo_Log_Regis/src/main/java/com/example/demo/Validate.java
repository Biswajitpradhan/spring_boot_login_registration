package com.example.demo;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api")
public class Validate {
private DetailrEPO epo;
	
	public Validate(DetailrEPO epo) {
		this.epo = epo;
	}
	@PostMapping("check/{value}")
	String check(@PathVariable String value)
	{
		System.out.println(value);
		int id=Integer.parseInt(value);
		boolean o=epo.existsByCardId(id);
		System.out.println(o);
		if(o)
		{
			return "true";
		}
		return "false";
	}
}
