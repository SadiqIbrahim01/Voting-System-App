import java.util.Scanner;
import java.util.ArrayList;

public class LibraryTrackerApp {
    public static ArrayList<String> availableBooks = new ArrayList<>();
    public static ArrayList<String> borrowedBooks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        availableBooks.add("Things fall Apart");
        availableBooks.add("Son of the Soil");
        availableBooks.add("Last Days at Forcados High");
        availableBooks.add("Purple Hibiscus");
        availableBooks.add("Face Me I Face You");

        System.out.println("--- Welcome to Library Tracker ---");

        do {
            System.out.println("\n1. View all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    viewAllBooks();
                    break;

                case 2:
                    System.out.println("What book would you like to borrow?");
                    String borrowBook = input.nextLine();

                    for (int i = 0; i < availableBooks.size(); i++) {
                        if (availableBooks.get(i).equalsIgnoreCase(borrowBook)) {
                            System.out.println(availableBooks.get(i) + " has been borrowed.\n");
                            borrowedBooks.add(availableBooks.get(i));
                            availableBooks.remove(i);
                            break;
                        } else if (i == availableBooks.size() - 1) {
                            System.out.println("Book not found in library.\n");
                        }
                    }
                    break;

                case 3:
                    System.out.println("What book would you like to return?");
                    String returnBook = input.nextLine();

                    for (int i = 0; i < borrowedBooks.size(); i++) {
                        if (borrowedBooks.get(i).equalsIgnoreCase(returnBook)) {
                            System.out.println(borrowedBooks.get(i) + " has been returned.\n");
                            availableBooks.add(borrowedBooks.get(i));
                            borrowedBooks.remove(i);
                            break;
                        } else if (i == borrowedBooks.size() - 1) {
                            System.out.println("This book was not borrowed.\n");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);

        input.close();
    }

    public static void viewAllBooks() {
        if (availableBooks.isEmpty()) {
            System.out.println("No books available right now.\n");
        } else {
            System.out.println("Available books are:");
            for (String book : availableBooks) {
                System.out.println("- " + book);
            }
            System.out.println();
        }
    }
}
