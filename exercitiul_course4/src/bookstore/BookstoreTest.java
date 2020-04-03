package bookstore;

import java.util.LinkedList;
import java.util.Scanner;

public class BookstoreTest<books> {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter number of books");
        int n = keyboard.nextInt();
        keyboard.nextLine();


        for(int i = 0; i < n; i++) {
            System.out.println("title: ");
            String title = keyboard.nextLine();
            System.out.println("author: ");
            String author = keyboard.nextLine();
            System.out.println("publisher: ");
            String publisher = keyboard.nextLine();
            System.out.println("page count: ");
            int pageCount = keyboard.nextInt();
            keyboard.nextLine();
            Book book = new Book(title, author, publisher, pageCount);
            System.out.println(book);
        }


        Book[] books = {new Book("Mara", "Ioan Slavici", "Nemira", 200),
                            new Book("Carte", "autor", "editrura", 100),
                new Book("Mara", "Ioan Slavici", "Nemira", 200)};

        Book b = new Book("Mara", "Ioan Slavici", "Nemira", 200);
        BookstoreCheck check = new BookstoreCheck();
        System.out.println(check.chekIfAppearsTwice(b, books));
    }
}
