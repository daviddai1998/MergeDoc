package model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CodePerTreatmentFields {

    @JsonProperty("CPT Code")
    private List<String> cptCode;

    @JsonProperty("Treatment")
    private List<String> treatment;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("UCR Range")
    private List<String> ucrRange;

    @JsonProperty("Cash")
    private List<String> cash;


    @JsonProperty("Description")
    private List<String> description;

    @JsonProperty("UCR Avg")
    private List<String> ucrAvg;

    public List<String> getCptCode() {
        return cptCode;
    }

    public void setCptCode(List<String> cptCode) {
        this.cptCode = cptCode;
    }

    public List<String> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<String> treatment) {
        this.treatment = treatment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUcrRange() {
        return ucrRange;
    }

    public void setUcrRange(List<String> ucrRange) {
        this.ucrRange = ucrRange;
    }

    public List<String> getCash() {
        return cash;
    }

    public void setCash(List<String> cash) {
        this.cash = cash;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<String> getUcrAvg() {
        return ucrAvg;
    }

    public void setUcrAvg(List<String> ucrAvg) {
        this.ucrAvg = ucrAvg;
    }
}
