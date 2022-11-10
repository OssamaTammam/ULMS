package backend;

public class LibrarianUserDatabase extends Database {

    public LibrarianUserDatabase(String fileName) {
        super(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    //Create a new librarian record from a line of text
    public Record createRecordFromLine(String line) {

        String[] parts = line.split(",");
        return new LibrarianUser(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }


}