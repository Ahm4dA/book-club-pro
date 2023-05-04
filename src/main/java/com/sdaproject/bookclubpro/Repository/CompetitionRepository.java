package com.sdaproject.bookclubpro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdaproject.bookclubpro.Entity.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    @Query(value = "SELECT c.* FROM Competition c", nativeQuery = true)
    public List<Competition> getAll();
}
