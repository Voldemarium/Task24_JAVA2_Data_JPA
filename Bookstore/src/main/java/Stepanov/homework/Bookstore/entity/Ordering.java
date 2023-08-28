package Stepanov.homework.Bookstore.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private Buyer buyer;

    @OneToMany(mappedBy = "ordering", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<OrderingDetails> orderingDetailsList;

    @Column
    private Integer purchase_amount;

    @PrePersist
    @PreUpdate
    @PostLoad
    private void postLoad() {
        this.purchase_amount = orderingDetailsList.stream()
                .map(o -> (o.getQuantity() * o.getBook().getPrice()))
                .reduce(Integer::sum).orElse(null);
    }

    @Override
    public String toString() {
        return "Ordering{" +
                "id=" + id +
                ", buyer=" + buyer.getId() +
                ", orderingDetailsList=" + orderingDetailsList +
                ", purchase_amount=" + purchase_amount +
                '}';
    }

}
