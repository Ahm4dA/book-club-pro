package com.sdaproject.bookclubpro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sdaproject.bookclubpro.Entity.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {

    @Query(value = "select * from Club c where c.name = :name", nativeQuery = true)
    public List<Club> findByNameR(@Param("name") String name);
}
