import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BookDatabase {

    private ArrayList<Book> records = new ArrayList<Book>();
    private String fileName;

    private File recordsFile;

    public BookDatabase(String fileName) {

        this.fileName = fileName;
    }

    public void readFromFile() {

        recordsFile = new File(fileName);

        // reads all the records of the books from the file and store them in the record array
        try {

            Scanner scanner = new Scanner(recordsFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                Book book = new Book(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                records.add(book);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error no file found");
        }
    }

    public Book createRecordFrom(String line) {

        String[] parts = line.split(",");
        Book book = new Book(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
        return book;
    }

    public ArrayList<Book> returnAllRecords() {

        return records;
    }

    public boolean contains(String key) {

        for (Book book : records) {
            if (book.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Book getRecord(String key) {

        for (Book book : records) {
            if (book.getSearchKey().equals(key)) {
                return book;
            }
        }
        return null;
    }

    public void insertRecord(Book book) {

        records.add(book);
    }

    public void deleteRecord(String key) {

        for (Book book : records) {
            if (book.getSearchKey().equals(key)) {
                records.remove(book);
                break;
            }
        }
    }

    public void saveToFile() {

        recordsFile = new File(fileName);

        try {

            BufferedWriter writeAllData = new BufferedWriter(new FileWriter(recordsFile, false));

            for (Book book : records) {
                String info = book.lineRepresentation();
                writeAllData.write(info);
                writeAllData.newLine();
            }
            writeAllData.close();
        } catch (Exception e) {
            System.out.println("Error no file found");
        }
    }
}



