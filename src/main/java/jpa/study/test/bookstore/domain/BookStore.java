package jpa.study.test.bookstore.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import jpa.study.test.book.domain.Book;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Getter
@Setter
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "bookstore_id")
    private List<Book> bookList = new ArrayList<>();

    @Builder
    public BookStore(String name, List<Book> bookList) {
        this.name = name;
        if (bookList != null) {
            this.bookList = bookList;
        }
    }

    public void addBook(Book book) {
        this.bookList.add(book);
        book.update(this);
    }
}
