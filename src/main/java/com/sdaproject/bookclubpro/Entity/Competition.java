package com.sdaproject.bookclubpro.Entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tagline", nullable = false)
    private String tagline;

    @Transient
    private List<Book> bookList;

    @Column(name = "startingDate", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startingDate;

    @Column(name = "endingDate", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endingDate;

    @Transient
    private List<Person> participantList;

    @Column(name = "judge", nullable = true)
    private Long judge;

    @Transient
    private List<Float> score;

    public Competition() {
    }

    public Competition(Long id, String name, String tagline, Date startingDate, Date endingDate, Long judge) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.judge = judge;
    }

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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public List<Person> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Person> participantList) {
        this.participantList = participantList;
    }

    public Long getJudge() {
        return judge;
    }

    public void setJudge(Long judge) {
        this.judge = judge;
    }

    public List<Float> getScore() {
        return score;
    }

    public void setScore(List<Float> score) {
        this.score = score;
    }

}
