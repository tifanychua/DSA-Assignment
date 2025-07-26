
package entity;

public class Patient {
    private String ic;
    private String name;
    private String studID;
    private String phoneNum;
    private String birthDate;
    private String gender;
    private String bloodType;
    private String allergies;
    private String chronicDiseases;
    private String address;
    private String pastSurgeries;
    private String vacc;
    private String familyMedicalHis;
    private String appDate;
    private String doctorAss;
    private String occupation;
    private String maritalStatus;
    private String religion;
    private String smokingHabit;
    private String emerContactName;
    private String emerContactPhone;
    private String emerRelationship;
    
    public Patient(){
        
    }

    public Patient(String ic, String name, String studID, String phoneNum, String birthDate,String gender, String bloodType, String allergies, String chronicDiseases,String address, String pastSurgeries, String vacc, String familyMedicalHis,String appDate, String doctorAss, String occupation, String maritalStatus,String religion, String smokingHabit, String emerContactName,String emerContactPhone, String emerRelationship) {
    this.ic = ic;
    this.name = name;
    this.studID = studID;
    this.phoneNum = phoneNum;
    this.birthDate = birthDate;
    this.gender = gender;
    this.bloodType = bloodType;
    this.allergies = allergies;
    this.chronicDiseases = chronicDiseases;
    this.address = address;
    this.pastSurgeries = pastSurgeries;
    this.vacc = vacc;
    this.familyMedicalHis = familyMedicalHis;
    this.appDate = appDate;
    this.doctorAss = doctorAss;
    this.occupation = occupation;
    this.maritalStatus = maritalStatus;
    this.religion = religion;
    this.smokingHabit = smokingHabit;
    this.emerContactName = emerContactName;
    this.emerContactPhone = emerContactPhone;
    this.emerRelationship = emerRelationship;
}
    
    

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getChronicDiseases() {
        return chronicDiseases;
    }

    public void setChronicDiseases(String chronicDiseases) {
        this.chronicDiseases = chronicDiseases;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPastSurgeries() {
        return pastSurgeries;
    }

    public void setPastSurgeries(String pastSurgeries) {
        this.pastSurgeries = pastSurgeries;
    }

    public String getVacc() {
        return vacc;
    }

    public void setVacc(String vacc) {
        this.vacc = vacc;
    }

    public String getFamilyMedicalHis() {
        return familyMedicalHis;
    }

    public void setFamilyMedicalHis(String familyMedicalHis) {
        this.familyMedicalHis = familyMedicalHis;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getDoctorAss() {
        return doctorAss;
    }

    public void setDoctorAss(String doctorAss) {
        this.doctorAss = doctorAss;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSmokingHabit() {
        return smokingHabit;
    }

    public void setSmokingHabit(String smokingHabit) {
        this.smokingHabit = smokingHabit;
    }

    public String getEmerContactName() {
        return emerContactName;
    }

    public void setEmerContactName(String emerContactName) {
        this.emerContactName = emerContactName;
    }

    public String getEmerContactPhone() {
        return emerContactPhone;
    }

    public void setEmerContactPhone(String emerContactPhone) {
        this.emerContactPhone = emerContactPhone;
    }

    public String getEmerRelationship() {
        return emerRelationship;
    }

    public void setEmerRelationship(String emerRelationship) {
        this.emerRelationship = emerRelationship;
    }
    
    
    @Override
public String toString() {
    return "Patient{" +
            "IC='" + ic + '\'' +
            ", Name='" + name + '\'' +
            ", ID='" + studID + '\'' +
            ", Phone='" + phoneNum + '\'' +
            ", BirthDate='" + birthDate + '\'' +
            ", Gender='" + gender + '\'' +
            ", BloodType='" + bloodType + '\'' +
            ", Allergies='" + allergies + '\'' +
            ", ChronicDiseases='" + chronicDiseases + '\'' +
            ", Address='" + address + '\'' +
            ", SurgeryHistory='" + pastSurgeries + '\'' +
            ", VaccineHistory='" + vacc + '\'' +
            ", FamilyHistory='" + familyMedicalHis + '\'' +
            ", AppointmentDate='" + appDate + '\'' +
            ", Doctor='" + doctorAss + '\'' +
            ", Occupation='" + occupation + '\'' +
            ", MaritalStatus='" + maritalStatus + '\'' +
            ", Religion='" + religion + '\'' +
            ", Smoker='" + smokingHabit + '\'' +
            ", EmergencyContactName='" + emerContactName + '\'' +
            ", EmergencyContactPhone='" + emerContactPhone + '\'' +
            ", EmergencyContactRelation='" + emerRelationship + '\'' +
            '}';
}
}
