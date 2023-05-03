package com.sdaproject.bookclubpro.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tagline", nullable = false)
    private String tagline;

    @Column(name = "creationDate", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    @Column(name = "genreList", nullable = false)
    private List<Genre> genreList;

    // private List<Person> memberList;

    // private ReadingList readingList;

    // private List<Person> joinRequestList;

    // private Meeting meetingList;

    // private DiscussionForum discussionForum;

    public Club() {
        genreList = new ArrayList<>();
    }

    public Club(String name, String tagline, Date creationDate) {
        this.name = name;
        this.tagline = tagline;
        this.creationDate = creationDate;
    }

    public Club(Long id, String name, String tagline, Date creationDate,
            List<Genre> genreList) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.creationDate = creationDate;
        this.genreList = genreList;
    }

    // public Club(Long id, String name, String tagline, Date creationDate,
    // List<Person> memberList, ReadingList readingList,
    // List<Person> joinRequestList, List<Genre> genreList, Meeting meetingList,
    // DiscussionForum discussionForum) {
    // this.id = id;
    // this.name = name;
    // this.tagline = tagline;
    // this.creationDate = creationDate;
    // this.memberList = memberList;
    // this.readingList = readingList;
    // this.joinRequestList = joinRequestList;
    // this.genreList = genreList;
    // this.meetingList = meetingList;
    // this.discussionForum = discussionForum;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    // public List<Person> getMemberList() {
    // return memberList;
    // }

    // public void setMemberList(List<Person> memberList) {
    // this.memberList = memberList;
    // }

    // public ReadingList getReadingList() {
    // return readingList;
    // }

    // public void setReadingList(ReadingList readingList) {
    // this.readingList = readingList;
    // }

    // public List<Person> getJoinRequestList() {
    // return joinRequestList;
    // }

    // public void setJoinRequestList(List<Person> joinRequestList) {
    // this.joinRequestList = joinRequestList;
    // }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    // public Meeting getMeetingList() {
    // return meetingList;
    // }

    // public void setMeetingList(Meeting meetingList) {
    // this.meetingList = meetingList;
    // }

    // public DiscussionForum getDiscussionForum() {
    // return discussionForum;
    // }

    // public void setDiscussionForum(DiscussionForum discussionForum) {
    // this.discussionForum = discussionForum;
    // }

}
