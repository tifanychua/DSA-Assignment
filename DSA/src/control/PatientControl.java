/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import utility.MessageUI;
import adt.ArrayList;
import adt.PatientInterface;
import boundary.PatientInfo;
import boundary.PatientRegister;
import entity.Patient;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PatientControl {
  private JFrame frame;
  private PatientInterface<Patient> productList = new ArrayList<>();
  private PatientRegister patientUI = new PatientRegister(frame);
  private MessageUI errorMessage = new MessageUI();
  
  public void processSumbitIC(){
      String ic = patientUI.getEnteredIC();
      JTextField tfIC=patientUI.getTfIC();
      
       if (ic.isEmpty()) {
            errorMessage.displayEmptyICMessage();
            tfIC.setText("");
        }else if (!ic.matches("\\d{12}")) {
            errorMessage.displayInvalidFormatICMessage();
            tfIC.setText("");
        }else{
        if(ic.equals("123456789012")){
            boolean result = errorMessage.showICConfirmation(ic);
            if (result = true) {
                frame.getContentPane().removeAll();
                JPanel regPage = new PatientInfo(frame,patientUI); 
                frame.add(regPage);
                frame.revalidate();
                frame.repaint();
            } 
        }else{
           boolean result = errorMessage.addPatientConfimMessage(ic);
           if (result = true) {
                frame.getContentPane().removeAll();
                JPanel regPage = new PatientInfo(frame,patientUI); 
                frame.add(regPage);
                frame.revalidate();
                frame.repaint();
            } 
        }
        } 
  }
  
  
  public static void main(String[] args) {
    PatientControl control = new PatientControl();
    control.processSumbitIC();
  }
  
}
