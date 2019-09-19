package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FacilityFields {
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Facility Type")
    private String facilityType;

    @JsonProperty("Providers")
    private List<String> providers;

    @JsonProperty("Address Line 1")
    private String addressLine1;

    @JsonProperty("Address Line 2")
    private String addressLine2;

    @JsonProperty("Address Line 3")
    private String addressLine3;

    @JsonProperty("State/County")
    private String state;

    @JsonProperty("Zip/Post Code")
    private String zipCode;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Web Site")
    private String website;

    @JsonProperty("Treatment")
    private String treatment;

    @JsonProperty("CPT Codes per Treatment")
    private List<String> cptCodePerTreatment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(List<String> providers) {
        this.providers = providers;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getCptCodePerTreatment() {
        return cptCodePerTreatment;
    }

    public void setCptCodePerTreatment(List<String> cptCodePerTreatment) {
        this.cptCodePerTreatment = cptCodePerTreatment;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
