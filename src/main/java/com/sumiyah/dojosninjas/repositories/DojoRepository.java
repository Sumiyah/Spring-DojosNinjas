package com.sumiyah.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sumiyah.dojosninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();

}
