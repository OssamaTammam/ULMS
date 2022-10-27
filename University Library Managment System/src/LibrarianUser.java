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

        return String.format("%s,%s,%s,%s,%s", librarianId, name, email, address, phoneNumber);
    }

    public String getSearchKey() {

        return librarianId;
    }


}