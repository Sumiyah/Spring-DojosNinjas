package com.sumiyah.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumiyah.dojosninjas.models.Dojo;
import com.sumiyah.dojosninjas.services.DNService;

@Controller
public class DojoController {

	private final DNService appService;
	public DojoController(DNService service) {
		this.appService = service;
	}
	
	@RequestMapping("/dojos")
	public String Index(Model model) {
		model.addAttribute("dojos", appService.allDojos());
		return "dojoHome.jsp";
	}
	@RequestMapping("/dojos/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", this.appService.findDojo(id));
		return "showDojo.jsp";
	}
	@RequestMapping("/dojos/new")
	public String New(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors())
			return "newDojo.jsp";
		this.appService.createDojo(dojo);
		return "redirect:/dojos";
	}
	
}
