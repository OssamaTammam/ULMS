public class BookDatabase extends Database {

    private String fileName;

    public BookDatabase(String fileName) {
        super(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public Record createRecordFromLine(String line) {

        String parts[] = line.split(",");
        Record newRecord = new Book(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
        return newRecord;
    }
}



