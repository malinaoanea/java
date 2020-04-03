package bookstore;

import java.util.Objects;

public class Book {
    private String title, author, publisher;
    private int pageCount;

    public Book(String title, String author, String publisher, int pageCount) {
        if (pageCount < 0) {
            throw new RuntimeException("Book with tile " + title + " has negative pageCount value");
        }
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                publisher.equals(book.publisher);
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return "BOOK_TITLE: [" + title.toUpperCase() + "]    " +
                "AUTHOR: [" + author + "]    " +
                "BOOK_PUBLISHER: [" + publisher.toLowerCase() + "]\n";
    }
}
