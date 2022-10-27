import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BookDatabase {

    private ArrayList<Book> records = new ArrayList<Book>();
    private String fileName;

    private File recordsFile;

    public BookDatabase (String fileName) {

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




}
