package com.lagm.springboot.app.personas.models.service;

import java.util.Collection;
import java.util.List;

import com.lagm.springboot.app.personas.models.entity.Persona;

public interface IPersonaService {
	public List<Persona> findAll();
	public Persona findById(Long id);
	public Persona findByStatusAndName(Integer status, String name);
	public Persona findByName(String nombre);
	public List<Persona> findPersonsByNameList(Collection<String> names);
	public List<Persona> findPersonsByLastnameList(List<String> lastnames);
	public List<Persona> findPersonsByLastnameAndStatus(String lastname, Integer status);
}
