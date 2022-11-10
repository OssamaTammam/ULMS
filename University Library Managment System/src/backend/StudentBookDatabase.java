package backend;

import java.time.LocalDate;

public class StudentBookDatabase extends Database {

    public StudentBookDatabase(String fileName) {
        super(fileName);
    }

    //Create a new student book record from a line of text
    public Record createRecordFromLine(String line) {

        String[] parts = line.split(",");
        return new StudentBook(parts[0], parts[1], LocalDate.parse(parts[2]));
    }
}
