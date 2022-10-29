public class Main {
    public static void main(String[] args) {

        Database librarianUserDatabase = new LibrarianUserDatabase("librarian.txt");
        Database studentBookDatabase = new StudentBookDatabase("studentBooks.txt");
        Database bookDatabase = new BookDatabase("book.txt");

        AdminRole adminRole = new AdminRole(librarianUserDatabase);

        adminRole.addLibrarian("7352","Ossama","ossama@gmail.com","Alex","01030205223");


    }
}