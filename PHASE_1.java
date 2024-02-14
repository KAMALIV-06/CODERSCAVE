import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Library {
    private Map<Integer, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books.values()) {
            System.out.println("Book ID: " + book.getBookId() + ", Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor() + ", Available: " + (book.isAvailable() ? "Yes" : "No"));
        }
    }

    public Book borrowBook(int bookId) {
        Book book = books.get(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully.");
            return book;
        } else {
            System.out.println("Book not available for borrowing.");
            return null;
        }
    }

    public void returnBook(Book book) {
        if (book != null) {
            book.setAvailable(true);
            System.out.println("Book returned successfully.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(1, "Java Programming", "John Doe");
        Book book2 = new Book(2, "Data Structures", "Jane Smith");

        library.addBook(book1);
        library.addBook(book2);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow a Book");
           
