import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentBookDatabase {

    private ArrayList<StudentBook> records = new ArrayList<StudentBook>();
    String fileName;
    File recordsFile;

    public String getFileName() {
        return fileName;
    }

    public StudentBookDatabase(String fileName) {
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
                StudentBook studentBook = new StudentBook(parts[0], parts[1], LocalDate.now());
                records.add(studentBook);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error no file found");
        }
    }

    public StudentBook createRecordFrom(String line) {

        String[] parts = line.split(",");
        StudentBook studentBook = new StudentBook(parts[0], parts[1], LocalDate.now());
        return studentBook;
    }

    public ArrayList<StudentBook> returnAllRecords() {

        return records;
    }

    public boolean contains(String key) {

        for (StudentBook studentBook : records) {
            if ((studentBook.getSearchKey().equals(key))) {
                return true;
            }
        }
        return false;
    }

    public StudentBook getRecord(String key) {

        for (StudentBook studentBook : records) {
            if (studentBook.getSearchKey().equals(key)) {
                return studentBook;
            }
        }
        return null;
    }

    public void insertRecord(StudentBook studentBook) {

        records.add(studentBook);
    }

    public void deleteRecord(String key) {

        for (StudentBook studentBook : records) {
            if (studentBook.getSearchKey().equals(key)) {
                records.remove(studentBook);
                break;
            }
        }
    }

    public void saveToFile() {

        try {

            BufferedWriter writeAllData = new BufferedWriter(new FileWriter(recordsFile, false));
            for (StudentBook studentBook : records) {
                String info = studentBook.lineRepresentation();
                writeAllData.write(info);
                writeAllData.newLine();
            }
            writeAllData.close();
        } catch (Exception e) {
            System.out.println("Couldn't write to file");
        }
    }
}
