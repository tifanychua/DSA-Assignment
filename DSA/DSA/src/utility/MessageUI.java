package utility;


import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class MessageUI {
     public static void displayInvalidFormatICMessage() {
        JOptionPane.showMessageDialog(null, "IC must be exactly 12 digits (numbers only).", "Format Error", JOptionPane.ERROR_MESSAGE);
    }
     
     public static void displayEmptyICMessage() {
        JOptionPane.showMessageDialog(null, "IC cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
     public static boolean showICConfirmation(String name) {
         int result =JOptionPane.showConfirmDialog(null, "The patient name is : " + name,"Confirmation", JOptionPane.YES_NO_OPTION);
         if (result == JOptionPane.YES_OPTION) {
             return true;
         }else{
            return  false;
         }
         
    }
     
     public static boolean addPatientConfirmMessage(String ic) {
        int result = JOptionPane.showConfirmDialog(null, "No such patient.\n Do you want do add this patient?","Add Patient",JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
             return true;
         }else{
            return  false;
         }
     }
     
}
