package backend;

import constants.FileNames;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibrarianRole implements FileNames {

    Database bookDatabase;
    Database studentBookDatabase;

    public LibrarianRole() {

        this.studentBookDatabase = new StudentBookDatabase(STUDENTSBOOKS_FILENAME);
        this.bookDatabase = new BookDatabase(BOOKS_FILENAME);
        this.studentBookDatabase.readFromFile();
        this.bookDatabase.readFromFile();
    }

    //Adds a new book to the system
    public int addBook(String id, String title, String authorName, String publisherName, int quantity) {

        for (Record temp : bookDatabase.returnAllRecords()) {

            if (bookDatabase.getRecord(id) != null) {
                System.out.println("Book already exists");
                return -1;
            }
        }
        Book book = new Book(id, title, authorName, publisherName, quantity);
        bookDatabase.insertRecord(book);
        return 1;
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
        else if (recordStudentBook != null && recordStudentBook.getSearchKey().equals(studentId + "," + bookId)) {
            return 1;
        } else if (recordBook.getQuantity() == 0) {
            return 0;
        } else {

            recordBook.setQuantity(recordBook.getQuantity() - 1);
            recordStudentBook = new StudentBook(studentId, bookId, borrowDate);
            studentBookDatabase.insertRecord(recordStudentBook);
            return 2;
            /*
            backend.Record newBook = new backend.Book(bookId, recordBook.getTitle(), recordBook.getAuthorName(), recordBook.getPublisherName(), recordBook.getQuantity() - 1);
            bookDatabase.deleteRecord(bookId);
            bookDatabase.insertRecord(newBook);
            backend.Record newStudentBook = new backend.StudentBook(studentId, bookId, borrowDate);
            studentBookDatabase.insertRecord(newStudentBook);
            return 2;*/
        }
    }

    //Calculates the fine for a student
    double calcReturnFee(LocalDate borrowDate, LocalDate returnDate) {

        int dateDifference = (int) ChronoUnit.DAYS.between(borrowDate, returnDate);
        if (dateDifference < 7) {
            return 0;
        } else {
            return ((dateDifference - 7) * 0.5);
        }
    }

    //Student returns a book
    public double returnBook(String studentId, String bookId, LocalDate returnDate) {

        double returnFee = calcReturnFee(((StudentBook) studentBookDatabase.getRecord(studentId + "," + bookId)).getBorrowDate(), returnDate);
        Book recordBook = (Book) bookDatabase.getRecord(bookId);
        recordBook.setQuantity(recordBook.getQuantity() + 1);
        studentBookDatabase.deleteRecord(studentId + "," + bookId);

        return returnFee;
    }

    public void logout() {

        bookDatabase.saveToFile();
        studentBookDatabase.saveToFile();
        System.out.println("You have been logged out successfully");
    }
}
