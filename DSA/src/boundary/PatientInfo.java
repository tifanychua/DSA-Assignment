package boundary;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PatientInfo extends JPanel{
    private JFrame frame;
    private JPanel previousPage;
    private JPanel buttonPanel;
    
    private JLabel IC;
    private JTextField tfIC;
    private JLabel name;
    private JTextField tfName;
    private JLabel studID;
    private JTextField tfStudID;
    private JLabel phoneNum;
    private JTextField tfPhoneNum;
    private JLabel birthDate;
    private JLabel gender;
    private JRadioButton maleBtn;
    private JRadioButton femaleBtn;
    private JTextField tfBirthDate;
    private JLabel bloodType;
    private JComboBox<String> tfBloodType;
    private JLabel allergies;
    private JTextArea  tfAllergies;
    private JLabel chronicDiseases;
    private JTextArea tfChronicDiseases;
    private JLabel address;
    private JTextArea tfAddress;
    private JLabel pastSurgeries;
    private JTextArea tfPastSurgeries;
    private JLabel vacc;
    private JTextArea tfVacc;
    private JLabel familyMedicalHis;
    private JTextArea tfFamilyMedicalHis;
    private JLabel appDate;
    private JTextField tfAppDate;
    private JLabel doctorAss;
    private JTextField tfDoctorAss;
    private JLabel occupation;
    private JTextField tfOccupation;
    private JLabel maritalStatus;
    private JTextField tfMaritalStatus;
    private JLabel religion;
    private JTextField tfReligion;
    private JLabel smokingHabit;
    private JTextField tfSmokingHabit;
    private JLabel emerContactName;
    private JTextField tfEmerContactName;
    private JLabel emerContactPhone;
    private JTextField tfEmerContactPhone;
    private JLabel emerRelationship;
    private JTextField tfEmerRelationship;
    
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnBack;
    
    private JLabel height;
    private JTextField tfHeight;
    private JLabel weight;
    private JTextField tfWeight;
    private JLabel bmi;
    private JLabel tfBMI;
    
    
    public PatientInfo(JFrame frame,JPanel previousPage){
        this.frame = frame;
        this.previousPage = previousPage;
        
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        RecordMaintenance rm = new RecordMaintenance(frame, previousPage);
        btnBack = rm.iconButton("Back", "/picture/backIcon.png");
        btnUpdate =rm.iconButton("Edit", "/picture/updateIcon.png");
        btnDelete = rm.iconButton("Delete", "/picture/deleteIcon.png");
        
        btnBack.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 btnBack.setFont(new Font("Serif", Font.PLAIN, 25));
                 frame.getContentPane().removeAll();
                 frame.add(previousPage);
                 frame.revalidate();
                 frame.repaint();
          }
           });
        
         btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               if (btnUpdate.getText().equals("Edit")) {
                    updateTextFieldState(tfIC, true);
                    updateTextFieldState(tfName, true);
                    updateTextFieldState(tfStudID, true);
                    updateTextFieldState(tfPhoneNum, true);
                    updateTextFieldState(tfBirthDate, true);
                    updateTextFieldState(tfAppDate, true);
                    updateTextFieldState(tfHeight, true);
                    updateTextFieldState(tfWeight, true);
                    updateTextFieldState(tfOccupation, true);
                    updateTextFieldState(tfMaritalStatus, true);
                    updateTextFieldState(tfReligion, true);
                    updateTextFieldState(tfSmokingHabit, true);
                    updateTextFieldState(tfEmerContactName, true);
                    updateTextFieldState(tfEmerContactPhone, true);
                    updateTextFieldState(tfEmerRelationship, true);

                    updateTextAreaState(tfAddress, true);
                    updateTextAreaState(tfAllergies, true);
                    updateTextAreaState(tfChronicDiseases, true);
                    updateTextAreaState(tfPastSurgeries, true);
                    updateTextAreaState(tfVacc, true);
                    updateTextAreaState(tfFamilyMedicalHis, true);
                    updateTextFieldState(tfDoctorAss, true);

                    tfBloodType.setEnabled(true);
                    maleBtn.setEnabled(true);
                    femaleBtn.setEnabled(true);

                    btnUpdate.setText("Save");
                    buttonPanel.setVisible(false);

                } else if (btnUpdate.getText().equals("Save")) {
                    updateTextFieldState(tfIC, false);
                    updateTextFieldState(tfName, false);
                    updateTextFieldState(tfStudID, false);
                    updateTextFieldState(tfPhoneNum, false);
                    updateTextFieldState(tfBirthDate, false);
                    updateTextFieldState(tfAppDate, false);
                    updateTextFieldState(tfHeight, false);
                    updateTextFieldState(tfWeight, false);
                    updateTextFieldState(tfOccupation, false);
                    updateTextFieldState(tfMaritalStatus, false);
                    updateTextFieldState(tfReligion, false);
                    updateTextFieldState(tfSmokingHabit, false);
                    updateTextFieldState(tfEmerContactName, false);
                    updateTextFieldState(tfEmerContactPhone, false);
                    updateTextFieldState(tfEmerRelationship, false);

                    updateTextAreaState(tfAddress, false);
                    updateTextAreaState(tfAllergies, false);
                    updateTextAreaState(tfChronicDiseases, false);
                    updateTextAreaState(tfPastSurgeries, false);
                    updateTextAreaState(tfVacc, false);
                    updateTextAreaState(tfFamilyMedicalHis, false);
                    updateTextFieldState(tfDoctorAss, false);

                    tfBloodType.setEnabled(false);
                    maleBtn.setEnabled(false);
                    femaleBtn.setEnabled(false);

                    btnUpdate.setText("Edit");
                    buttonPanel.setVisible(true);
                }
            }
        });
        
          btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dlt = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?", "Confirm Deletion",  JOptionPane.YES_NO_OPTION);
                if (dlt==JOptionPane.YES_OPTION){
                    
                }
            }
          });

        topPanel.add(btnBack);
        topPanel.add(btnUpdate);
        topPanel.add(btnDelete);

        add(topPanel,BorderLayout.NORTH);
        add(mainPanel(),BorderLayout.CENTER);
    }
    
    private JPanel mainPanel(){
        JPanel panel =new JPanel();
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),                
            BorderFactory.createEmptyBorder(20, 20, 20, 20)             
        ));
        
        buttonPanel = buttonPanel();
        panel.add(personalInfoModule(),BorderLayout.NORTH);
        panel.add(medicalInfoModule(),BorderLayout.CENTER);
        panel.add(buttonPanel,BorderLayout.SOUTH);
        return panel;
    }
    
    private JPanel personalInfoModule(){
        JPanel panel= new JPanel(new GridLayout(2,1,0,10));
        JPanel panelA = new JPanel(new GridLayout(0,8,0,5));
        panelA.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),                
            BorderFactory.createEmptyBorder(10, 10, 10, 10)             
        ));
        JPanel panelB = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        panelB.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),                
            BorderFactory.createEmptyBorder(10, 10, 10, 10)             
        ));
        
         IC = labelFormat("IC Number : ");
       tfIC=textFieldFormat(false,20);
       
       name = labelFormat("Name : ");
       tfName=textFieldFormat(false,20);
       
       studID = labelFormat("Student ID : ");
       tfStudID=textFieldFormat(false,20);
       
       gender = labelFormat("Gender : ");
       maleBtn = new JRadioButton("Male");
       femaleBtn = new JRadioButton("Female");
       JPanel genderPanel = new JPanel(new GridLayout(1, 2));
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        maleBtn.setSelected(true); 
        genderPanel.add(maleBtn);
        genderPanel.add(femaleBtn);
        maleBtn.setEnabled(false);
        femaleBtn.setEnabled(false);
        
       phoneNum = labelFormat("Phone Number : ");
       tfPhoneNum=textFieldFormat(false,20);
       
       birthDate = labelFormat("Date of Birth : ");
       tfBirthDate=textFieldFormat(false,20);
       
       bloodType = labelFormat("Blood Type : ");
       String[] bloodTypeOptions = {"A", "B", "AB", "O", "A-", "B-", "AB-", "O-"};
       tfBloodType = new JComboBox<>(bloodTypeOptions);
       tfBloodType.setFont(new Font("Serif", Font.PLAIN, 20));
       tfBloodType.setEnabled(false);
       
       address = labelFormat("Address : ");
       tfAddress = textAreaFormat(false);
       JScrollPane scrollAddress = scrollableTextArea(tfAddress, 100, 40);
       
        
       panelA.add(IC);
       panelA.add(tfIC);
       panelA.add(name);
       panelA.add(tfName);
       panelA.add(studID);
       panelA.add(tfStudID);
       panelA.add(gender);
       panelA.add(genderPanel);
       panelA.add(address);
       panelA.add(scrollAddress);
       panelA.add(phoneNum);
       panelA.add(tfPhoneNum);
       panelA.add(birthDate);
       panelA.add(tfBirthDate);
       panelA.add(bloodType);
       panelA.add(tfBloodType);
       
        
       height = labelFormat("Height : ");
       tfHeight=textFieldFormat(false,20);

       weight = labelFormat("Weight : ");
       tfWeight=textFieldFormat(false,20);
       
       bmi = labelFormat("BMI : ");
       tfBMI=labelFormat("");
       
       panelB.add(height);
       panelB.add(tfHeight);
       panelB.add(weight);
       panelB.add(tfWeight);
       panelB.add(bmi);
       panelB.add(tfBMI);
       
        panel.add(panelA,BorderLayout.NORTH);
        panel.add(panelB,BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel medicalInfoModule(){
        JPanel panel =new JPanel(new GridLayout(0,6,20,30));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),                
            BorderFactory.createEmptyBorder(20, 20, 30, 20)             
        ));
       
       allergies = labelFormat("Allergies : ");
       tfAllergies = textAreaFormat(false);
       JScrollPane scrollAllergies = scrollableTextArea(tfAllergies, 200, 60);

       chronicDiseases = labelFormat("Chronic Diseases : ");
       tfChronicDiseases = textAreaFormat(false);
       JScrollPane scrollChronicDiseases = scrollableTextArea(tfChronicDiseases, 200, 60);

       pastSurgeries = labelFormat("Past Surgeries : ");
       tfPastSurgeries = textAreaFormat(false);
       JScrollPane scrollPastSurgeries = scrollableTextArea(tfPastSurgeries, 200, 60);
       
       vacc = labelFormat("Vaccination History : ");
       tfVacc = textAreaFormat(false);
       JScrollPane scrollVacc = scrollableTextArea(tfVacc, 200, 60);
       
       familyMedicalHis = labelFormat("Family Medical History : ");
       tfFamilyMedicalHis = textAreaFormat(false);
       JScrollPane scrollFamilyMedicalHis = scrollableTextArea(tfFamilyMedicalHis, 200, 60);
       
       appDate = labelFormat("Appointment Date : ");
       tfAppDate=textFieldFormat(false,20);
       
       doctorAss = labelFormat("Doctor Assigned : ");
       tfDoctorAss=textFieldFormat(false,20);
       
       occupation = labelFormat("Occupation : ");
       tfOccupation=textFieldFormat(false,20);
       
       maritalStatus = labelFormat("Marital Status : ");
       tfMaritalStatus=textFieldFormat(false,20);
       
       religion = labelFormat("Religion : ");
       tfReligion=textFieldFormat(false,20);
       
       smokingHabit = labelFormat("Smoking Habit : ");
       tfSmokingHabit=textFieldFormat(false,20);
       
       emerContactName = labelFormat("Emergency Contact Name : ");
       tfEmerContactName=textFieldFormat(false,20);
       
       emerContactPhone = labelFormat("Emergency Contact Phone : ");
       tfEmerContactPhone=textFieldFormat(false,20);
       
       emerRelationship = labelFormat("Emergency Relationship : ");
       tfEmerRelationship=textFieldFormat(false,20);
       
       panel.add(allergies);
       panel.add(scrollAllergies);
       panel.add(chronicDiseases);
       panel.add(scrollChronicDiseases);
       panel.add(new JLabel(""));
       panel.add(new JLabel(""));
       panel.add(pastSurgeries);
       panel.add(scrollPastSurgeries);
       panel.add(vacc);
       panel.add(scrollVacc);
       panel.add(familyMedicalHis);
       panel.add(scrollFamilyMedicalHis);
       panel.add(appDate);
       panel.add(tfAppDate);
       panel.add(doctorAss);
       panel.add(tfDoctorAss);
       panel.add(new JLabel(""));
       panel.add(new JLabel(""));
       panel.add(occupation);
       panel.add(tfOccupation);
       panel.add(maritalStatus);
       panel.add(tfMaritalStatus);
       panel.add(religion);
       panel.add(tfReligion);
       panel.add(smokingHabit);
       panel.add(tfSmokingHabit);
       panel.add(new JLabel(""));
       panel.add(new JLabel(""));
       panel.add(new JLabel(""));
       panel.add(new JLabel(""));
       panel.add(emerContactName);
       panel.add(tfEmerContactName);
       panel.add(emerContactPhone);
       panel.add(tfEmerContactPhone);
       panel.add(emerRelationship);
       panel.add(tfEmerRelationship);
        
        return panel;
    }
    
    private JPanel buttonPanel(){
        JPanel btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); 
        JButton btnWalkin = buttonFormat("Walk-in");
        JButton btnAppointment = buttonFormat("Appointment");
        
        btn.add(btnWalkin);
        btn.add(btnAppointment);
        
        btnWalkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
            }
        });
        
          btnAppointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
          });
          
            btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(previousPage);
                frame.revalidate();
                frame.repaint();
         }
          });
                
                
                return btn;
    }
    
      private JLabel labelFormat(String text) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("Serif", Font.PLAIN, 25));
    label.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0)); 
    return label;
}
    
    private JTextField textFieldFormat(boolean editable,int size) {
    JTextField tf = new JTextField(size);
    tf.setFont(new Font("Serif", Font.PLAIN, 15));
    tf.setBorder(BorderFactory.createCompoundBorder(
        tf.getBorder(),                          
        BorderFactory.createEmptyBorder(3, 5, 3, 5) 
    ));
    tf.setEditable(editable);   
    
    return tf;
}
    
    private JButton buttonFormat(String text) {
    JButton button = new JButton(text);
    button.setPreferredSize(new Dimension(200, 50));
    button.setFont(new Font("Serif", Font.BOLD, 16));
    button.setFocusPainted(false); 
    return button;
}
    
    private JTextArea textAreaFormat(boolean editable) {
    JTextArea ta = new JTextArea(2, 20); 
    ta.setLineWrap(true);
    ta.setWrapStyleWord(true);
    ta.setFont(new Font("Serif", Font.PLAIN, 18));
    ta.setEditable(editable);
    if (!editable) {
        ta.setBackground(UIManager.getColor("TextField.inactiveBackground")); 
        ta.setForeground(Color.DARK_GRAY); 
    }
    
    return ta;
}
    
    private JScrollPane scrollableTextArea(JTextArea textArea, int width, int height) {
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(width, height));
    return scrollPane;
}
   
    private void updateTextFieldState(JTextField tf, boolean editable) {
    tf.setEditable(editable);
    if (!editable) {
        tf.setBackground(UIManager.getColor("TextField.inactiveBackground"));
        tf.setForeground(Color.DARK_GRAY);
    } else {
        tf.setBackground(Color.WHITE);
        tf.setForeground(Color.BLACK);
    }
}
    
    private void updateTextAreaState(JTextArea ta, boolean editable) {
    ta.setEditable(editable);
    if (!editable) {
        ta.setBackground(UIManager.getColor("TextField.inactiveBackground"));
        ta.setForeground(Color.DARK_GRAY);
    } else {
        ta.setBackground(Color.WHITE);
        ta.setForeground(Color.BLACK);
    }
}
    
    public static void main(String[] args){
        JFrame frame=new JFrame();
        JPanel previousPage = new JPanel();
        JPanel patientInfo = new PatientInfo(frame,previousPage);
        frame.add(patientInfo);
        frame.setVisible(true);
    }
}
