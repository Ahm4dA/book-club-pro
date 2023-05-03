package com.sdaproject.bookclubpro.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DiscussionForum")
public class DiscussionForum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "userid", nullable = false)
    private Long userid;

    @Column(name = "clubid", nullable = false)
    private Long clubid;

    public DiscussionForum(String message, Long userid, Long clubid) {
        this.message = message;
        this.userid = userid;
        this.clubid = clubid;
    }

    public DiscussionForum() {
    }

    public DiscussionForum(Long id, String message, Long userid, Long clubid) {
        this.id = id;
        this.message = message;
        this.userid = userid;
        this.clubid = clubid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getClubid() {
        return clubid;
    }

    public void setClubid(Long clubid) {
        this.clubid = clubid;
    }

}