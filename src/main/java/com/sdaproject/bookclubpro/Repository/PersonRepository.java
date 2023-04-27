package com.sdaproject.bookclubpro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sdaproject.bookclubpro.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT TOP 1 p.* from person p WHERE p.email = ?1 AND p.password = ?2", nativeQuery = true)
    public Person getPersonDataR(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT TOP 1 p.personType from person p WHERE p.id = ?1", nativeQuery = true)
    public int getTypeR(@Param("id") Long id);

    @Query(value = "UPDATE person p SET p.personType = ?2 WHERE p.id = ?1", nativeQuery = true)
    public int setPersonType(@Param("id") Long id, @Param("personType") int personType);
}
