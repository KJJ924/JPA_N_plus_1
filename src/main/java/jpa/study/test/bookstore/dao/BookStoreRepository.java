package jpa.study.test.bookstore.dao;

import java.util.List;
import jpa.study.test.bookstore.domain.BookStore;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookStoreRepository extends JpaRepository<BookStore,Long> {

    @Query("select distinct b from BookStore b  join fetch b.bookList")
    List<BookStore> findAllFetchJoin();

    @EntityGraph(attributePaths = "bookList")
    @Query("select b from BookStore b")
    List<BookStore> findAllEntityGraph();
}
