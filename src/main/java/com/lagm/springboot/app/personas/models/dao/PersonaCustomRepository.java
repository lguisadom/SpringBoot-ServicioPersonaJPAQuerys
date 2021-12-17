package com.lagm.springboot.app.personas.models.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lagm.springboot.app.personas.models.entity.Persona;

public interface PersonaCustomRepository {
	// Indexed Query parameters
	// Spring Data will pass method parameters to the query in the same order they appear in the method declaration
	@Query("select p from Persona p where p.nombre = ?2 and p.status = ?1")
	public Persona findByStatusAndName(Integer status, String name);
	
	// Named parameters
	@Query("select p from Persona p where p.nombre = :nombre")
	public Persona findByName(@Param("nombre") String nombre);
	
	@Query("select p from Persona p where p.nombre = :nombre")
	public Persona findByName2(@Param("nombre") String nombre);
	
	@Query("select p from Persona p where p.nombre in :names")
	public List<Persona> findPersonsByNameList(@Param("names") Collection<String> names);
	
	@Query("select p from Persona p where p.apellido in :lastnames")
	public List<Persona> findPersonsByLastnameList(@Param("lastnames") List<String> lastnames);
	
	@Query("select p from Persona p where p.apellido = :lastname and p.status = :status")
	public List<Persona> findPersonsByLastnameAndStatus(@Param("lastname") String personLastname, @Param("status") Integer personStatus);
}
