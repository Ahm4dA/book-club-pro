package com.sdaproject.bookclubpro.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "pageCount", nullable = false)
    private Long pageCount;

    @Column(name = "edition", nullable = false)
    private String edition;

    @Column(name = "publisherName", nullable = false)
    private String publisherName;

    @Column(name = "reviewList", nullable = false)
    private String reviewList;

    @Column(name = "genre", nullable = false)
    private Genre genre;

    @Column(name = "rating", nullable = false)
    private double rating;

    public Book() {

    }

    public Book(Long id, String title, String author, Long pageCount, String edition, String publisherName,
            String reviewList, Genre genre, double rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.edition = edition;
        this.publisherName = publisherName;
        this.reviewList = reviewList;
        this.genre = genre;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getReviewList() {
        return reviewList;
    }

    public void setReviewList(String reviewList) {
        this.reviewList = reviewList;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}
