package com.sdaproject.bookclubpro.Serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdaproject.bookclubpro.Entity.Book;
import com.sdaproject.bookclubpro.Entity.Genre;
import com.sdaproject.bookclubpro.Entity.Person;
import com.sdaproject.bookclubpro.Repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
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

    public List<Book> getBookListByGenre(Genre g1, Genre g2, Genre g3, Long userid) {

        if (g1 != null && g2 != null && g3 != null) {
            return bookRepository.getBookListByGenreR(g1, g2, g3, userid);

        } else if (g1 != null && g2 != null) {
            return bookRepository.getBookListByGenreR(g1, g2, userid);
        } else {
            return bookRepository.getBookListByGenreR(g1, userid);
        }
    }

    public Long getLastBook() {
        return bookRepository.getLastBookR();
    }
    // public void addBookToUser(Person p, Book b) {

    // bookRepository.saveBookToRelationTable(p.getId(), b.getId());
    // }

}
