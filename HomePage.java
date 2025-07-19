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
import java.awt.event.*;

public class HomePage extends JFrame{
    
    public HomePage(){

        ImageIcon img1 = new ImageIcon(getClass().getResource("picture/procrastinating.png"));
        ImageIcon img2 = new ImageIcon(getClass().getResource("picture/appointment.png"));
        ImageIcon img3 = new ImageIcon(getClass().getResource("picture/doctor.png"));
        ImageIcon img4 = new ImageIcon(getClass().getResource("picture/examination.png"));
        ImageIcon img5 = new ImageIcon(getClass().getResource("picture/medical-condition.png"));
        ImageIcon img6 = new ImageIcon(getClass().getResource("picture/prescription.png"));
        ImageIcon img7 = new ImageIcon(getClass().getResource("picture/drugstore.png"));
        ImageIcon img8 = new ImageIcon(getClass().getResource("picture/analysis.png")); 

        JButton btnQueue = new JButton("Queue", img1);
        JButton btnAppointment = new JButton("Appointments", img2);
        JButton btnDoctors = new JButton("Doctors", img3);
        JButton btnPatients = new JButton("Patients", img4);
        JButton btnDisgnosis = new JButton("Disgnosis", img5);
        JButton btnPresciption = new JButton("Presciption", img6);
        JButton btnMedical = new JButton("Medical Store", img7);
        JButton btnReport = new JButton("Report", img8);
        
        btnQueue.setHorizontalTextPosition(SwingConstants.CENTER);
        btnQueue.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnQueue.setIconTextGap(20);
        
        btnAppointment.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAppointment.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAppointment.setIconTextGap(20);
        
        btnDoctors.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDoctors.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDoctors.setIconTextGap(20);
        
        btnPatients.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPatients.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnPatients.setIconTextGap(20);
        
        btnDisgnosis.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDisgnosis.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDisgnosis.setIconTextGap(20);
        
        btnPresciption.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPresciption.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnPresciption.setIconTextGap(20);
        
        btnMedical.setHorizontalTextPosition(SwingConstants.CENTER);
        btnMedical.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnMedical.setIconTextGap(20);
        
        btnMedical.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new MedicalStorePage();
            }
        });
        
        btnReport.setHorizontalTextPosition(SwingConstants.CENTER);
        btnReport.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnReport.setIconTextGap(20);
        
        Font font2 = new Font("Arial", Font.BOLD, 20);
        btnQueue.setFont(font2);
        btnAppointment.setFont(font2);
        btnDoctors.setFont(font2);
        btnPatients.setFont(font2);
        btnDisgnosis.setFont(font2);
        btnPresciption.setFont(font2);
        btnMedical.setFont(font2);
        btnReport.setFont(font2);
             
        JPanel p1 = new JPanel(new GridLayout(3, 3, 30, 30));
        p1.add(btnQueue);
        p1.add(btnAppointment);
        p1.add(btnDoctors);
        p1.add(btnPatients);
        p1.add(btnDisgnosis);
        p1.add(btnPresciption);
        p1.add(btnMedical);
        p1.add(btnReport);
        
        JPanel p2 = new JPanel(new BorderLayout());
        p2.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        p2.add(p1, BorderLayout.CENTER);
        add(p2);

        setJMenuBar(new MenuBar().createMenuBar());
        setTitle("Home Page");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new HomePage();
    }
}
