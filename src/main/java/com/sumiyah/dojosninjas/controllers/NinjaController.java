package com.sumiyah.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumiyah.dojosninjas.models.Ninja;
import com.sumiyah.dojosninjas.services.DNService;

@Controller
public class NinjaController {

	private final DNService appService;
	public NinjaController(DNService service) {
		this.appService=service;
	}
	
	@RequestMapping("/ninjas")
	public String Index(Model model) {
		model.addAttribute("ninjas", this.appService.allNinjas());
		return "ninjaHome.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String New(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", this.appService.allDojos());
		return "newNinja.jsp";
	}
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", this.appService.allDojos());
			return "newNinja.jsp";
		}
		this.appService.createNinja(ninja);
		return "redirect:/ninjas";
	}
}
