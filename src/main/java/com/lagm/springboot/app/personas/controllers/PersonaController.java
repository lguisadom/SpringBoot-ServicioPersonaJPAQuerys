package com.lagm.springboot.app.personas.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lagm.springboot.app.personas.models.entity.Persona;
import com.lagm.springboot.app.personas.models.service.IPersonaService;

@RestController
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	@GetMapping("/listar")
	public List<Persona> listar() {
		return personaService.findAll();
	}

	@GetMapping("/ver/{id}")
	public Persona detalle(@PathVariable Long id) {
		return personaService.findById(id);
	}

	@GetMapping("/porNombre/{nombre}")
	public Persona findByName(@PathVariable(name = "nombre") String nombrePersona) {
		return personaService.findByName(nombrePersona);
	}
	
	@GetMapping("/porNombres")
	public List<Persona> findPersonsByNameList(@RequestParam("names") Collection<String> names) {
		return personaService.findPersonsByNameList(names);
	}
	
	@GetMapping("/porApellidos")
	public List<Persona> findPersonsByLastnameList(@RequestParam("lastnames") List<String> lastnames) {
		return personaService.findPersonsByLastnameList(lastnames);
	}
	
	@GetMapping("/persona/{lastname}/{status}")
	public List<Persona> findPersonsByLastnameAndStatus(@PathVariable("lastname") String lastname, @PathVariable("status") Integer status) {
		return personaService.findPersonsByLastnameAndStatus(lastname, status);
	}
	
	@GetMapping("personaStatusName/{status}/{name}")
	public Persona findByStatusAndName(@PathVariable("status") Integer status, @PathVariable("name") String nombre) {
		return personaService.findByStatusAndName(status, nombre);
	}
}
