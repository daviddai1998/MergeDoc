package model;

import java.util.EnumMap;
import java.util.List;

public class ExpertInfoFields {
    String expertName;
    List<String> speciality;
    String email;
    String phone;
    String cases;
    String intakeChecklist;
    String expertReports;
    String caseReports;
    String expertBlockedDates;
    String expertBlockedDatesCopy;

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public List<String> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(List<String> speciality) {
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getIntakeChecklist() {
        return intakeChecklist;
    }

    public void setIntakeChecklist(String intakeChecklist) {
        this.intakeChecklist = intakeChecklist;
    }

    public String getExpertReports() {
        return expertReports;
    }

    public void setExpertReports(String expertReports) {
        this.expertReports = expertReports;
    }

    public String getCaseReports() {
        return caseReports;
    }

    public void setCaseReports(String caseReports) {
        this.caseReports = caseReports;
    }

    public String getExpertBlockedDates() {
        return expertBlockedDates;
    }

    public void setExpertBlockedDates(String expertBlockedDates) {
        this.expertBlockedDates = expertBlockedDates;
    }

    public String getExpertBlockedDatesCopy() {
        return expertBlockedDatesCopy;
    }

    public void setExpertBlockedDatesCopy(String expertBlockedDatesCopy) {
        this.expertBlockedDatesCopy = expertBlockedDatesCopy;
    }

    public EnumMap<AFFIDAVIT_ENUM, String> applyToMap(EnumMap<AFFIDAVIT_ENUM, String> caseInfoMap) {
        caseInfoMap.put(AFFIDAVIT_ENUM.EXPERT_OPINION, expertReports);
        return caseInfoMap;
    }
}
