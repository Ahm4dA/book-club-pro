// package com.sdaproject.bookclubpro.Entity;

// import java.util.Date;
// import java.util.List;

// import org.springframework.format.annotation.DateTimeFormat;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "Club")
// public class Club {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// @Column(name = "id", nullable = false)
// private Long id;

// @Column(name = "name", nullable = false)
// private String name;

// @Column(name = "tagline", nullable = false)
// private Long tagline;

// @Column(name = "creationDate", nullable = false)
// @DateTimeFormat(pattern = "yyyy-MM-dd")
// private Date creationDate;

// private ReadingList readingList;

// private List<User> joinRequestList;

// }
