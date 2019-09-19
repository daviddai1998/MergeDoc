package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;

 // not sure what does this xml do
// @XmlAccessorType(XmlAccessType.NONE)
// @XmlRootElement(name = "Treatments")

 public class Treatments {

     @JsonProperty("records")
     private ArrayList<TreatmentRecord> records;
     public ArrayList<TreatmentRecord> getRecords() {
         return records;
     }

     public void setRecords(ArrayList<TreatmentRecord> newRecords) {
         this.records = newRecords;
     }

     public int getLength() {
         return records.size();
     }
 }
