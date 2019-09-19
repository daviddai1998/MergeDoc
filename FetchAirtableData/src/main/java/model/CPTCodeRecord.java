package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CPTCodeRecord implements Serializable {
    @JsonProperty("id")
    private String id;


    @JsonProperty("fields")
    private CPTCodeFields fields;


    @JsonProperty("createdTime")
    private String createdTime;


    public void setid(String id) {
        this.id = id;
    }

    public String getid(){
        return id;
    }

    public CPTCodeFields getFields() {
        return fields;
    }

    public void setFields(CPTCodeFields fields) {
        this.fields = fields;
    }

    public void setCreatedTime(String createdTime){
        this.createdTime = createdTime;
    }
    public String getCreatedTime(){
        return this.createdTime;
    }
}
