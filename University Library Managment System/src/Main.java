public class Main {
    public static void main(String[] args) {

        Database librarianUserDatabase = new LibrarianUserDatabase("librarian.txt");
        Database studentBookDatabase = new StudentBookDatabase("studentBooks.txt");
        Database bookDatabase = new BookDatabase("book.txt");
        AdminRole adminRole = new AdminRole(librarianUserDatabase);
        LibrarianRole librarianRole = new LibrarianRole(bookDatabase, studentBookDatabase);


    }
}