package assignment1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

public class Task_4 {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        int nextId = 1;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCRUD Application");
            System.out.println("1. Create Book");
            System.out.println("2. Read Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.next();
                    System.out.print("Enter Author: ");
                    String author = scanner.next();
                    Book newBook = new Book(nextId, title, author);
                    books.add(newBook);
                    nextId++;
                    System.out.println("Book created successfully.");
                    break;

                case 2:
                    System.out.println("List of Books:");
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;

                case 3:
                    System.out.print("Enter the ID of the book to update: ");
                    int updateId = scanner.nextInt();
                    for (Book book : books) {
                        if (book.getId() == updateId) {
                            System.out.print("Enter new Title: ");
                            book.setTitle(scanner.next());
                            System.out.print("Enter new Author: ");
                            book.setAuthor(scanner.next());
                            System.out.println("Book updated successfully.");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter the ID of the book to delete: ");
                    int deleteId = scanner.nextInt();
                    books.removeIf(book -> book.getId() == deleteId);
                    System.out.println("Book deleted successfully.");
                    break;

                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
