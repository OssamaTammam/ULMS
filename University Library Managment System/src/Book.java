public class Book implements Record {

    private String bookId;
    private String title;
    private String authorName;
    private String publisherName;
    private int quantity;

    public Book(String bookId, String title, String authorName, String publisherName, int quantity) {

        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    //Returns a string representation of the book
    public String lineRepresentation() {

        return (bookId + "," + title + "," + authorName + "," + publisherName + "," + quantity);
    }

    //Returns the book id
    public String getSearchKey() {

        return bookId;
    }
}
