package Stepanov.homework.Bookstore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private Book book;

    @Column
    private Integer balance;

    @Override
    public String toString() {
        return "BookWarehouse{" +
                "id=" + id +
                ", book=" + book.getId() +
                ", balance=" + balance +
                '}';
    }
}
