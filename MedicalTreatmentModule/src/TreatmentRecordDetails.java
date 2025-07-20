/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDate;


// UI(view) -> control -> DA(model) -> Domain

public class TreatmentRecordDetails extends JFrame {

    private JTextField jtfTreatID = new JTextField(9);
    private JTextField jtfPatientName = new JTextField(20);
    private JTextField jtfDate = new JTextField(9);
    private JTextField jtfDoctor = new JTextField(9);
    private JTextField jtfDiagnosis = new JTextField();
    private JTextField jtfTreatment = new JTextField();
    private JTextField jtfNote = new JTextField();
    private JTextField jtfPatient = new JTextField();
    private JTextField jtfFollowUp = new JTextField();
    private JButton jbtBack = new JButton("Back");
    private JButton jbtEdit = new JButton("Edit");
    private JButton jbtDel = new JButton("Delete");
    private JLabel topLabel=new JLabel("Patient Treatment Details");

    public TreatmentRecordDetails() {
        JPanel jpTop=new JPanel();
        JPanel jpInfo=new JPanel(new FlowLayout(FlowLayout.LEFT,100,5));
        Font font = new Font("SansSerif", Font.BOLD, 56); 
        topLabel.setFont(font);
        jpTop.add(topLabel,BorderLayout.CENTER);
        JPanel jpCenter = new JPanel(new GridLayout(7, 2,50,20));
        JLabel labelTreatmentID = new JLabel("Treatment ID: "+"2507191001");
                labelTreatmentID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 1000));

        labelTreatmentID.setFont(new Font("SansSerif", Font.PLAIN, 32));
        jpInfo.add(labelTreatmentID);
        LocalDate today = LocalDate.now();
        JLabel labelDate = new JLabel("Date: "+today.toString());
        labelDate.setFont(new Font("SansSerif", Font.PLAIN, 32));
        jpInfo.add(labelDate);
        JLabel labelPatient = new JLabel("Patient Name");
        labelPatient.setFont(new Font("SansSerif", Font.BOLD, 40));
        jpCenter.add(labelPatient);
        jpCenter.add(jtfPatientName);
        JLabel labelDoctor = new JLabel("Doctor");
        labelDoctor.setFont(new Font("SansSerif", Font.BOLD, 40));
        jpCenter.add(labelDoctor);
        jpCenter.add(jtfDoctor);
        JLabel labelDiagnosis = new JLabel("Diagnosis");
        labelDiagnosis.setFont(new Font("SansSerif", Font.BOLD, 40));
        jpCenter.add(labelDiagnosis);
        jpCenter.add(jtfDiagnosis);
        JLabel labelType = new JLabel("Type of Treatment");
        labelType.setFont(new Font("SansSerif", Font.BOLD, 40));
        jpCenter.add(labelType);
        jpCenter.add(jtfTreatment);
        JLabel labelTreatment = new JLabel("Treatment Notes");
        labelTreatment.setFont(new Font("SansSerif", Font.BOLD, 40));
        jpCenter.add(labelTreatment);
        jpCenter.add(jtfNote);
        JLabel labelPatientStatus = new JLabel("Patient Status");
        labelPatientStatus.setFont(new Font("SansSerif", Font.BOLD, 40));
        jpCenter.add(labelPatientStatus);
        jpCenter.add(jtfPatient);
        JLabel labelFollowUp = new JLabel("Follow-up Required");
        labelFollowUp.setFont(new Font("SansSerif", Font.BOLD, 40));
        jpCenter.add(labelFollowUp);
        ButtonGroup followButton=new ButtonGroup();
        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
        JRadioButton yesBtn=new JRadioButton("Yes");
        JRadioButton noBtn=new JRadioButton("No");
    followButton.add(yesBtn);
    followButton.add(noBtn);
    buttonPanel.add(yesBtn);
    buttonPanel.add(noBtn);
    
    Font rbFont = new Font("SansSerif", Font.BOLD, 35);
    yesBtn.setFont(rbFont);
    noBtn.setFont(rbFont);
    jpCenter.add(buttonPanel,BorderLayout.WEST);
        add(jpTop,BorderLayout.NORTH);
        add(jpInfo);
        JPanel jpSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
        JPanel jpForm=new JPanel(new BorderLayout());
        JPanel infoForm=new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoForm.add(jpInfo,FlowLayout.LEFT);
        add(infoForm,BorderLayout.NORTH);
        jpForm.add(jpTop,BorderLayout.NORTH);
        jpForm.add(jpCenter);
        JPanel formPn=new JPanel(new FlowLayout());
        formPn.add(jpForm);
        add(formPn);
        jpSouth.add(jbtBack);
        jpSouth.add(jbtEdit);
        jpSouth.add(jbtDel);
        add(jpSouth, BorderLayout.SOUTH);
        jpInfo.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        jpTop.setBorder(BorderFactory.createEmptyBorder(0, 0, 90, 0));
        jpSouth.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        Dimension buttonSize = new Dimension(150, 50); 
jbtBack.setPreferredSize(buttonSize);
jbtEdit.setPreferredSize(buttonSize);
jbtDel.setPreferredSize(buttonSize);
    }
    
    
    public static void main(String[] args) {
          TreatmentRecordDetails frm=new TreatmentRecordDetails();   
          frm.setTitle("Treatment Record Details");
          frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frm.setLocationRelativeTo(null);
          frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frm.setVisible(true);
    }
}
