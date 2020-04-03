package bookstore;

public class BookstoreCheck {
    public boolean chekIfAppearsTwice(Book book, Book[] books) {
        int n = 0;
        for(Book b: books) {
            if(b.equals(book))
                n+=1;
            if(n==2) {
                return true;
            }
        }
        return false;
    }

    public Book chekIfBigger(Book b1, Book b2) {
        if( b1.getPageCount() > b2.getPageCount() ) {
            return  b1;
        }
        else {
            return  b2;
        }
    }

    public BookstoreCheck() {
    }
}
