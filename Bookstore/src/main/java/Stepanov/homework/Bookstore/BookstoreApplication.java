package Stepanov.homework.Bookstore;

import Stepanov.homework.Bookstore.author.AuthorService;
import Stepanov.homework.Bookstore.book.BookService;
import Stepanov.homework.Bookstore.bookWarehouse.BookWarehouseService;
import Stepanov.homework.Bookstore.buyer.BuyerService;
import Stepanov.homework.Bookstore.entity.*;
import Stepanov.homework.Bookstore.ordering.OrderService;
import Stepanov.homework.Bookstore.ordering_details.OrderingDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class BookstoreApplication {

    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookstoreApplication.class, args);

        AuthorService authorService = context.getBean(AuthorService.class);
        BookService bookService = context.getBean(BookService.class);
        BookWarehouseService bookWarehouseService = context.getBean(BookWarehouseService.class);
        BuyerService buyerService = context.getBean(BuyerService.class);
        OrderService orderService = context.getBean(OrderService.class);
        OrderingDetailsService orderingDetailsService = context.getBean(OrderingDetailsService.class);

        Author author = new Author();
        author.setSurname("Petrov");
        author.setName("Ivan");
        author.setMiddle_name("Ivanovich");
        authorService.createAuthor(author);

        Book book = new Book();
        book.setTitle("Summer");
        book.setAuthor(authorService.getAuthorById(1L));
        book.setYear_of_publication(2002);
        book.setPages(220);
        book.setPrice(600);
        bookService.createBook(book);

        BookWarehouse bookWarehouse = new BookWarehouse();
        bookWarehouse.setBook(bookService.getBookById(1L));
        bookWarehouse.setBalance(4);
        bookWarehouseService.createBookWarehouse(bookWarehouse);


        //   buyerService.createBuyer(new Buyer("Kozlov", "Vlad", "Ivanovich", LocalDate.of(1999, 1, 1)));
//        buyerService.createBuyer(Buyer.builder()
//                .surname("Kozlov")
//                .name("Vlad")
//                .middle_name("Ivanovich")
//                .birth_date(LocalDate.of(1999, 1, 1))
//                .build());

    }
}