package com.sdaproject.bookclubpro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sdaproject.bookclubpro.Entity.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {

    @Query(value = "select * from Club c where c.name = :name", nativeQuery = true)
    public List<Club> findByNameR(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO clubmember(userid, clubid, role) VALUES(?1, ?2, 1)", nativeQuery = true)
    public int saveMemberOnCreate(Long userid, Long clubid);

    @Query(value = "SELECT TOP 1 c.* FROM Club c where c.name = ?1", nativeQuery = true)
    public Club getByNameR(String name);

    @Query(value = "SELECT TOP 1 c.clubid from clubmember c where c.userid = ?1", nativeQuery = true)
    public List<Long> checkIfUserInClubR(Long id);

    @Query(value = "SELECT c.* FROM Club c WHERE c.id = ?1", nativeQuery = true)
    public Club getByIdR(Long id);
}
