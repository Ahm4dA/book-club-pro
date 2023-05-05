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
    @Query(value = "INSERT INTO competitionLinks VALUES(?1, ?2, ?3, 0.0)", nativeQuery = true)
    public void uploadComplete(Long userId, Long competitionId, Long bookId);

    @Query(value = "SELECT userid from competitionLinks where userid = ?1 and competitionid = ?2", nativeQuery = true)
    public Long checkIfAlreadyIn(Long userId, Long compId);

    @Query(value = "SELECT c.* from Competition c where c.judge = ?1", nativeQuery = true)
    public List<Competition> getByJudge(Long id);

    @Query(value = "UPDATE competitionLinks c SET c.score = ?4 where c.userid = ?1 and c.competitionid = ?2 and c.bookid = ?3", nativeQuery = true)
    public void updateScore(Long userid, Long compid, Long bookid, Float score);
}
