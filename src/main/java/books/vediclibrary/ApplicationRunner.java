package books.vediclibrary;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import books.vediclibrary.model.Book;
import books.vediclibrary.service.BookPrinter;
import books.vediclibrary.service.BookServiceRepository;

@Component
public class ApplicationRunner implements CommandLineRunner {
	
    private BookServiceRepository bookService;

    public ApplicationRunner(BookServiceRepository bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) {
        System.out.println("-----\nQUERY: All books ordered by title");
        List<Book> allBooks = this.bookService
                .findAll("bookTitle", 0, 10);
        BookPrinter.print(allBooks);

    }
}
