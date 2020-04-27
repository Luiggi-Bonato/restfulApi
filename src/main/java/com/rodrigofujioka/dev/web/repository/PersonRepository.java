package com.rodrigofujioka.dev.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigofujioka.dev.web.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	List<Person> findPersonById(Long id);
	
	List<Person> findPersonByFirstName(String firstName);
	
	List<Person> findPersonByLastName(String lastName);
	
	List<Person> findPersonByEmail(String email);
	
	List<Person> findPersonByPhoneNumber(String phoneNumber);
	
	List<Person> findPersonByHireDate(Date hireDate);

}
