/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pei Wen
 */

import javax.swing.*;
import java.awt.*;

public class MenuBar {
    public JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(0, 50));
        
        JMenu menuHome = new JMenu("Queue");
        JMenu menuAppointment = new JMenu("Appointments");
        JMenu menuDoctors = new JMenu("Patients");
        JMenu menuPatients = new JMenu("Patients");
        JMenu menuDisgnosis = new JMenu("Disgnosis");
        JMenu menuPresciption = new JMenu("Presciption");
        JMenu menuMedical = new JMenu("Medical Store");
        JMenu menuReport = new JMenu("Report");
        
        menuBar.add(menuHome);
        menuBar.add(menuAppointment);
        menuBar.add(menuDoctors);
        menuBar.add(menuPatients);
        menuBar.add(menuDisgnosis);
        menuBar.add(menuPresciption);
        menuBar.add(menuMedical);
        menuBar.add(menuReport);
        
        Font font1 = new Font("Arial", Font.BOLD, 15);
        menuHome.setFont(font1);
        menuAppointment.setFont(font1);
        menuDoctors.setFont(font1);
        menuPatients.setFont(font1);
        menuDisgnosis.setFont(font1);
        menuPresciption.setFont(font1);
        menuMedical.setFont(font1);
        menuReport.setFont(font1);
        
        return menuBar;
    }
}
