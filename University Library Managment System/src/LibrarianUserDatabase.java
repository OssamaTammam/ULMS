public class LibrarianUserDatabase extends Database {

    private String fileName;

    public LibrarianUserDatabase(String fileName) {
        super(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public Record createRecordFromLine(String line) {

        String parts[] = line.split(",");
        Record newRecord = new LibrarianUser(parts[0], parts[1], parts[2], parts[3], parts[4]);
        return newRecord;
    }


}