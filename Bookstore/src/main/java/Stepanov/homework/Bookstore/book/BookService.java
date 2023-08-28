package Stepanov.homework.Bookstore.book;

import Stepanov.homework.Bookstore.entity.Book;
import Stepanov.homework.Bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Set<Book> findAll() {
        Set<Book> bookSet = new HashSet<>();
        Iterable<Book> books = bookRepository.findAll();
        books.forEach(bookSet::add);
        return bookSet;
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
