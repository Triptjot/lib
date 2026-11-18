
import java.util.ArrayList;
import java.util.Scanner;

public class Library{

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // Add a new book
    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : books) {
            if (b.bookId == id) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, name, author));

        System.out.println("Book added successfully!");
    }

    // Display all books
    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        for (Book b : books) {
            b.displayBook();
        }
    }

    // Search for a book
    static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.bookId == id) {
                b.displayBook();
                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Issue a book
    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.bookId == id) {

                if (b.isIssued) {
                    System.out.println("Book is already issued!");
                } else {
                    b.isIssued = true;
                    System.out.println("Book issued successfully!");
                }
                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Return a book
    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.bookId == id) {

                if (!b.isIssued) {
                    System.out.println("Book is not issued!");
                } else {
                    b.isIssued = false;
                    System.out.println("Book returned successfully!");
                }
                return;
            }
        }

        System.out.println("Book not found!");
    }
}
