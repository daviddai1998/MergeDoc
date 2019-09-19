package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Facilities {
    @JsonProperty("records")
    private ArrayList<FacilityRecord> records;
    public ArrayList<FacilityRecord> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<FacilityRecord> newRecords) {
        this.records = newRecords;
    }

    public int getLength() {
        return records.size();
    }
}
