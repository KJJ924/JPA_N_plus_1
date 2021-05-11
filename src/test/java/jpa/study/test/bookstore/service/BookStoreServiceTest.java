package jpa.study.test.bookstore.service;



import static org.assertj.core.api.Assertions.*;

import java.util.List;

import jpa.study.test.book.dao.BookRepository;

import jpa.study.test.bookstore.dao.BookStoreRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BookStoreServiceTest {

    @Autowired
    BookStoreService bookStoreService;
    @Autowired
    BookStoreRepository bookStoreRepository;
    @Autowired
    BookRepository bookRepository;



    @Test
    void findAll(){
        List<String> stringList = bookStoreService.bookNameList();
        assertThat(stringList.size()).isEqualTo(10);
    }

}