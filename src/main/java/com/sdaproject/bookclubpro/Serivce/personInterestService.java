package com.sdaproject.bookclubpro.Serivce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sdaproject.bookclubpro.Entity.Genre;
import com.sdaproject.bookclubpro.Entity.personInterest;
import com.sdaproject.bookclubpro.Repository.personInterestRepo;

@Service
public class personInterestService {

    personInterestRepo pers;

    public personInterestService(personInterestRepo pers) {
        this.pers = pers;
    }

    public void saveMe(Long userid, Genre g1, Genre g2, Genre g3) {
        personInterest p = new personInterest();
        p.setGenre1(g1);
        p.setGenre2(g2);
        p.setGenre3(g3);
        p.setUserid(userid);

        pers.save(p);
    }

    public void saveMe(Long userid, List<Genre> gList) {

        personInterest person = new personInterest();

        if (gList.size() >= 1) {
            person.setGenre1(gList.get(0));
            if (gList.size() >= 2) {
                person.setGenre2(gList.get(1));
                if (gList.size() >= 3) {
                    person.setGenre3(gList.get(2));
                }
            }
        }
        person.setUserid(userid);

        pers.save(person);
    }

    public List<Genre> getPersonInterest(Long userid) {

        personInterest p = pers.getByIdR(userid);

        List<Genre> myList = new ArrayList<>();

        if (p.getGenre1() != null) {
            myList.add(p.getGenre1());
        } else if (p.getGenre2() != null) {
            myList.add(p.getGenre2());
        } else if (p.getGenre3() != null) {
            myList.add(p.getGenre3());
        }

        return myList;
    }

    public Genre getById_genre1(Long id) {
        return pers.getByIdR_genre1(id);
    }

    public Genre getById_genre2(Long id) {
        return pers.getByIdR_genre2(id);
    }

    public Genre getById_genre3(Long id) {
        return pers.getByIdR_genre3(id);
    }
}
