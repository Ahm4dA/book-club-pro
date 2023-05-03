package com.sdaproject.bookclubpro.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personInterest")
public class personInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "userid", nullable = false)
    private Long userid;

    @Column(name = "genre1", nullable = true)
    private Genre genre1;

    @Column(name = "genre2", nullable = true)
    private Genre genre2;

    @Column(name = "genre3", nullable = true)
    private Genre genre3;

    public personInterest() {
    }

    public personInterest(Long id, Long userid, Genre genre1, Genre genre2, Genre genre3) {
        this.id = id;
        this.userid = userid;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Genre getGenre1() {
        return genre1;
    }

    public void setGenre1(Genre genre1) {
        this.genre1 = genre1;
    }

    public Genre getGenre2() {
        return genre2;
    }

    public void setGenre2(Genre genre2) {
        this.genre2 = genre2;
    }

    public Genre getGenre3() {
        return genre3;
    }

    public void setGenre3(Genre genre3) {
        this.genre3 = genre3;
    }

}
