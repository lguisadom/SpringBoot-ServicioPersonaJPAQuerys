package com.lagm.springboot.app.personas.models.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagm.springboot.app.personas.models.dao.PersonaDao;
import com.lagm.springboot.app.personas.models.entity.Persona;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	PersonaDao personaDao;
	
	@Override
	public Persona findByStatusAndName(Integer status, String name) {
		return personaDao.findByStatusAndName(status, name);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findById(Long id) {
		return personaDao.findById(id).orElse(null);
	}

	@Override
	public Persona findByName(String nombre) {
		return personaDao.findByName(nombre);
	}

	@Override
	public List<Persona> findPersonsByNameList(Collection<String> names) {
		return personaDao.findPersonsByNameList(names);
	}

	@Override
	public List<Persona> findPersonsByLastnameList(List<String> lastnames) {
		return personaDao.findPersonsByLastnameList(lastnames);
	}

	@Override
	public List<Persona> findPersonsByLastnameAndStatus(String lastname, Integer status) {
		return personaDao.findPersonsByLastnameAndStatus(lastname, status);
	}

}
