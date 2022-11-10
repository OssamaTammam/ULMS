package backend;

import constants.FileNames;

public class AdminRole  implements FileNames {

    Database librarianDatabase;

    public AdminRole() {
        this.librarianDatabase = new LibrarianUserDatabase(LIBRARIANS_FILENAME);
        this.librarianDatabase.readFromFile();
    }


    //Gets a list of all librarians
    public LibrarianUser[] getListOfLibrarians() {

        LibrarianUser[] librarians = new LibrarianUser[librarianDatabase.returnAllRecords().size()];
        librarianDatabase.returnAllRecords().toArray(librarians);
        return librarians;
    }

    //Adds a new librarian to the system
    public int addLibrarian(String librarianId, String name, String email, String address, String phoneNumber) {

        for (Record temp : librarianDatabase.returnAllRecords()) {

            if (librarianDatabase.getRecord(librarianId) != null) {
                System.out.println("Librarian already exists");
                return -1;
            }
        }
        LibrarianUser librarian = new LibrarianUser(librarianId, name, email, address, phoneNumber);
        librarianDatabase.insertRecord(librarian);
        return 1;
    }

    //Remove a librarian from the system
    public int removeLibrarian(String key) {

        for (Record librarian : librarianDatabase.returnAllRecords()) {
            if (librarian.getSearchKey().equals(key)) {
                librarianDatabase.returnAllRecords().remove(librarian);
                return 1;
            }
        }
        return -1;
    }

    //Saves all the changes made to the system and logs out
    public void logout() {

        librarianDatabase.saveToFile();
        System.out.println("You have been logged out successfully");
    }
}