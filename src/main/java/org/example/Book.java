public class Book {
    int bookId;
    String bookName;
    String author;
    boolean isIssued;

    public Book(int bookId, String bookName, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.isIssued = false;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Status: " +
                (isIssued ? "Issued" : "Available"));
        System.out.println("----------------------");
    }
}