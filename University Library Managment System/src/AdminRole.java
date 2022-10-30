public class AdminRole {

    Database librarianDatabase;

    public AdminRole(Database database) {
        this.librarianDatabase = database;
    }


    //Gets a list of all librarians
    public LibrarianUser[] getListOfLibrarians() {

        LibrarianUser[] librarians = new LibrarianUser[librarianDatabase.returnAllRecords().size()];
        librarianDatabase.returnAllRecords().toArray(librarians);
        return librarians;
    }

    //Adds a new librarian to the system
    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber) {

        for (Record temp: librarianDatabase.returnAllRecords()) {

            if (librarianDatabase.getRecord(librarianId) != null) {
                System.out.println("Librarian already exists");
                return;
            }
        }
        LibrarianUser librarian = new LibrarianUser(librarianId, name, email, address, phoneNumber);
        librarianDatabase.insertRecord(librarian);
    }

    //Remove a librarian from the system
    public void removeLibrarian(String key) {

        for (Record librarian : librarianDatabase.returnAllRecords()) {
            if (librarian.getSearchKey().equals(key)) {
                librarianDatabase.returnAllRecords().remove(librarian);
                break;
            }
        }
    }

    //Saves all the changes made to the system and logs out
    public void logout() {

        librarianDatabase.saveToFile();
        System.out.println("You have been logged out successfully");
        System.exit(0);
    }
}