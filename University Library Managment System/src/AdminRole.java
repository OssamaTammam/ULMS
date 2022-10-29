public class AdminRole {

    Database librarianDatabase;

    public AdminRole(Database database) {
        this.librarianDatabase = database;
    }

    public LibrarianUser[] getListOfLibrarians() {

        LibrarianUser[] librarians = new LibrarianUser[librarianDatabase.returnAllRecords().size()];
        librarianDatabase.returnAllRecords().toArray(librarians);
        return librarians;
    }

    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber) {

        LibrarianUser librarian = new LibrarianUser(librarianId, name, email, address, phoneNumber);
        librarianDatabase.insertRecord(librarian);
    }

    public void removeLibrarian(String key) {

        for (Record librarian : librarianDatabase.returnAllRecords()) {
            if (librarian.getSearchKey().equals(key)) {
                librarianDatabase.returnAllRecords().remove(librarian);
                break;
            }
        }
    }

    public void logout() {

        librarianDatabase.saveToFile();
        System.out.println("You have been logged out");
    }
}