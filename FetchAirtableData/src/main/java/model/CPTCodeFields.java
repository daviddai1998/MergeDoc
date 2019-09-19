package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CPTCodeFields {
    @JsonProperty("CPT Code")
    private String cptCode;

    @JsonProperty("Display Name")
    private String displayName;

    @JsonProperty("Body Region")
    private List<String> bodyRegion;

    @JsonProperty("Procedure Type")
    private List<String> procedureType;

    @JsonProperty("Procedure")
    private List<String> procedure;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("CPT Code Templates")
    private String cptCodeTemplate;

    @JsonProperty("Injury Pathway")
    private List<String> injuryPathway;

    @JsonProperty("Datasets Copy")
    private String datasetsCopy;

    @JsonProperty("CPT Code")
    private String datasetsCopy2;

    public String getCptCode() {
        return cptCode;
    }

    public void setCptCode(String cptCode) {
        this.cptCode = cptCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getBodyRegion() {
        return bodyRegion;
    }

    public void setBodyRegion(List<String> bodyRegion) {
        this.bodyRegion = bodyRegion;
    }

    public List<String> getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(List<String> procedureType) {
        this.procedureType = procedureType;
    }

    public List<String> getProcedure() {
        return procedure;
    }

    public void setProcedure(List<String> procedure) {
        this.procedure = procedure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCptCodeTemplate() {
        return cptCodeTemplate;
    }

    public void setCptCodeTemplate(String cptCodeTemplate) {
        this.cptCodeTemplate = cptCodeTemplate;
    }

    public List<String> getInjuryPathway() {
        return injuryPathway;
    }

    public void setInjuryPathway(List<String> injuryPathway) {
        this.injuryPathway = injuryPathway;
    }

    public String getDatasetsCopy() {
        return datasetsCopy;
    }

    public void setDatasetsCopy(String datasetsCopy) {
        this.datasetsCopy = datasetsCopy;
    }

    public String getDatasetsCopy2() {
        return datasetsCopy2;
    }

    public void setDatasetsCopy2(String datasetsCopy2) {
        this.datasetsCopy2 = datasetsCopy2;
    }
}
