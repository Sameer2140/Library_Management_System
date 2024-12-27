package org.example;

import java.util.*;
//main class

public class Main {

    public static void main(String[] args) {
        int id, i, temp = 0;
        String name, author, year, user_name, password;
        Library l = new Library();
        Scanner sc = new Scanner(System.in);
        boolean b1 = true;

        // as of now assume there are three valid users
        Authentication[] a = new Authentication[3];
        a[0] = new Authentication("sameer", "1234");
        a[1] = new Authentication("anvitha", "5678");  // Corrected assignment
        a[2] = new Authentication("arvind", "9876");   // Corrected assignment

        while (b1) {
            System.out.println("Enter UserName:");
            user_name = sc.next();
            System.out.println("Enter The Password");
            password = sc.next();

            for (i = 0; i < 3; i++) {
                if (a[i].credentialCheck(user_name, password)) {
                    do {
                        System.out.print("Enter 1.Add_Book 2.Borrow_Book 3.Return_Book 4.Available_Books 5.exit: ");
                        int choice = sc.nextInt();
                        sc.nextLine(); // Consume the newline character left in the buffer
                        switch (choice) {
                            case 1:
                                // Add Book
                                System.out.println("Enter the id, name, author, year:");
                                id = sc.nextInt();
                                sc.nextLine();  // Consume the leftover newline
                                name = sc.nextLine();
                                author = sc.nextLine();
                                year = sc.nextLine();

                                System.out.println(l.add_Book(id, name, author, year));
                                break;

                            case 2:
                                // Borrow Book
                                System.out.println("Enter the id, name:");
                                id = sc.nextInt();
                                sc.nextLine();  // Consume the leftover newline
                                name = sc.nextLine();
                                System.out.println(l.borrow_Book(id, name));
                                break;

                            case 3:
                                // Return Book
                                System.out.println("Enter the id");
                                id = sc.nextInt();
                                System.out.println(l.return_Book(id));
                                break;

                            case 4:
                                // Show Available Books
                                HashMap<Integer, String[]> availableBooks = l.available_Book();
                                System.out.println("Available Books:");
                                for (Map.Entry<Integer, String[]> entry : availableBooks.entrySet()) {
                                    Integer bookId = entry.getKey();
                                    String[] bookDetails = entry.getValue();
                                    // Check if the availability is "available"
                                    if ("available".equals(bookDetails[3])) {
                                        System.out.println("ID: " + bookId + ", Name: " + bookDetails[0] + ", Author: " + bookDetails[1] + ", Year: " + bookDetails[2] + ", Availability: " + bookDetails[3]);
                                    }
                                }
                                break;

                            case 5:
                                // Exit
                                b1 = l.exit();
                                break;

                            default:
                                System.out.println("Invalid choice, please try again.");
                                break;
                        }
                    } while (b1);
                    System.out.println("Have a nice day!");
                    break;
                } else {
                    temp++;
                }
            }

            if (temp == 3) {
                System.out.println("Invalid Username or Password");
            }
        }

    }
}
