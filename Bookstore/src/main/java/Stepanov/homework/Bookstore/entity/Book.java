package Stepanov.homework.Bookstore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToMany (mappedBy = "bookSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                 fetch = FetchType.EAGER)
    Set<Author> authorSet = new HashSet<>();

    @Column
    private Integer year_of_publication;

    @Column
    private Integer pages;

    @Column(nullable = false)
    private Integer price;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderingDetails> orderingDetails;
}
