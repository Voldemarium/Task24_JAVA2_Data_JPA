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
import java.util.List;
import java.util.Set;

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

//        authorService.deleteAuthorById(3L);

        Author author = new Author();
        author.setSurname("Petrov2");
        author.setName("Ivan2");
        author.setMiddle_name("Ivanovich2");
//        authorService.createAuthor(author);


        Author author2= Author.builder()
                .surname("Kozlov")
                .name("Igor")
                .middle_name("Petrovich")
                .build();
//        authorService.createAuthor(author2);

        Book book = new Book();
        book.setTitle("Spring");
//        book.setAuthor(authorService.getAuthorById(2L));
        book.setAuthorSet(Set.of(authorService.findById(1L)));
        book.setYear_of_publication(2004);
        book.setPages(250);
        book.setPrice(700);
//        bookService.createBook(book);

        Book book1 = Book.builder()
                .title("Winter")
                .pages(300)
//                .author(authorService.getAuthorById(1L))
                .authorSet(Set.of(authorService.findById(2L)))
                .price(500)
                .year_of_publication(2006)
                .build();
//        System.out.println("book1: " + book1);
//        bookService.createBook(book1);

//        BookWarehouse bookWarehouse = new BookWarehouse();
//        bookWarehouse.setBook(bookService.getBookById(1L));
//        bookWarehouse.setBalance(3);

//        bookWarehouseService.deleteBookById(3L);

//        bookWarehouseService.createBookWarehouse(BookWarehouse.builder()
//                .book(bookService.getBookById(1L))
//                .balance(5)
//                .build());

//        log.info("books: {}", bookService.getBooks());
        Book book2 = bookService.findById(1L);
        System.out.println("id: "+ book2.getId());
        System.out.println("pages: "+ book2.getPages());
        System.out.println("pages2: "+ book2.getPrice());
        System.out.println("page3: "+ book2.getTitle());
        System.out.println("page4: "+ book2.getYear_of_publication());
        System.out.println("page5: "+ book2.getAuthorSet());
        System.out.println("book2: "+ book2);
        log.info("book: {}", bookService.findById(1L));
        log.info("books: {}", bookService.findAll());

//        buyerService.createBuyer(Buyer.builder()
//                .surname("Kozlov")
//                .name("Vlad")
//                .middle_name("Ivanovich")
//                .birth_date(LocalDate.of(1999, 1, 1))
//                .build());

    }
}