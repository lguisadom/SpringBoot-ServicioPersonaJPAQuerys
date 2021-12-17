package com.lagm.springboot.app.personas.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.lagm.springboot.app.personas.models.entity.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long>, PersonaCustomRepository {
	
}
