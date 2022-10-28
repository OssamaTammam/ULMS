public class LibrarianRole extends LibrarianUserDatabase {

    BookDatabase bookDatabase;
    StudentBookDatabase studentBookDatabase;

    public LibrarianRole(String fileName, BookDatabase bookDatabase, StudentBookDatabase studentBookDatabase) {
        super(fileName);
        this.bookDatabase = bookDatabase;
        this.studentBookDatabase = studentBookDatabase;
    }


}
