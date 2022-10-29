import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Database librarianDatabase = new LibrarianUserDatabase("librarian.txt");
        librarianDatabase.readFromFile();
    }
}