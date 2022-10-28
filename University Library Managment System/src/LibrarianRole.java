import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LibrarianRole extends LibrarianUserDatabase {

    BookDatabase bookDatabase;
    StudentBookDatabase studentBookDatabase;

    public LibrarianRole(String fileName, BookDatabase bookDatabase, StudentBookDatabase studentBookDatabase) {
        super(fileName);
        this.bookDatabase = bookDatabase;
        this.studentBookDatabase = studentBookDatabase;
    }

    public void addBook(String id, String title, String authorName, String publisherName, int quantity) throws IOException {

        Book book = new Book(id, title, authorName, publisherName, quantity);
        bookDatabase.insertRecord(book);
        BufferedWriter addBook = new BufferedWriter(new FileWriter(bookDatabase.getFileName(), true));
        String bookData = book.lineRepresentation();
        addBook.append(bookData);
        addBook.newLine();
        addBook.close();
    }

    public Book[] getListOfBooks() {

        readFromFile();
        Book[] books = new Book[bookDatabase.returnAllRecords().size()];
        books = bookDatabase.returnAllRecords().toArray(books);
        return books;
    }




}
