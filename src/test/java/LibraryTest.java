import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Library;

import java.util.HashMap;

public class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library(); // Initialize the library object

        // Add some initial books to the collection
        library.add_Book(101, "Java Programming", "John Doe", "2021");
        library.add_Book(102, "Python Basics", "Jane Smith", "2022");
    }

    @Test
    void testAddBook_Success() {
        String result = library.add_Book(103, "C++ Fundamentals", "Alice Brown", "2020");
        assertEquals("Thank You For Your Contribution", result);

        // Verify the book is added
        HashMap<Integer, String[]> books = library.available_Book();
        assertTrue(books.containsKey(103));
        assertArrayEquals(new String[]{"C++ Fundamentals", "Alice Brown", "2020", "available"}, books.get(103));
    }

    @Test
    void testAddBook_DuplicateId() {
        String result = library.add_Book(101, "New Book", "New Author", "2023");
        assertEquals("Try To Change The Id and Add Again => This Id Is Already In Use", result);

        // Verify the original book is not replaced
        HashMap<Integer, String[]> books = library.available_Book();
        assertEquals("Java Programming", books.get(101)[0]);
    }

    @Test
    void testBorrowBook_Success() {
        String result = library.borrow_Book(101, "Java Programming");
        assertEquals("Please Return The Book On Time", result);

        // Verify the book status is updated
        String[] bookDetails = library.available_Book().get(101);
        assertEquals("not_available", bookDetails[3]);
    }

    @Test
    void testBorrowBook_NotAvailable() {
        // Borrow the book to make it unavailable
        library.borrow_Book(101, "Java Programming");

        String result = library.borrow_Book(101, "Java Programming");
        assertEquals("Book Not Available", result);
    }

    @Test
    void testBorrowBook_BookNotFound() {
        String result = library.borrow_Book(999, "Non-Existent Book");
        assertEquals("Book Not Available", result);
    }

    @Test
    void testReturnBook_Success() {
        // Borrow the book first
        library.borrow_Book(101, "Java Programming");

        // Return the book
        String result = library.return_Book(101);
        assertEquals("Thank You For Returning The Book On Time", result);

        // Verify the book status is updated
        String[] bookDetails = library.available_Book().get(101);
        assertEquals("available", bookDetails[3]);
    }

    @Test
    void testReturnBook_BookNotFound() {
        String result = library.return_Book(999);
        assertEquals("Book Not Found", result);
    }

    @Test
    void testAvailableBooks() {
        HashMap<Integer, String[]> books = library.available_Book();

        // Verify the initial books are present
        assertTrue(books.containsKey(101));
        assertTrue(books.containsKey(102));

        // Verify their details
        assertArrayEquals(new String[]{"Java Programming", "John Doe", "2021", "available"}, books.get(101));
        assertArrayEquals(new String[]{"Python Basics", "Jane Smith", "2022", "available"}, books.get(102));
    }

    @Test
    void testExit() {
        boolean result = library.exit();
        assertFalse(result); // As the method always returns false (placeholder logic)
    }
}
