package Stepanov.homework.Bookstore.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(nullable = false)
    private Ordering ordering;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @Column
    private Integer price;

    @Column
    private Integer quantity;

    @PrePersist //выполнение перед сохранением объекта в БД
    @PreUpdate //выполнение перед обновлением объекта в БД
    @PostLoad  //выполнение загрузки объекта из БД
    private void priceUpdate() {
        if (book != null) {
            this.price = book.getPrice();
        } else {
            System.out.println("Book не загружен в OrderDetails!!");
        }
    }
    @Override
    public String toString() {
        return "OrderingDetails{" +
                "id=" + id +
                ", ordering=" + ordering.getId() +
                ", book=" + book.getId() +
                ", quantity=" + quantity +
                '}';
    }
}
