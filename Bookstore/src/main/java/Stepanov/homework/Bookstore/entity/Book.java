package Stepanov.homework.Bookstore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(nullable = false)
    private Author author;

    @Column
    private Integer year_of_publication;

    @Column
    private Integer pages;

    @Column(nullable = false)
    private Integer price;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderingDetails> orderingDetails;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", year_of_publication=" + year_of_publication +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}
