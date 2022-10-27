import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        LibrarianUserDatabase database = new LibrarianUserDatabase("librarian.txt");
        AdminRole r1 = new AdminRole("librarian.txt", database);
        r1.addLibrarian("7352", "Ossama", "ossamatammam@gmail.com", "Alex", "01030205223");

    }
}