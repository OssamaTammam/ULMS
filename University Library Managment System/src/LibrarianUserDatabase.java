import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class LibrarianUserDatabase {

    private LibrarianUser[] records;
    private String fileName;

    public LibrarianUserDatabase(String fileName) {

        this.fileName = fileName;
        records = new LibrarianUser[0];
    }

    public void readFromFile() {

        File file = new File(fileName);

        // reads all the records of the librarians from the file and store them in the record array
        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                LibrarianUser librarian = new LibrarianUser(parts[0], parts[1], parts[2], parts[3], parts[4]);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public LibrarianUser createRecordFromLine(String line) {

        String[] parts = line.split(",");
        LibrarianUser librarian = new LibrarianUser(parts[0], parts[1], parts[2], parts[3], parts[4]);

        return librarian;
    }

    public LibrarianUser[] returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {

        for (int i = 0; i < records.length; i++) {
            if (records[i].getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public LibrarianUser getRecord(String key) {

        for (int i = 0; i < records.length; i++) {
            if (records[i].getSearchKey().equals(key)) {
                return records[i];
            }
        }
        return null;
    }

    public void insertRecord(LibrarianUser record) {

        LibrarianUser[] newRecords = new LibrarianUser[records.length + 1];

        for (int i = 0; i < records.length; i++) {
            newRecords[i] = records[i];
        }

        newRecords[records.length] = record;
        records = newRecords;
    }

    public void deleteRecord(String key) {

        LibrarianUser[] newRecords = new LibrarianUser[records.length - 1];

        for (int i = 0; i < records.length; i++) {
            if (records[i].getSearchKey().equals(key)) {
                for (int j = 0; j < i; j++) {
                    newRecords[j] = records[j];
                }
                for (int j = i; j < newRecords.length; j++) {
                    newRecords[j] = records[j + 1];
                }
                records = newRecords;
            }
        }
    }

    public void saveToFile() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < records.length; i++) {
                writer.write(records[i].lineRepresentation());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}