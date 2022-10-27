import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AdminRole extends LibrarianUserDatabase {

    LibrarianUserDatabase database;

    public AdminRole(String fileName, LibrarianUserDatabase database) {
        super(fileName);
        this.database = database;
    }

    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber) throws IOException {

        LibrarianUser librarian = new LibrarianUser(librarianId, name, email, address, phoneNumber);
        BufferedWriter addUser = new BufferedWriter(new FileWriter(database.getFileName(), true));
        String userData = new String(librarian.lineRepresentation());
        addUser.append(userData);
        addUser.newLine();
        addUser.close();
    }

    public void removeLibrarian(String key) {

        for (LibrarianUser librarian : database.returnAllRecords()) {
            if (librarian.getSearchKey().equals(key)) {
                database.returnAllRecords().remove(librarian);
                break;
            }
        }
    }

    public void logout() {

        database.saveToFile();
        System.out.println("You have been logged out");
    }
}
