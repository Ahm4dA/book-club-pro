package com.sdaproject.bookclubpro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdaproject.bookclubpro.Entity.DiscussionForum;

public interface DiscussionForumRepository extends JpaRepository<DiscussionForum, Long> {

    @Query(value = "SELECT d.* from DiscussionForum d WHERE d.clubid = ?1", nativeQuery = true)
    public List<DiscussionForum> getAllMessages(Long clubid);
}
