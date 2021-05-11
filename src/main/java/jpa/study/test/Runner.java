package jpa.study.test;

import jpa.study.test.book.dao.BookRepository;
import jpa.study.test.book.domain.Book;
import jpa.study.test.bookstore.domain.BookStore;
import jpa.study.test.bookstore.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class Runner implements ApplicationRunner {

    private final BookStoreService bookStoreService;
    private final BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 10; i++) {
            BookStore save = bookStoreService.save(createBookStore(i));
            for (int j = 0; j < 10; j++) {
                save.addBook(bookRepository.save(createBook(j)));
            }
        }

    }

    private BookStore createBookStore(int i){
        return BookStore.builder().name("동네 서점"+i).build();
    }

    private Book createBook(int i ){
        return Book.builder()
            .author("저자"+i)
            .price(i)
            .title("책이름"+i)
            .build();
    }
}
