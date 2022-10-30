import java.time.LocalDate;

public class LibrarianRole {

    Database bookDatabase;
    Database studentBookDatabase;

    public LibrarianRole(Database bookDatabase, Database studentBookDatabase) {

        this.bookDatabase = bookDatabase;
        this.studentBookDatabase = studentBookDatabase;
    }

    //Adds a new book to the system
    public void addBook(String id, String title, String authorName, String publisherName, int quantity) {

        Book book = new Book(id, title, authorName, publisherName, quantity);
        bookDatabase.insertRecord(book);
    }

    //Returns an array of all books
    public Book[] getListOfBooks() {

        Book[] books = new Book[bookDatabase.returnAllRecords().size()];
        bookDatabase.returnAllRecords().toArray(books);
        return books;
    }

    //Returns an array of all books issued to a student
    public StudentBook[] getListOfBorrowingOperations() {

        StudentBook[] studentBooks = new StudentBook[studentBookDatabase.returnAllRecords().size()];
        studentBookDatabase.returnAllRecords().toArray(studentBooks);
        return studentBooks;
    }

    //Student borrows a book
    public int borrowBook(String studentId, String bookId, LocalDate borrowDate) {

        Book recordBook = (Book) bookDatabase.getRecord(bookId);
        Record recordStudentBook = studentBookDatabase.getRecord(studentId + "," + bookId);

        if (recordBook == null)
            return -1;
        else if (recordBook.getQuantity() == 0) {
            return 0;
        } else if (recordStudentBook != null && recordStudentBook.lineRepresentation().equals(studentId + "," + bookId + "," + borrowDate)) {
            return 1;
        } else {

            Record newBook = new Book(bookId, recordBook.getTitle(), recordBook.getAuthorName(), recordBook.getPublisherName(), recordBook.getQuantity() - 1);
            bookDatabase.deleteRecord(bookId);
            bookDatabase.insertRecord(newBook);
            Record newStudentBook = new StudentBook(studentId, bookId, borrowDate);
            studentBookDatabase.insertRecord(newStudentBook);
            return 2;
        }
    }

    //Student returns a book
    public double returnBook(String studentId, String bookId, LocalDate returnDate) {

        int dateDifference;

        Book recordBook = (Book) bookDatabase.getRecord(bookId);
        Book newBook = new Book(bookId, recordBook.getTitle(), recordBook.getAuthorName(), recordBook.getPublisherName(), recordBook.getQuantity() + 1);
        bookDatabase.deleteRecord(bookId);
        bookDatabase.insertRecord(newBook);
        studentBookDatabase.deleteRecord(studentId + "," + bookId);

        dateDifference = returnDate.getDayOfYear() - ((StudentBook) studentBookDatabase.getRecord(studentId + "," + bookId)).getBorrowDate().getDayOfYear();
        if (dateDifference < 7) {
            return 0;
        } else {
            return ((dateDifference - 7) * 0.5);
        }
    }

    public void logout() {

        bookDatabase.saveToFile();
        studentBookDatabase.saveToFile();
        System.out.println("You have been logged out successfully");
        System.exit(0);
    }
}
