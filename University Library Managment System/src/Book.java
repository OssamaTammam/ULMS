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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String lineRepresentation() {

        String line = bookId + "," + title + "," + authorName + "," + publisherName + "," + quantity;
        return line;
    }

    public String getSearchKey() {

        return bookId;
    }
}
