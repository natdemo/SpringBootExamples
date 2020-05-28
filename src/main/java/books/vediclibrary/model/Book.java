package books.vediclibrary.model;


import java.time.LocalDate;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("books")
public class Book {

	@Indexed
	private String bookTitle;	
	private String bookEnglishTitle;
	
	//@Field("type")
	@Indexed
	private BookType bookType;
	
	@Transient
	private LocalDate createdAt;

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookEnglishTitle() {
		return bookEnglishTitle;
	}

	public void setBookEnglishTitle(String bookEnglishTitle) {
		this.bookEnglishTitle = bookEnglishTitle;
	}

	
	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	@Override
	public String toString() {
		return "book [bookTitle=" + bookTitle + ", bookEnglishTitle=" + bookEnglishTitle + ", bookType=" + bookType
				+ "]";
	}

}
