package Stepanov.homework.Bookstore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@RequiredArgsConstructor
public class BookWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private Book book;

    @Column
    private Integer balance;

}
