package backend;

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

    //Returns a string representation of the student book
    public String lineRepresentation() {

        return (studentId + "," + bookId + "," + borrowDate);
    }

    //Returns the student id and book id on the form of a string
    public String getSearchKey() {

        return (studentId + "," + bookId);
    }
}
