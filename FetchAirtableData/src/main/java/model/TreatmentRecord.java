package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TreatmentRecord implements Serializable {

    // @XmlAttribute(name = "id")
    @JsonProperty("id")
    private String id;

    // @XmlElement(name="TreatmentFields")
    @JsonProperty("fields")
    private TreatmentFields fields;

    // @XmlElement(name="createdTime")
    @JsonProperty("createdTime")
    private String createdTime;

    // should never call this function after initialization
    public void setid(String id) {
        this.id = id;
    }

    public String getid(){
        return id;
    }

    public TreatmentFields getFields() {
        return fields;
    }

    public void setFields(TreatmentFields fields) {
        this.fields = fields;
    }

    public void setCreatedTime(String createdTime){
        this.createdTime = createdTime;
    }
    public String getCreatedTime(){
        return this.createdTime;
    }
}
