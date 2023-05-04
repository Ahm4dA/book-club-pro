package com.sdaproject.bookclubpro.Serivce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdaproject.bookclubpro.Entity.Genre;
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

    public void savePersonWithInterest(Person p, List<Genre> interest) {
        personRepository.save(p);
        p = personRepository.getPersonDataR(p.getEmail(), p.getPassword());
        personRepository.createInstanceOfPersonInterest(p.getId(), interest);
    }

    public void setPersonType(Long id, int pType) {
        personRepository.setPersonType(id, pType);
    }

    public void setInterest(Long userid, List<Genre> interest) {

        if (interest.size() == 1) {
            personRepository.setInterestR(userid, interest.get(0));
        } else if (interest.size() == 2) {
            personRepository.setInterestR(userid, interest.get(0), interest.get(1));
        } else {
            personRepository.setInterestR(userid, interest.get(0), interest.get(1), interest.get(2));
        }
    }

}
