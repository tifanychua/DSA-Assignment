
package control;

import utility.MessageUI;
import adt.ArrayList;
import adt.PatientInterface;
import boundary.PatientInfo;
import boundary.PatientRegister;
import dao.PatientInitializer;
import entity.Patient;


import javax.swing.*;


public class PatientControl {
  private static JFrame frame;
  private PatientInitializer initializer = new PatientInitializer();
  private static PatientInterface<Patient> patientList;
  private PatientRegister patientUI;
  private MessageUI errorMessage = new MessageUI();
  private String ic;
  private String name;
  private Patient patient;
  private Patient newPatient; 
    
  
  public PatientControl(JFrame frame, PatientRegister patientUI) {
    this.frame = frame;
    this.patientUI = patientUI;
    
  }
  
  
  public void processSumbitIC(){
      ic = patientUI.getEnteredIC();
      JTextField tfIC=patientUI.getTfIC();
      
       if (ic.isEmpty()) {
            errorMessage.displayEmptyICMessage();
            tfIC.setText("");
        }else if (!ic.matches("\\d{12}")) {
            errorMessage.displayInvalidFormatICMessage();
            tfIC.setText("");
        }else {
            boolean found = searchPatient(ic);
            if (found) {
                if (errorMessage.showICConfirmation(name)) {
                    switchToInfoPage(patient,false);
                }
            } else {
                if (errorMessage.addPatientConfirmMessage(ic)) {
                    switchToInfoPage(newPatient,true);
                }
            }
        } 
  }
  
  private boolean searchPatient(String ic) {
    patientList = initializer.initializePatients();
    for (int i = 1; i <= patientList.getNumberOfEntries(); i++) {
        Patient p = patientList.getEntry(i);
        String cleanedPatientIC = p.getIc().replace("-", "");
        patient = new Patient();
        
        if (cleanedPatientIC.equals(ic)) {
           
            patient.setIc(p.getIc());
            name=p.getName();
            patient.setName(p.getName());
            patient.setStudID(p.getStudID());
            patient.setPhoneNum(p.getPhoneNum());
            patient.setBirthDate(p.getBirthDate());
            patient.setGender(p.getGender());
            patient.setBloodType(p.getBloodType());
            patient.setAllergies(p.getAllergies());
            patient.setChronicDiseases(p.getChronicDiseases());
            patient.setAddress(p.getAddress());
            patient.setPastSurgeries(p.getPastSurgeries());
            patient.setVacc(p.getVacc());
            patient.setFamilyMedicalHis(p.getFamilyMedicalHis());
            patient.setAppDate(p.getAppDate());
            patient.setDoctorAss(p.getDoctorAss());
            patient.setOccupation(p.getOccupation());
            patient.setMaritalStatus(p.getMaritalStatus());
            patient.setReligion(p.getReligion());
            patient.setSmokingHabit(p.getSmokingHabit());
            patient.setEmerContactName(p.getEmerContactName());
            patient.setEmerContactPhone(p.getEmerContactPhone());
            patient.setEmerRelationship(p.getEmerRelationship());
            return true;
        }
        
        
    }
        newPatient = new Patient();
        newPatient.setIc(ic);
        return false;

}
  
  public static void printAllPatients() {
    System.out.println("=== All Patient Records ===\n");
    for (int i = 1; i <= patientList.getNumberOfEntries(); i++) {
        System.out.println("Patient " + i + ":");
        System.out.println(patientList.getEntry(i)); 
        System.out.println("--------------------------------------------------");
    }
}


    private void switchToInfoPage(Patient patient,boolean isNew) {
        frame.getContentPane().removeAll();
        JPanel regPage = new PatientInfo(frame, patientUI,patient,isNew);
        frame.add(regPage);
        frame.revalidate();
        frame.repaint();
        
        
    }
  
  
}
