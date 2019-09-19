package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CPTLookUpRecord {

    @JsonProperty("id")
    private String id;


    @JsonProperty("fields")
    private CPTLookUpFields fields;


    @JsonProperty("createdTime")
    private String createdTime;


    public void setid(String id) {
        this.id = id;
    }

    public String getid(){
        return id;
    }

    public CPTLookUpFields getFields() {
        return fields;
    }

    public void setFields(CPTLookUpFields fields) {
        this.fields = fields;
    }

    public void setCreatedTime(String createdTime){
        this.createdTime = createdTime;
    }
    public String getCreatedTime(){
        return this.createdTime;
    }
}
