import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarianUserDatabase {

    private ArrayList<LibrarianUser> records = new ArrayList<LibrarianUser>();
    private String fileName;
    private File recordsFile;

    public LibrarianUserDatabase(String fileName) {

        this.fileName = fileName;
    }

    public void readFromFile() {

        recordsFile = new File(fileName);

        // reads all the records of the librarians from the file and store them in the record array
        try {

            Scanner scanner = new Scanner(recordsFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                LibrarianUser librarian = new LibrarianUser(parts[0], parts[1], parts[2], parts[3], parts[4]);
                records.add(librarian);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error no file found");
        }
    }

    public LibrarianUser createRecordFromLine(String line) {

        String[] parts = line.split(",");
        LibrarianUser librarian = new LibrarianUser(parts[0], parts[1], parts[2], parts[3], parts[4]);
        return librarian;
    }

    public ArrayList<LibrarianUser> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {

        for (LibrarianUser librarian : records) {
            if (librarian.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public LibrarianUser getRecord(String key) {

        for (LibrarianUser librarian : records) {
            if (librarian.getSearchKey().equals(key)) {
                return librarian;
            }
        }
        return null;
    }

    public void insertRecord(LibrarianUser record) {

        records.add(record);
    }

    public void deleteRecord(String key) {

        LibrarianUser deletedLibrarian = getRecord(key);
        records.remove(deletedLibrarian);
    }

    public void saveToFile() {

        try {
            if (!recordsFile.exists()) {
                recordsFile = new File(fileName);
            }
            FileWriter myWriter = new FileWriter(fileName);
            for (LibrarianUser librarian : records) {
                String newLine = librarian.lineRepresentation();
                myWriter.write(newLine + System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println("Couldn't write to file");
        }
    }

        /*try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < records.length; i++) {
                writer.write(records[i].lineRepresentation());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }*/
}