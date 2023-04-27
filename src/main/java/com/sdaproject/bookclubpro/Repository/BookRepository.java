package com.sdaproject.bookclubpro.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sdaproject.bookclubpro.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM Book b where b.id IN(SELECT bk.bookid FROM bookbelongto bk WHERE bk.userid = ?1)", nativeQuery = true)
    public List<Book> getBookListR(@Param("id") Long id);

    @Query(value = "DELETE FROM bookbelongto WHERE userid = ?1 AND bookid = ?2", nativeQuery = true)
    public void removeBookFromListR(Long userid, Long bookid);

    @Query(value = "SELECT DISTINCT * FROM Book b WHERE b.title LIKE %:word% OR b.publisherName LIKE %:word% OR b.author LIKE %:word%", nativeQuery = true)
    public List<Book> getBookByWord(@Param("word") String word);

    @Modifying
    @Query(value = "INSERT INTO bookbelongto(userid, bookid) VALUES(:pId, :bId)", nativeQuery = true)
    public int saveBookToPersonR(@Param("pId") Long pId, @Param("bId") Long bId);
}
