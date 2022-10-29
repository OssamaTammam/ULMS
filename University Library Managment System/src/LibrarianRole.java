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



}
