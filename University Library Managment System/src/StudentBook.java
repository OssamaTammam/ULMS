import java.security.PrivateKey;
import java.time.LocalDate;

public class StudentBook implements Record {

    private String studentId;
    private String bookId;
    private LocalDate borrowDate;

    public StudentBook(String studentId, String bookId, LocalDate borrowDate) {

        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getBookId() {
        return bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public String lineRepresentation() {

        String line = studentId + "," + bookId + "," + borrowDate;
        return line;
    }

    public String getSearchKey() {

        String key = studentId + "," + bookId;
        return key;
    }


}
