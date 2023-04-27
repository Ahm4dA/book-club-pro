package com.sdaproject.bookclubpro.Entity;

import java.util.Date;

public class Author extends Person {

    private String qualification;
    private double experience;
    private ReadingList readingList;

    public Author(Long id, String name, String email, String password, Date dOB,
            String gender, String qualification,
            double experience) {
        super(id, name, email, password, dOB, gender);
        this.qualification = qualification;
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public ReadingList getReadingList() {
        return readingList;
    }

    public void setReadingList(ReadingList readingList) {
        this.readingList = readingList;
    }

}
