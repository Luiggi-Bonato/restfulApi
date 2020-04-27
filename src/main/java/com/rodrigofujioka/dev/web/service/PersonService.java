package com.rodrigofujioka.dev.web.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigofujioka.dev.web.domain.Person;
import com.rodrigofujioka.dev.web.repository.PersonRepository;


import javassist.NotFoundException;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person salvar(Person person) {
		return personRepository.save(person);
	}
	
	public Person consultaPorId(Long id) {
		return personRepository.findById(id).get();
	}
	
	public List<Person> getPersonByFirstName(String firstName) {
		return personRepository.findPersonByFirstName(firstName);
	}
	
	public List<Person> getPersonByLastName(String lastName) {
		return personRepository.findPersonByLastName(lastName);
	}
	
	public List<Person> getPersonByEmail(String email) {
		return personRepository.findPersonByEmail(email);
	}
	
	public List<Person> getPersonByPhoneNumber(String phoneNumber) {
		return personRepository.findPersonByPhoneNumber(phoneNumber);
	}
	
	public List<Person> getPersonByHireDate(Date hireDate) {
		return personRepository.findPersonByHireDate(hireDate);
	}
	
	public void deletePorId(Long id) {
		personRepository.deleteById(id);
	}
	
	public List<Person> listar(){
		return personRepository.findAll();
	}
	
	public Person update(Person person) {
		if(person!=null) {
			return personRepository.save(person);
		}
		throw new RuntimeException("Id precisa ser informado");
	}

}
