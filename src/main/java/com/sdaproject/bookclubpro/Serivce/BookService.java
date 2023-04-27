package com.sdaproject.bookclubpro.Serivce;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdaproject.bookclubpro.Entity.Book;
import com.sdaproject.bookclubpro.Entity.Person;
import com.sdaproject.bookclubpro.Repository.BookRepository;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getBookList(Long id) {
        return bookRepository.getBookListR(id);
    }

    public void removeBookFromList(Long userid, Long bookid) {
        bookRepository.removeBookFromListR(userid, bookid);
    }

    public List<Book> getBookWhenSearched(String wordSearched) {

        return bookRepository.getBookByWord(wordSearched);
    }

    public int saveBookToPerson(Long personId, Long Bookid) {
        return bookRepository.saveBookToPersonR(personId, Bookid);
    }

    // public void addBookToUser(Person p, Book b) {

    // bookRepository.saveBookToRelationTable(p.getId(), b.getId());
    // }

}
