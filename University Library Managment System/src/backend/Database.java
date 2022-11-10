package backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

abstract public class Database {

    private ArrayList<Record> records = new ArrayList<Record>();
    File recordsFile;
    String fileName;

    abstract public Record createRecordFromLine(String line);

    public Database(String fileName) {
        this.fileName = fileName;
    }

    //Loads the records from the file
    public void readFromFile() {

        recordsFile = new File(fileName);
        // reads all the records from the file and stores them in the record array
        try {

            Scanner scanner = new Scanner(recordsFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Record myObject = createRecordFromLine(line);
                records.add(myObject);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error no file found");
        }
    }

    //Returns an arraylist of all records stored in the system
    public ArrayList<Record> returnAllRecords() {

        return records;
    }

    //Checks if the system contains a record with the given key
    public boolean contains(String key) {

        for (Record record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    //Returns the record with the given key if found
    public Record getRecord(String key) {

        for (Record record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    //Inserts a new record into the system
    public void insertRecord(Record record) {

        records.add(record);
    }

    //Deletes a record from the system
    public void deleteRecord(String key) {

        Record deletedRecord = getRecord(key);
        records.remove(deletedRecord);
    }

    //Saves the records to the file
    public void saveToFile() {

        try {

            BufferedWriter writeAllData = new BufferedWriter(new FileWriter(recordsFile, false));
            for (Record record : records) {
                String info = record.lineRepresentation();
                writeAllData.write(info);
                writeAllData.newLine();
            }
            writeAllData.close();
        } catch (Exception e) {
            System.out.println("Couldn't write to file");
        }
    }
}
