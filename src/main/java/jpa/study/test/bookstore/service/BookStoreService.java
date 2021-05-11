package jpa.study.test.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import jpa.study.test.bookstore.dao.BookStoreRepository;
import jpa.study.test.bookstore.domain.BookStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;


    public BookStore save(BookStore bookStore){
        return bookStoreRepository.save(bookStore);
    }

    public List<String> bookNameList(){
        List<BookStore> byId = bookStoreRepository.findAllEntityGraph();

        return byId.stream().map(b->b.getBookList().get(0).getTitle())
            .collect(Collectors.toList());
    }

}
