package com.rodrigofujioka.dev.web.rest;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofujioka.dev.web.domain.Person;
import com.rodrigofujioka.dev.web.service.PersonService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class PersonRest {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/person")
	public ResponseEntity<Person> salvar(@RequestBody @Valid Person person) {
		return ResponseEntity.ok(personService.salvar(person));
	}
	
	@PutMapping("/person")
	public ResponseEntity<Person> update(@RequestBody @Valid Person person) {
		return ResponseEntity.ok(personService.update(person));
	}
	

	@GetMapping("/person/{id}")
	public ResponseEntity<Person> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(personService.consultaPorId(id));
	}
	
	@GetMapping("/person/{firstName}")
	public ResponseEntity<List<Person>> getPersonByFirstName(@PathVariable String firstName) {
		return ResponseEntity.ok(personService.getPersonByFirstName(firstName));
	}
	
	@GetMapping("/person/{lastName}")
	public ResponseEntity<List<Person>> getPersonByLastName(@PathVariable String lastName) {
		return ResponseEntity.ok(personService.getPersonByLastName(lastName));
	}
	
	@GetMapping("/person/{email}")
	public ResponseEntity<List<Person>> getPersonByEmail(@PathVariable String email) {
		return ResponseEntity.ok(personService.getPersonByEmail(email));
	}
	
	@GetMapping("/person/{phoneNumber}")
	public ResponseEntity<List<Person>> getPersonByPhoneNumber(@PathVariable String phoneNumber) {
		return ResponseEntity.ok(personService.getPersonByPhoneNumber(phoneNumber));
	}
	
	@GetMapping("/person/{hireDate}")
	public ResponseEntity<List<Person>> getPersonByHireDate(@PathVariable Date hireDate) {
		return ResponseEntity.ok(personService.getPersonByHireDate(hireDate));
	}
	
	@GetMapping("/person")
	public ResponseEntity<List<Person>> listar() {
		return ResponseEntity.ok(personService.listar());
	}

	@DeleteMapping("/person/{id}")
	public ResponseEntity<Person> deletePorId(@PathVariable Long id) {
		try {
			personService.deletePorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
