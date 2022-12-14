package backend;

public class BookDatabase extends Database {

    public BookDatabase(String fileName) {
        super(fileName);
    }


    //Create a new book record from a line of text
    public Record createRecordFromLine(String line) {

        String[] parts = line.split(",");
        return new Book(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
    }

    public void updateBookQuantity(String bookId,int newQuantity) {

        Book book = (Book) getRecord(bookId);
        book.setQuantity(newQuantity);
        deleteRecord(bookId);
        insertRecord(book);
    }
}



