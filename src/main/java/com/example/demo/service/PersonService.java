package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


/*
 * servis klasi romelshic sheqmnilia bazis interfeisi da misi romelime implementacia aris sheqmnili
 * "aq iwereba biznes logika"
 */
@Service
public class PersonService {
	private final PersonDao personDao;

	@Autowired
	public PersonService(@Qualifier("FakeDao") PersonDao personDao) {
		this.personDao = personDao;
	}

	public int addPerson(Person person){
		return personDao.addPerson(person);
	}

	public Optional<Person> getPersonById(UUID id){
		System.out.println(id);
		Optional<Person> pn = personDao.selectPersonById(id);
		System.out.println(pn.toString());
		return pn;
	}

	public List<Person> getAllPeople(){
		return personDao.selectAllPeople();
	}

	public int deletePerson(UUID id){
		return personDao.delletPersonById(id);
	}

	public int updatePerson(UUID id, Person person){
		return  personDao.updatePersonById(id, person);
	}
}