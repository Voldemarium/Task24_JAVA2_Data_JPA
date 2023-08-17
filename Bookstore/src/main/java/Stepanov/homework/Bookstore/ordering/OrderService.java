package Stepanov.homework.Bookstore.ordering;

import Stepanov.homework.Bookstore.entity.Ordering;
import Stepanov.homework.Bookstore.repository.OrderingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderingRepository orderingRepository;

    public OrderService(OrderingRepository orderingRepository) {
        this.orderingRepository = orderingRepository;
    }

    public Ordering createOrdering(Ordering ordering) {
        return orderingRepository.save(ordering);
    }

    public List<Ordering> getOrderings() {
        return orderingRepository.findAll();
    }

    public Ordering getOrderingById(Long id) {
        return orderingRepository.getById(id) ;
    }
}
