package com.sdaproject.bookclubpro.Serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdaproject.bookclubpro.Entity.Person;
import com.sdaproject.bookclubpro.Repository.PersonRepository;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonData(Person p) {

        return personRepository.getPersonDataR(p.getEmail(), p.getPassword());
    }

    public int getType(Person p) {
        return personRepository.getTypeR(p.getId());
    }

    public void savePerson(Person p) {
        personRepository.save(p);
    }

    public void setPersonType(Long id, int pType) {
        personRepository.setPersonType(id, pType);
    }

}
