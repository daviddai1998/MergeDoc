package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.EnumMap;
import java.util.List;

public class CaseInfoFields {
    private String caseId;
    private String reportStatus;
    private Date intake;
    private Date lawFirmDueDate;

    @JsonProperty("Case Style")
    private String caseStyle;

    private Boolean multiplePlaintiff;

    @JsonProperty("Cause Number")
    private String causeNumber;
    private String claimNumber;

    @JsonProperty("Court and County Info")
    private String courtAndCountyInfo;
    private Date lossDate;
    private String attorney;
    private String attorneyPhone;
    private String lawFirm;
    private String paralegalName;
    private String adjuster;
    private String intakeBy; // not necessary for Affidavit
    private String expertAssigned;
    private String expertReportInDate;
    private String caseReports;
    private String alternatePhone;
    private String request;
    private List<String> expertsKeyDates;
    private String plaintiffAttorney;
    private String accidentPhotos;
    private String accidentPhotosLocation;
    private Boolean allRecordsReceived;
    private String missingRecords;
    private String missingRecordsNotes;
    private Boolean mriFilmsReceived;
    private String mriFilmNotes;
    private List<String> emailRequest;
    private String emailRequestText;
    private String caseStatus;
    private String treatment;
    private String attachments;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Date getIntake() {
        return intake;
    }

    public void setIntake(Date intake) {
        this.intake = intake;
    }

    public Date getLawFirmDueDate() {
        return lawFirmDueDate;
    }

    public void setLawFirmDueDate(Date lawFirmDueDate) {
        this.lawFirmDueDate = lawFirmDueDate;
    }

    public String getCaseStyle() {
        return caseStyle;
    }

    public void setCaseStyle(String caseStyle) {
        this.caseStyle = caseStyle;
    }

    public Boolean getMultiplePlaintiff() {
        return multiplePlaintiff;
    }

    public void setMultiplePlaintiff(Boolean multiplePlaintiff) {
        this.multiplePlaintiff = multiplePlaintiff;
    }

    public String getCauseNumber() {
        return causeNumber;
    }

    public void setCauseNumber(String causeNumber) {
        this.causeNumber = causeNumber;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getCourtAndCountyInfo() {
        return courtAndCountyInfo;
    }

    public void setCourtAndCountyInfo(String courtAndCountyInfo) {
        this.courtAndCountyInfo = courtAndCountyInfo;
    }

    public Date getLossDate() {
        return lossDate;
    }

    public void setLossDate(Date lossDate) {
        this.lossDate = lossDate;
    }

    public String getAttorney() {
        return attorney;
    }

    public void setAttorney(String attorney) {
        this.attorney = attorney;
    }

    public String getAttorneyPhone() {
        return attorneyPhone;
    }

    public void setAttorneyPhone(String attorneyPhone) {
        this.attorneyPhone = attorneyPhone;
    }

    public String getLawFirm() {
        return lawFirm;
    }

    public void setLawFirm(String lawFirm) {
        this.lawFirm = lawFirm;
    }

    public String getParalegalName() {
        return paralegalName;
    }

    public void setParalegalName(String paralegalName) {
        this.paralegalName = paralegalName;
    }

    public String getAdjuster() {
        return adjuster;
    }

    public void setAdjuster(String adjuster) {
        this.adjuster = adjuster;
    }

    public String getIntakeBy() {
        return intakeBy;
    }

    public void setIntakeBy(String intakeBy) {
        this.intakeBy = intakeBy;
    }

    public String getExpertAssigned() {
        return expertAssigned;
    }

    public void setExpertAssigned(String expertAssigned) {
        this.expertAssigned = expertAssigned;
    }

    public String getExpertReportInDate() {
        return expertReportInDate;
    }

    public void setExpertReportInDate(String expertReportInDate) {
        this.expertReportInDate = expertReportInDate;
    }

    public String getCaseReports() {
        return caseReports;
    }

    public void setCaseReports(String caseReports) {
        this.caseReports = caseReports;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public List<String> getExpertsKeyDates() {
        return expertsKeyDates;
    }

    public void setExpertsKeyDates(List<String> expertsKeyDates) {
        this.expertsKeyDates = expertsKeyDates;
    }

    public String getPlaintiffAttorney() {
        return plaintiffAttorney;
    }

    public void setPlaintiffAttorney(String plaintiffAttorney) {
        this.plaintiffAttorney = plaintiffAttorney;
    }

    public String getAccidentPhotos() {
        return accidentPhotos;
    }

    public void setAccidentPhotos(String accidentPhotos) {
        this.accidentPhotos = accidentPhotos;
    }

    public String getAccidentPhotosLocation() {
        return accidentPhotosLocation;
    }

    public void setAccidentPhotosLocation(String accidentPhotosLocation) {
        this.accidentPhotosLocation = accidentPhotosLocation;
    }

    public Boolean getAllRecordsReceived() {
        return allRecordsReceived;
    }

    public void setAllRecordsReceived(Boolean allRecordsReceived) {
        this.allRecordsReceived = allRecordsReceived;
    }

    public String getMissingRecords() {
        return missingRecords;
    }

    public void setMissingRecords(String missingRecords) {
        this.missingRecords = missingRecords;
    }

    public String getMissingRecordsNotes() {
        return missingRecordsNotes;
    }

    public void setMissingRecordsNotes(String missingRecordsNotes) {
        this.missingRecordsNotes = missingRecordsNotes;
    }

    public Boolean getMriFilmsReceived() {
        return mriFilmsReceived;
    }

    public void setMriFilmsReceived(Boolean mriFilmsReceived) {
        this.mriFilmsReceived = mriFilmsReceived;
    }

    public String getMriFilmNotes() {
        return mriFilmNotes;
    }

    public void setMriFilmNotes(String mriFilmNotes) {
        this.mriFilmNotes = mriFilmNotes;
    }

    public List<String> getEmailRequest() {
        return emailRequest;
    }

    public void setEmailRequest(List<String> emailRequest) {
        this.emailRequest = emailRequest;
    }

    public String getEmailRequestText() {
        return emailRequestText;
    }

    public void setEmailRequestText(String emailRequestText) {
        this.emailRequestText = emailRequestText;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    // the fields we obtained from air table is not exactly the same as what we need in AFFIDAVIT,
    // maybe we should create a new affidavit class that has a constructor take in CaseInfoFields,
    // ExpertInfoFields and TreatmentsFields and then parse the value to get what we need in Affidavit there
    public EnumMap<AFFIDAVIT_ENUM, String> applyToMap(EnumMap<AFFIDAVIT_ENUM, String> caseInfoMap) {
        caseInfoMap.put(AFFIDAVIT_ENUM.CAUSE_NUMBER, causeNumber);
        caseInfoMap.put(AFFIDAVIT_ENUM.COURT_INFO, courtAndCountyInfo);
        // case style should be separate into plaintiff and defendant
        caseInfoMap.put(AFFIDAVIT_ENUM.PLAINTIFF, caseStyle.split(" vs ")[0]);
        caseInfoMap.put(AFFIDAVIT_ENUM.DEFENDANT, caseStyle.split(" vs ")[1]);
        return caseInfoMap;
    }
}
