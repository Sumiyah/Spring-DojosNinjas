package com.sumiyah.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sumiyah.dojosninjas.models.Dojo;
import com.sumiyah.dojosninjas.models.Ninja;
import com.sumiyah.dojosninjas.repositories.DojoRepository;
import com.sumiyah.dojosninjas.repositories.NinjaRepository;

@Service
public class DNService {

	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public DNService(DojoRepository dRepo, NinjaRepository nRepo) {
		this.dojoRepo = dRepo;
		this.ninjaRepo = nRepo;
	}
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	public Dojo findDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
}
