package model;

// import java.util.ArrayList;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.EnumMap;
import java.util.List;
//@XmlAccessorType(XmlAccessType.NONE)
//@XmlRootElement(name = "TreatmentFields")
public class TreatmentFields {
    // @XmlAttribute(name = "Date_Of_Service")
    @JsonProperty("Date Of Service")
    private Date dateOfService;

    // @XmlAttribute(name = "Case_Info")
    @JsonProperty("Case Info")
    private List<String> caseInfo;

    // @XmlAttribute(name = "Facility")
    @JsonProperty("Facility")
    private List<String> facility;

    @JsonProperty("CPT Code")
    private List<String> cptCode;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Plaintiff Charge")
    private String plaintiffCharge;


    @JsonProperty("CPT Description")
    private List<String> cptDescription;

    @JsonProperty("Units")
    private String units;

    // @XmlAttribute(name = "Provider")
    @JsonProperty("Provider")
    private List<String> provider;

    // @XmlAttribute(name = "Diagnosis")
    @JsonProperty("Diagnosis")
    private List<String> diagnosis;

    @JsonProperty("Referring Physician")
    private List<String> referringPhysician;

    // @XmlAttribute(name = "CPT_Codes_per_Treatment")
    @JsonProperty("CPT Codes per Treatment")
    private List<String> CPTCodesPerTreatment;

    @JsonProperty("Charge Description")
    private String chargeDescription;

    @JsonProperty("UCR Range")
    private List<String> ucrRange;

    @JsonProperty("Cash")
    private List<String> cash;

    @JsonProperty("UCR Avg")
    private List<String> ucrAvg;

    @JsonProperty("Charge - UCR Avg")
    private String difference;

    public Date getDateOfInjury() {
        return dateOfInjury;
    }

    public void setDateOfInjury(Date dateOfInjury) {
        this.dateOfInjury = dateOfInjury;
    }

    private Date dateOfInjury;

    @JsonProperty("Notes")
    private List<String> notes;

    @JsonProperty("Attachments")
    private List<String> attachments;

    @JsonProperty("Facilities copy")
    private List<String> facilitiesCopy;

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

    public List<String> getUcrAvg() {
        return ucrAvg;
    }

    public void setUcrAvg(List<String> ucrAvg) {
        this.ucrAvg = ucrAvg;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public void setDateOfService(Date dateOfService) {
        this.dateOfService = dateOfService;
    }

    public Date getDateOfService(){
        return this.dateOfService;
    }

    public void setCaseInfo(List<String> Case_Info){
        this.caseInfo = Case_Info;
    }

    public List<String> getCaseInfo(){
        return this.caseInfo;
    }

    public void setFacility(List<String> facility){
        this.facility = facility;
    }

    public List<String> getFacility(){
        return this.facility;
    }

    public void setProvider(List<String> provider){
        this.provider = provider;
    }

    public List<String> getProvider(){
        return this.provider;
    }

    public void setDiagnosis(List<String> diagnosis){
        this.diagnosis = diagnosis;
    }

    public List<String> getDiagnosis(){
        return this.diagnosis;
    }

    public void setCPTCodesPerTreatment(List<String> CPTCodesPerTreatment){
        this.CPTCodesPerTreatment = CPTCodesPerTreatment;
    }

    public List<String> getCPTCodesPerTreatment(){
        return this.CPTCodesPerTreatment;
    }

    public List<String> getCptCode() {
        return cptCode;
    }

    public void setCptCode(List<String> cptCode) {
        this.cptCode = cptCode;
    }

    public List<String> getReferringPhysician() {
        return referringPhysician;
    }

    public void setReferringPhysician(List<String> referringPhysician) {
        this.referringPhysician = referringPhysician;
    }

    public List<String> getCptDescription() {
        return cptDescription;
    }

    public void setCptDescription(List<String> cptDescription) {
        this.cptDescription = cptDescription;
    }

    public String getChargeDescription() {
        return chargeDescription;
    }

    public void setChargeDescription(String chargeDescription) {
        this.chargeDescription = chargeDescription;
    }

    public String getPlaintiffCharge() {
        return plaintiffCharge;
    }

    public void setPlaintiffCharge(String plaintiffCharge) {
        this.plaintiffCharge = plaintiffCharge;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public List<String> getFacilitiesCopy() {
        return facilitiesCopy;
    }

    public void setFacilitiesCopy(List<String> facilitiesCopy) {
        this.facilitiesCopy = facilitiesCopy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumMap<AFFIDAVIT_ENUM, String> applyToMap(EnumMap<AFFIDAVIT_ENUM, String> caseInfoMap) {
        caseInfoMap.put(AFFIDAVIT_ENUM.DATE_OF_INJURY, String.format("%tB %<te %<tY", dateOfInjury));
        return caseInfoMap;
    }
}
