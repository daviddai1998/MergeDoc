package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CPTLookUpFields {
    @JsonProperty("CPT Field")
    private String cptField;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("CASH")
    private String cash;

    @JsonProperty("UCR Low")
    private String ucrLow;

    @JsonProperty("UCR High")
    private String ucrHigh;

    @JsonProperty("Avg UCR")
    private String avgUcr;

    @JsonProperty("CPT Codes per Treatment")
    private List<String> cptCodesPerTreatment;

    @JsonProperty("UCR Range $")
    private String ucrRange;

    public String getCptField() {
        return cptField;
    }

    public void setCptField(String cptCode) {
        this.cptField = cptCode;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }


    public String getUcrLow() {
        return ucrLow;
    }

    public void setUcrLow(String ucrLow) {
        this.ucrLow = ucrLow;
    }

    public String getUcrHigh() {
        return ucrHigh;
    }

    public void setUcrHigh(String ucrHigh) {
        this.ucrHigh = ucrHigh;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvgUcr() {
        return avgUcr;
    }

    public void setAvgUcr(String avgUcr) {
        this.avgUcr = avgUcr;
    }

    public List<String> getCptCodesPerTreatment() {
        return cptCodesPerTreatment;
    }

    public void setCptCodesPerTreatment(List<String> cptCodesPerTreatment) {
        this.cptCodesPerTreatment = cptCodesPerTreatment;
    }

    public String getUcrRange() {
        return ucrRange;
    }

    public void setUcrRange(String ucrRange) {
        this.ucrRange = ucrRange;
    }

}
