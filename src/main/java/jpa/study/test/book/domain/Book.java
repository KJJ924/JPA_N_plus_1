package jpa.study.test.book.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import jpa.study.test.bookstore.domain.BookStore;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int price;

    @ManyToOne
    @JoinColumn(name = "bookstore_id")
    private BookStore bookStore;

    @Builder
    private Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void update(BookStore bookStore) {
        this.bookStore =bookStore;
    }
}
