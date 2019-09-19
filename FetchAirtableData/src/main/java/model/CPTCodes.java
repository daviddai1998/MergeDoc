package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CPTCodes {
    @JsonProperty("records")
    private ArrayList<CPTCodeRecord> records;
    public ArrayList<CPTCodeRecord> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<CPTCodeRecord> newRecords) {
        this.records = newRecords;
    }

    public int getLength() {
        return records.size();
    }
}

