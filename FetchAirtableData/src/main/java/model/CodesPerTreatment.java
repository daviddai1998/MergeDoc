package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;


public class CodesPerTreatment {

    @JsonProperty("records")
    private ArrayList<CodePerTreatmentRecord> records;

    private HashMap<String, CodePerTreatmentRecord> recordsMap = new HashMap<String, CodePerTreatmentRecord>();


    public ArrayList<CodePerTreatmentRecord> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<CodePerTreatmentRecord> newRecords) {
        this.records = newRecords;
    }

    public void buildMap() {
        if (this.getLength() != 0) {
            for (int i = 0; i < this.getLength(); i++) {
                CodePerTreatmentRecord current = getRecords().get(i);
                // System.out.println(current.getid());
                recordsMap.put(current.getid(), current);
            }
        }
    }

    public int getLength() {
        return records.size();
    }

    public CodePerTreatmentRecord getRecordById(String id) {
        if (recordsMap.containsKey(id)) {
            return recordsMap.get(id);
        }
        System.out.println("This key is not present");
        return null;
    }
}
