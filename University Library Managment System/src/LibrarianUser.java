public class LibrarianUser {

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

    public String lineRepresentation() {

        String line = librarianId + "," + name + "," + email + "," + address + "," + phoneNumber;
        return line;
    }

    public String getSearchKey() {

        return librarianId;
    }
}