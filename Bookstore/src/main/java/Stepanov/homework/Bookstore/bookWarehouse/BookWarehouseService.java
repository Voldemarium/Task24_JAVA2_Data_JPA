package Stepanov.homework.Bookstore.bookWarehouse;

import Stepanov.homework.Bookstore.entity.Book;
import Stepanov.homework.Bookstore.entity.BookWarehouse;
import Stepanov.homework.Bookstore.repository.BookWarehouseRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookWarehouseService {

    private final BookWarehouseRepository bookWarehouseRepository;

    public BookWarehouseService(BookWarehouseRepository bookWarehouseRepository) {
        this.bookWarehouseRepository = bookWarehouseRepository;
    }

    public BookWarehouse createBookWarehouse(BookWarehouse bookWarehouse) {
        return bookWarehouseRepository.save(bookWarehouse);
    }

    public List<BookWarehouse> getBooks() {
        return bookWarehouseRepository.findAll();
    }

    public BookWarehouse findBookById(Long id) {
        return bookWarehouseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteBookById(Long id) {
        bookWarehouseRepository.deleteById(id);
    }
}
