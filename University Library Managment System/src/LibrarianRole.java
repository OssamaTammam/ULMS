import java.time.LocalDate;

public class LibrarianRole {

    Database bookDatabase;
    Database studentBookDatabase;

    public LibrarianRole(BookDatabase bookDatabase, StudentBookDatabase studentBookDatabase) {

        this.bookDatabase = bookDatabase;
        this.studentBookDatabase = studentBookDatabase;
    }


    public void addBook(String id, String title, String authorName, String publisherName, int quantity) {

        Book book = new Book(id, title, authorName, publisherName, quantity);
        bookDatabase.insertRecord(book);
    }

    public Book[] getListOfBooks() {

        Book[] books = new Book[bookDatabase.returnAllRecords().size()];
        bookDatabase.returnAllRecords().toArray(books);
        return books;
    }

    public StudentBook[] getListOfBorrowingOperations() {

        StudentBook[] studentBooks = new StudentBook[studentBookDatabase.returnAllRecords().size()];
        studentBookDatabase.returnAllRecords().toArray(studentBooks);
        return studentBooks;
    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowDate) {

        Record recordBook = bookDatabase.getRecord(bookId);
        Record recordStudentBook = studentBookDatabase.getRecord(studentId + "," + bookId);
        Book book = (Book) recordBook;
        StudentBook studentBook = (StudentBook) recordStudentBook;
        if (book.getQuantity() == 0) {
            return 0;
        }
    }
}
