public class LibrarianUser implements Record {

    private String librarianId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public LibrarianUser(String librarianId, String name, String email, String address, String phoneNumber) {

        this.librarianId = librarianId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //Returns a string representation of the librarian
    public String lineRepresentation() {

        return (librarianId + "," + name + "," + email + "," + address + "," + phoneNumber);
    }

    //Returns the librarian id
    public String getSearchKey() {

        return librarianId;
    }
}