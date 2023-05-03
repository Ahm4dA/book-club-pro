package com.sdaproject.bookclubpro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdaproject.bookclubpro.Entity.Genre;
import com.sdaproject.bookclubpro.Entity.personInterest;

public interface personInterestRepo extends JpaRepository<personInterest, Long> {

    @Query(value = "SELECT TOP 1 p.* FROM personInterest p WHERE p.userid = ?1", nativeQuery = true)
    public personInterest getByIdR(Long userid);

    @Query(value = "SELECT TOP 1 p.genre1 FROM personInterest p WHERE p.userid = ?1", nativeQuery = true)
    public Genre getByIdR_genre1(Long userid);

    @Query(value = "SELECT TOP 1 p.genre2 FROM personInterest p WHERE p.userid = ?1", nativeQuery = true)
    public Genre getByIdR_genre2(Long userid);

    @Query(value = "SELECT TOP 1 p.genre3 FROM personInterest p WHERE p.userid = ?1", nativeQuery = true)
    public Genre getByIdR_genre3(Long userid);
}
