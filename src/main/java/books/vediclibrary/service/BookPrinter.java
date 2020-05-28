package books.vediclibrary.service;

import java.util.List;
import java.util.Objects;

import books.vediclibrary.model.Book;

public class BookPrinter {
    public static void print(List<Book> books){
        String header = String.format("%-50s %-25s %-50s","TITLE","TYPE","ENGLISH TITLE");
        System.out.println(header);
        for (Book b: books) {
            String data = String.format("%-50s %-25s %-50s",
                    b.getBookTitle().trim(),
                    b.getBookType(),
                    Objects.isNull(b.getBookEnglishTitle()) ? "-" : b.getBookEnglishTitle());
            System.out.println(data);
        }
        System.out.println();
    }
}
