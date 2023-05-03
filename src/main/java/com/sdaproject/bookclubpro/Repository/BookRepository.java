package com.sdaproject.bookclubpro.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sdaproject.bookclubpro.Entity.Book;
import com.sdaproject.bookclubpro.Entity.Genre;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM Book b where b.id IN(SELECT bk.bookid FROM bookbelongto bk WHERE bk.userid = ?1)", nativeQuery = true)
    public List<Book> getBookListR(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bookbelongto WHERE userid = ?1 AND bookid = ?2", nativeQuery = true)
    public void removeBookFromListR(Long userid, Long bookid);

    @Query(value = "SELECT DISTINCT * FROM Book b WHERE b.title LIKE %:word% OR b.publisherName LIKE %:word% OR b.author LIKE %:word%", nativeQuery = true)
    public List<Book> getBookByWord(@Param("word") String word);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO bookbelongto(userid, bookid) VALUES(:pId, :bId)", nativeQuery = true)
    public int saveBookToPersonR(@Param("pId") Long pId, @Param("bId") Long bId);

    @Query(value = "SELECT b.* from Book b WHERE b.genre = ?1 AND b.id NOT IN(SELECT c.bookid from bookbelongto c WHERE c.userid = ?2);", nativeQuery = true)
    public List<Book> getBookListByGenreR(Genre g1, Long userid);

    @Query(value = "SELECT b.* from Book b WHERE (b.genre = ?1 OR b.genre = ?2) AND b.id NOT IN(SELECT c.bookid from bookbelongto c WHERE c.userid = ?3);", nativeQuery = true)
    public List<Book> getBookListByGenreR(Genre g1, Genre g2, Long userid);

    @Query(value = "SELECT b.* from Book b WHERE (b.genre = ?1 OR b.genre = ?2 OR b.genre = ?3) AND b.id NOT IN(SELECT c.bookid from bookbelongto c WHERE c.userid = ?4);", nativeQuery = true)
    public List<Book> getBookListByGenreR(Genre g1, Genre g2, Genre g3, Long userid);
}
