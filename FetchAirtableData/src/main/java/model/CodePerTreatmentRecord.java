package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CodePerTreatmentRecord implements Serializable {

    @JsonProperty("id")
    private String id;


    @JsonProperty("fields")
    private CodePerTreatmentFields fields;


    @JsonProperty("createdTime")
    private String createdTime;


    public void setid(String id) {
        this.id = id;
    }

    public String getid(){
        return id;
    }

    public CodePerTreatmentFields getFields() {
        return fields;
    }

    public void setFields(CodePerTreatmentFields fields) {
        this.fields = fields;
    }

    public void setCreatedTime(String createdTime){
        this.createdTime = createdTime;
    }
    public String getCreatedTime(){
        return this.createdTime;
    }
}
