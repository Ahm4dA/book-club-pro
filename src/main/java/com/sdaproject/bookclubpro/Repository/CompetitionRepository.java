package com.sdaproject.bookclubpro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sdaproject.bookclubpro.Entity.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    @Query(value = "SELECT c.* FROM Competition c", nativeQuery = true)
    public List<Competition> getAll();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO competitionLinks VALUES(?1, ?2, ?3)", nativeQuery = true)
    public void uploadComplete(Long userId, Long competitionId, Long bookId);

    @Query(value = "SELECT userid from competitionLinks where userid = ?1 and competitionid = ?2", nativeQuery = true)
    public Long checkIfAlreadyIn(Long userId, Long compId);
}
