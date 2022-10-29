import java.time.LocalDate;

public class StudentBookDatabase extends Database {

    String fileName;

    public StudentBookDatabase(String fileName) {
        super(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public Record createRecordFromLine(String line) {

        String[] parts = line.split(",");
        Record newRecord = new StudentBook(parts[0], parts[1], LocalDate.now());
        return newRecord;
    }









}
