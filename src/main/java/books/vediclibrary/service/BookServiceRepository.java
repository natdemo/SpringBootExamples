package books.vediclibrary.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import books.vediclibrary.model.Book;
import books.vediclibrary.model.BookType;

@Service
public class BookServiceRepository {

	private MongoTemplate mongoTemplate;

	public BookServiceRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	/*
	 * * TODO: implement the following queries
	 * 
	 * 
	 1) find all books (done)
	 2) find book by id (done)
	 3) find book by title (done)
	 4) find book by type (done)
	 5) find all books for an author
	 * 
	 */
	
	public List<Book> findAll(String field,
								int pageNb,
								int pageSize) {
		
		Query allPageAndOrdered = new Query()
				.with(Sort.by(Sort.Direction.ASC, field))
				.with(PageRequest.of(pageNb, pageSize));
		
		
		return mongoTemplate.find(allPageAndOrdered, Book.class);
	}

	
	public Book findSingleById(String id) {
		return this.mongoTemplate.findById(id, Book.class);
	}
	
	public List<Book> findByTitle(String bookTitle) {
		
		Query byTitle = new Query()
				.addCriteria(Criteria.where("bookTitle").is(bookTitle));
		
		return this.mongoTemplate.find(byTitle, Book.class);
	}
	
	
	public List<Book> findPuranas() {
		
		Query byType = new Query()
				.addCriteria(Criteria.where("title").is(BookType.Purana));
		
		return this.mongoTemplate.find(byType, Book.class);
	}
	
	public List<Book> findSongClassicAndSacredTexts() {
		
		Query bySongAndClassics = new Query(
			new Criteria()
				.orOperator(
						Criteria.where("bookType").is(BookType.Classic_Text.toString()),
						Criteria.where("bookType").is(BookType.Song.toString()),
						Criteria.where("bookType").is(BookType.Sacred_Text.toString())
				));
		
		return this.mongoTemplate.find(bySongAndClassics, Book.class);
	}
	
	public List<Book> findByAuthors() {
		
		/* TODO */
		return null;
	}
}
