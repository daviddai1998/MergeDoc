package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CaseInfos {
    @JsonProperty("records")
    private ArrayList<CaseInfoRecord> records;

    @JsonProperty("offset")
    private String offset;

    public ArrayList<CaseInfoRecord> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<CaseInfoRecord> newRecords) {
        this.records = newRecords;
    }

    public int getLength() {
        return records.size();
    }
}
