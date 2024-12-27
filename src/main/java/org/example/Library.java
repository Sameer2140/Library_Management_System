package org.example;

import java.util.HashMap;

interface blueprint {

    String add_Book(int id, String name, String author, String year);

    String borrow_Book(int id, String name);

    String return_Book(int id);

    HashMap<Integer, String[]> available_Book();

    boolean exit();
}

public class Library implements blueprint {

    String name, author, user_name, password, year;
    int id;
   public HashMap<Integer, String[]> books = new HashMap<>(); // Declare HashMap to store books

    // Instance Initialization Block (executes when the object is created)
//    {
//        // Insert book details manually into the HashMap inside the initialization block
//        books.put(1, new String[]{"Wings of Fire: An Autobiography", "Dr. A.P.J. Abdul Kalam", "1999", "available"});
//        books.put(2, new String[]{"Target 3 Billion", "Dr. A.P.J. Abdul Kalam", "2011", "available"});
//        books.put(3, new String[]{"The Luminous Sparks: Appreciations and Motivations", "Dr. A.P.J. Abdul Kalam", "2004", "available"});
//        books.put(4, new String[]{"My Journey: Transforming Dreams into Actions", "Dr. A.P.J. Abdul Kalam", "2013", "available"});
//        books.put(5, new String[]{"Transcendence: My Spiritual Experiences with Pramukh Swamiji", "Dr. A.P.J. Abdul Kalam", "2010", "available"});
//        books.put(6, new String[]{"The Voice of Youth", "Dr. A.P.J. Abdul Kalam", "2003", "available"});
//        books.put(7, new String[]{"Beyond 2020: A Vision for Tomorrow’s India", "Dr. A.P.J. Abdul Kalam", "2004", "available"});
//        books.put(8, new String[]{"A.P.J. Abdul Kalam - The People's President", "Dr. A.P.J. Abdul Kalam", "2007", "available"});
//        books.put(9, new String[]{"Vision 2020: Transforming India", "Dr. A.P.J. Abdul Kalam", "2003", "available"});
//        books.put(10, new String[]{"India My Dream", "Dr. A.P.J. Abdul Kalam", "2002", "available"});
//    }


    @Override
    public String add_Book(int id, String name, String author, String year) {
        if (!books.containsKey(id)) {
            books.put(id, new String[]{name, author, year, "available"});
            return "Thank You For Your Contribution";
        } else {
            return "Try To Change The Id and Add Again => This Id Is Already In Use";
        }
    }

    @Override
    public String borrow_Book(int id, String name) {
        if (books.containsKey(id)) {
            String[] bookDetails = books.get(id);
            if ("available".equals(bookDetails[3])) {
                bookDetails[3] = "not_available";
                return "Please Return The Book On Time";
            } else {
                return "Book Not Available";
            }
        } else {
            return "Book Not Available";
        }
    }

    @Override
    public String return_Book(int id) {
        if (books.containsKey(id)) {
            String[] bookDetails = books.get(id);
            bookDetails[3] = "available";
            return "Thank You For Returning The Book On Time";
        }
        return "Book Not Found";
    }

    @Override
    public HashMap<Integer, String[]> available_Book() {
        return books;
    }

    @Override
    public boolean exit() {
        return false; // Placeholder exit logic
    }
}