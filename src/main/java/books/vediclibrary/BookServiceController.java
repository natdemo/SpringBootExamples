package books.vediclibrary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books.vediclibrary.model.Book;
import books.vediclibrary.service.BookServiceRepository;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookServiceController {

	
	@Autowired
	BookServiceRepository bookServiceRepository;
	
	
	@GetMapping("/books")
	//public ResponseEntity<List<Book>> getAllBooks() {
	public List<Book> getAllBooks() {
		return bookServiceRepository.findAll("bookTitle", 0, 10);
		//return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping("/books/{id}")
	//public ResponseEntity<Book> getBook(@PathVariable("id") String id) {
	public Book getBook(@PathVariable("id") String id) {
		return bookServiceRepository.findSingleById(id);
		//return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

}
