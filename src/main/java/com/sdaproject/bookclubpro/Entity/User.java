// package com.sdaproject.bookclubpro.Entity;

// import java.util.Date;
// import java.util.List;

// import jakarta.persistence.DiscriminatorValue;
// import jakarta.persistence.Entity;
// import jakarta.persistence.MappedSuperclass;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "person")
// @DiscriminatorValue(value = "1")
// @MappedSuperclass
// public class User extends Person {

// private ReadingList readingList;
// private List<Genre> interest;

// public User(Long id, String name, String email, String password, Date dOB,
// String gender, ReadingList readingList,
// List<Genre> interest) {
// super(id, name, email, password, dOB, gender);
// this.readingList = readingList;
// this.interest = interest;
// }

// public ReadingList getReadingList() {
// return readingList;
// }

// public void setReadingList(ReadingList readingList) {
// this.readingList = readingList;
// }

// public List<Genre> getInterest() {
// return interest;
// }

// public void setInterest(List<Genre> interest) {
// this.interest = interest;
// }

// }
