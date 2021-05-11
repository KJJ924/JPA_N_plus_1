package jpa.study.test.bookstore.dao;

import jpa.study.test.bookstore.domain.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreRepository extends JpaRepository<BookStore,Long> {

    BookStore findByName(String name);
}
