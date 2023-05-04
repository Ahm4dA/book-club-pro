package com.sdaproject.bookclubpro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sdaproject.bookclubpro.Entity.Genre;
import com.sdaproject.bookclubpro.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT TOP 1 p.* from person p WHERE p.email = ?1 AND p.password = ?2", nativeQuery = true)
    public Person getPersonDataR(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT TOP 1 p.personType from person p WHERE p.id = ?1", nativeQuery = true)
    public int getTypeR(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE person SET personType = ?2 WHERE id = ?1", nativeQuery = true)
    public int setPersonType(@Param("id") Long id, @Param("personType") int personType);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO personInterest(userid, interest) VALUES(?1, ?2)", nativeQuery = true)
    public void createInstanceOfPersonInterest(Long userid, List<Genre> interest);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO personInterest(userid) VALUES(?1)", nativeQuery = true)
    public void createInstanceOfPersonInterestWithoutInterest(Long userid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE personInterest p SET p.genre1 = ?2 WHERE p.userid = ?1", nativeQuery = true)
    public void setInterestR(Long userid, Genre g1);

    @Transactional
    @Modifying
    @Query(value = "UPDATE personInterest p SET p.genre1 = ?2, p.genre2 = ?3 WHERE p.userid = ?1", nativeQuery = true)
    public void setInterestR(Long userid, Genre g1, Genre g2);

    @Transactional
    @Modifying
    @Query(value = "UPDATE personInterest p SET p.genre1 = ?2, p.genre2 = ?3, p.genre3 = ?4 WHERE p.userid = ?1", nativeQuery = true)
    public void setInterestR(Long userid, Genre g1, Genre g2, Genre g3);
}
