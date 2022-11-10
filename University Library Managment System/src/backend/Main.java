package backend;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    //Capitalizes the start of every word in a string
    public static String capitalizeString(String str) {

        String[] words = str.split(" ");
        String capitalizedString = "";
        for (String w : words) {

            String first = w.substring(0, 1);
            String afterFirst = w.substring(1);
            capitalizedString += first.toUpperCase() + afterFirst + " ";
        }

        return capitalizedString.trim();
    }

    //Checks if string is numeric
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Create the two roles used in the system
        AdminRole adminRole = new AdminRole();
        LibrarianRole librarianRole = new LibrarianRole();

        System.out.println("Welcome to the University Library Management System");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Librarian");
        System.out.println("Please choose a role: ");
        String roleChoice = scanner.nextLine();

        //Menu to utilize the admin roles and its methods
        if (roleChoice.equals("1")) {

            loop:
            while (true) {

                String choice;
                System.out.println("1. Add a new librarian");
                System.out.println("2. Remove a librarian");
                System.out.println("3. List all librarians");
                System.out.println("4. Log out and save");
                System.out.println("5. Log out and don't save");
                System.out.println("Choose an operation:");
                choice = scanner.nextLine();

                switch (choice) {
                    case "1": {

                        String librarianId, name, email, address, phoneNumber;
                        System.out.println("Enter the librarian id: ");
                        librarianId = scanner.nextLine();
                        System.out.println("Enter the librarian name: ");
                        name = scanner.nextLine();
                        System.out.println("Enter the librarian email: ");
                        email = scanner.nextLine();
                        System.out.println("Enter the librarian address: ");
                        address = scanner.nextLine();
                        System.out.println("Enter the librarian phone number: ");
                        phoneNumber = scanner.nextLine();
                        adminRole.addLibrarian(librarianId, capitalizeString(name), email, address, phoneNumber);

                        break;
                    }
                    case "2": {

                        System.out.println("Enter the librarian id: ");
                        String librarianId = scanner.nextLine();

                        adminRole.removeLibrarian(librarianId);

                        break;
                    }
                    case "3": {

                        LibrarianUser[] librarians = adminRole.getListOfLibrarians();

                        System.out.println("All librarians information:");

                        for (LibrarianUser librarian : librarians) {

                            System.out.println(librarian.lineRepresentation());
                        }

                        break;
                    }
                    case "4": {

                        adminRole.logout();

                        break loop;
                    }
                    case "5": {

                        System.out.println("You have been logged out successfully without saving");
                        System.exit(0);
                    }
                    default: {

                        System.out.println("Invalid choice");

                        break;
                    }
                }
            }
            //Menu to utilize the librarian roles and its methods
        } else if (roleChoice.equals("2")) {

            loop:
            while (true) {

                String choice;
                System.out.println("1. Add a new book");
                System.out.println("2. List all books");
                System.out.println("3. Issue a book");
                System.out.println("4. Return a book");
                System.out.println("5. List all issued books");
                System.out.println("6. Log out and save");
                System.out.println("7. Log out and don't save");
                System.out.println("Choose an operation:");
                choice = scanner.nextLine();

                switch (choice) {
                    case "1": {

                        String bookId, title, author, publisher, quantity = null;
                        System.out.println("Enter the book id: ");
                        bookId = scanner.nextLine();
                        System.out.println("Enter the book title: ");
                        title = scanner.nextLine();
                        System.out.println("Enter the book author: ");
                        author = scanner.nextLine();
                        System.out.println("Enter the book publisher: ");
                        publisher = scanner.nextLine();
                        do {

                            if (quantity != null) {
                                System.out.println("Invalid input. Please enter an integer");
                            }
                            System.out.println("Enter the book quantity: ");
                        } while (!(isNumeric(quantity = scanner.nextLine())));
                        librarianRole.addBook(bookId, capitalizeString(title), capitalizeString(author), capitalizeString(publisher), Integer.parseInt(quantity));

                        break;
                    }
                    case "2": {

                        Book[] books = librarianRole.getListOfBooks();
                        System.out.println("All books information:");
                        for (Book book : books) {

                            System.out.println(book.lineRepresentation());
                        }

                        break;
                    }
                    case "3": {

                        String studentId, BookId;
                        System.out.println("Enter the student id: ");
                        studentId = scanner.nextLine();
                        System.out.println("Enter the book id: ");
                        BookId = scanner.nextLine();

                        int state = librarianRole.borrowBook(studentId, BookId, LocalDate.now());

                        if (state == 2)
                            System.out.println("backend.Book issued successfully");
                        else if (state == 1)
                            System.out.println("backend.Book is already issued to this student");
                        else if (state == 0)
                            System.out.println("backend.Book is not available in storage");
                        else if (state == -1)
                            System.out.println("backend.Book doesn't exist in the system");

                        break;
                    }
                    case "4": {

                        String studentId, BookId;

                        System.out.println("Enter the student id: ");
                        studentId = scanner.nextLine();
                        System.out.println("Enter the book id: ");
                        BookId = scanner.nextLine();

                        double returnFee = librarianRole.returnBook(studentId, BookId, LocalDate.now());

                        if (returnFee == 0)
                            System.out.println("backend.Book returned successfully without a fine");
                        else
                            System.out.println("Books return with a fine of " + returnFee);

                        break;
                    }
                    case "5": {

                        StudentBook[] studentBooks = librarianRole.getListOfBorrowingOperations();

                        System.out.println("All issued books information:");

                        for (StudentBook studentBook : studentBooks) {

                            System.out.println(studentBook.lineRepresentation());
                        }

                        break;
                    }
                    case "6": {

                        librarianRole.logout();

                        break loop;
                    }
                    case "7": {

                        System.out.println("You have been logged out without saving successfully");
                        System.exit(0);
                    }
                    default: {

                        System.out.println("Invalid choice");

                        break;
                    }
                }
            }
        }
    }
}