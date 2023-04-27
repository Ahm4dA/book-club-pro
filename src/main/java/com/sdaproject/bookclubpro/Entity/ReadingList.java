package com.sdaproject.bookclubpro.Entity;

import java.util.ArrayList;
import java.util.List;

public class ReadingList {

    private int numberOfBook;
    private List<Book> bookList;

    public void setNumberOfBook(int number) {
        this.numberOfBook = number;
    }

    public int getNumberOfBook() {
        return this.numberOfBook;
    }

    public void setBookList(List<Book> bookListM) {

        this.bookList = bookListM;
        this.setNumberOfBook(bookListM.size());
    }

    public boolean addBook(Long id) {

        for (int i = 0; i < bookList.size(); i++) {

            if (bookList.get(i).getId() == id)
                return false;
        }

        // Implement a method to add book

        return true;
    }

    public void addBookCall() {

        // implement later
    }

    public void removeBook(Long id) {

        for (int i = 0; i < bookList.size(); i++) {

            if (bookList.get(i).getId() == id) {

                // implement deletion here
            }
        }
    }

    public void manageList() {

        // implement later
    }

    public List<Book> getList() {
        return this.bookList;
    }

    public List<Book> getListByName(String name) {

        ArrayList<Book> newBookList = new ArrayList<>();

        for (int i = 0; i < this.bookList.size(); i++) {

            if (this.bookList.get(i).getTitle().contains(name) == true) {

                newBookList.add(this.bookList.get(i));
            }
        }

        return newBookList;
    }
}
