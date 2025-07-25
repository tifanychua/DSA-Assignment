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


public class TreatmentRecordDetails extends JFrame {
final int MAX_MEDICINES = 5;
final int[] medicineCount = {1};


    private JButton jbtBack = new JButton("Back");
    private JButton jbtEdit = new JButton("Edit");
    private JButton jbtDel = new JButton("Delete");
    private JTextField jtfPatientName = new JTextField(20);
    private JTextField jtfTreatment = new JTextField();
    private JTextField jtfNote = new JTextField();
    private JTextField jtfPatient = new JTextField();
    private JButton jbtAdd = new JButton("Back");
    private JButton jbtDelete = new JButton("Submit");
    private JLabel topLabel = new JLabel("Patient Diagnosis Details");
    private JTextField othersFields = new JTextField(20);
    private JLabel pressureLabel=new JLabel("Blood Pressure (mmHg):");
    private JLabel heartRateLabel=new JLabel("Heart Rate (bpm)");
    private JLabel temperatureLabel=new JLabel("Temperature (°C)");
     String[] diagnoses = {
        "Common Cold",
        "Influenza (Flu)",
        "COVID-19",
        "Gastroenteritis",
        "Migraine",
        "Hypertension",
        "Diabetes",
        "Asthma",
        "Allergic Rhinitis",
        "Urinary Tract Infection (UTI)",
        "Skin Rash / Dermatitis",
        "Back Pain",
        "Anxiety / Stress",
        "Food Poisoning",
        "Others"
    };
    
    String[] patientStatuses = {
    "Under Observation",
    "Stable",
    "Critical",
    "In Surgery",
    "Recovering"
};
    
    String[] medicineList = {
    "medicine1",
    "medicine2",
    "medicine3",
    "medicine4",
    "medicine5"
};
    String[] quantityList= {
    "1",
    "2",
    "3",
    "4",
    "5"
};
    public TreatmentRecordDetails() {
        
         JPanel jpTop = new JPanel();
        topLabel.setFont(new Font("SansSerif", Font.BOLD, 56));
        jpTop.add(topLabel, BorderLayout.CENTER);

        // Info Panel
        JPanel jpInfo = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 5));
        JLabel labelTreatmentID = new JLabel("Treatment ID: 2507191001");
        labelTreatmentID.setFont(new Font("SansSerif", Font.PLAIN, 32));
        jpInfo.add(labelTreatmentID);
                        labelTreatmentID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 1000));

        LocalDate today = LocalDate.now();
        JLabel labelDate = new JLabel("Date: " + today.toString());
        labelDate.setFont(new Font("SansSerif", Font.PLAIN, 32));
        jpInfo.add(labelDate);

        JPanel jpCenter = new JPanel(new GridLayout(0, 1, 0, 20)); 

        JLabel labelPatient = new JLabel("Patient");
        labelPatient.setFont(new Font("SansSerif", Font.BOLD, 28));
        jpCenter.add(labelPatient);
        jpCenter.add(jtfPatientName);
        JPanel symptomsForm=new JPanel(new BorderLayout());
        JLabel labelSymptoms = new JLabel("Symptoms");
        labelSymptoms.setFont(new Font("SansSerif", Font.BOLD, 28));
        symptomsForm.add(labelSymptoms);

        JPanel symptomPanel = new JPanel(new GridLayout(3, 0,0,1));
        symptomPanel.add(new JCheckBox("Fever"));
        symptomPanel.add(new JCheckBox("Tiredness"));
        symptomPanel.add(new JCheckBox("Night Sweats"));
        symptomPanel.add(new JCheckBox("Weight Loss"));
        symptomPanel.add(new JCheckBox("Cough"));
        symptomPanel.add(new JCheckBox("Sore Throat"));
        symptomPanel.add(new JCheckBox("Chest Pain"));
        symptomPanel.add(new JCheckBox("Vomiting"));
        symptomPanel.add(new JCheckBox("Diarrhea"));
        symptomPanel.add(new JCheckBox("Constipation"));
        symptomPanel.add(new JCheckBox("Heartburn"));
        symptomPanel.add(new JCheckBox("Headache"));
        symptomPanel.add(new JCheckBox("Dizziness"));
        symptomPanel.add(new JCheckBox("Numbness"));
        symptomPanel.add(new JCheckBox("Joint Pain "));
        symptomPanel.add(new JCheckBox("Back Pain"));
        symptomPanel.add(new JCheckBox("Rash"));
        symptomPanel.add(new JCheckBox("Itching"));
        symptomPanel.add(new JCheckBox("Wounds"));
        symptomPanel.add(new JCheckBox("Chest Pressure"));
        symptomPanel.add(new JCheckBox("Palpitations"));
        symptomPanel.add(new JCheckBox("Swollen"));
        symptomPanel.add(new JCheckBox("Blood in Urine"));

        JScrollPane scrollPane = new JScrollPane(symptomPanel);
scrollPane.setPreferredSize(new Dimension(800, 1000));        
symptomsForm.add(symptomPanel);
jpCenter.add(labelSymptoms);
jpCenter.add(symptomsForm);
        othersFields.setFont(new Font("SansSerif", Font.PLAIN, 20));
        othersFields.setVisible(false);
        JLabel labelDiagnosis = new JLabel("Diagnosis");
        labelDiagnosis.setFont(new Font("SansSerif", Font.BOLD, 28));
        jpCenter.add(labelDiagnosis);
        
        JComboBox<String> diagnosisComboBox = new JComboBox<>(diagnoses);
        diagnosisComboBox.setPreferredSize(new Dimension(250, 30));
        diagnosisComboBox.setFont(new Font("SansSerif", Font.PLAIN, 20));
        
        JPanel diagnosisPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        diagnosisPanel.add(diagnosisComboBox);
        diagnosisPanel.add(othersFields);
        jpCenter.add(diagnosisPanel);

       

        JLabel labelPatientStatus = new JLabel("Patient Status");
        labelPatientStatus.setFont(new Font("SansSerif", Font.BOLD, 28));
        jpCenter.add(labelPatientStatus);
        JComboBox<String> statusDropdown = new JComboBox<>(patientStatuses);
statusDropdown.setFont(new Font("SansSerif", Font.PLAIN, 18));
jpCenter.add(statusDropdown);

        JLabel labelFollowUp = new JLabel("Follow-up Required");
        labelFollowUp.setFont(new Font("SansSerif", Font.BOLD, 28));
        jpCenter.add(labelFollowUp);

        ButtonGroup followButton = new ButtonGroup();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
        JRadioButton yesBtn = new JRadioButton("Yes");
        JRadioButton noBtn = new JRadioButton("No");
        followButton.add(yesBtn);
        followButton.add(noBtn);
        buttonPanel.add(yesBtn);
        buttonPanel.add(noBtn);

        Font rbFont = new Font("SansSerif", Font.BOLD, 28);
        yesBtn.setFont(rbFont);
        noBtn.setFont(rbFont);
        jpCenter.add(buttonPanel);

        jbtAdd.setPreferredSize(new Dimension(150, 50));
        jbtDelete.setPreferredSize(new Dimension(150, 50));

        JPanel medicalPanel=new JPanel(new GridLayout(0,2));
        JPanel treatmentPanel=new JPanel(new GridLayout(5,1,0,20));
       


JLabel doctorLabel=new JLabel("Doctor: ");
doctorLabel.setPreferredSize(new Dimension(50, 40)); 
doctorLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
treatmentPanel.add(doctorLabel);


JPanel pressurePanel=new JPanel(new GridLayout(1,2));
JPanel pressureField=new JPanel(new FlowLayout());
JSpinner spnPressure = new JSpinner(new SpinnerNumberModel(120, 0, 300, 1));
JSpinner spnPressure2 = new JSpinner(new SpinnerNumberModel(80, 0, 300, 1));
        spnPressure.setPreferredSize(new Dimension(230, 50));
        spnPressure2.setPreferredSize(new Dimension(230, 50));


JComponent editor = spnPressure.getEditor();
JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();

textField.setFont(new Font("SansSerif", Font.PLAIN, 18));
textField.setHorizontalAlignment(JTextField.CENTER);
textField.setOpaque(false);        
pressurePanel.add(pressureLabel);
pressureLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
pressureField.add(spnPressure);

JComponent editorDiastolic = spnPressure2.getEditor();
JFormattedTextField textFieldDiastolic = ((JSpinner.DefaultEditor) editorDiastolic).getTextField();
textFieldDiastolic.setFont(new Font("SansSerif", Font.PLAIN, 18));
textFieldDiastolic.setHorizontalAlignment(JTextField.CENTER);
textFieldDiastolic.setOpaque(false); 
pressureField.add(spnPressure2);
pressurePanel.add(pressureField);
treatmentPanel.add(pressurePanel);
temperatureLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
textFieldDiastolic.setForeground(Color.GREEN);

spnPressure2.addChangeListener(e -> {
    int value = (int) spnPressure2.getValue();
    if (value < 60|| value >90) {
        textFieldDiastolic.setForeground(Color.RED);
    } else {
        textFieldDiastolic.setForeground(Color.GREEN);
    }
});

textField.setForeground(Color.GREEN);

spnPressure.addChangeListener(e -> {
    int value = (int) spnPressure.getValue();
    if (value < 90 || value > 140) {
        textField.setForeground(Color.RED);
    } else {
        textField.setForeground(Color.GREEN);
    }
});

JPanel heartPanel=new JPanel(new GridLayout(1,2));
JSpinner spnHeartRate = new JSpinner(new SpinnerNumberModel(80, 0, 300, 1));
spnHeartRate.setPreferredSize(new Dimension(60, 35));
JComponent editorRate = spnHeartRate.getEditor();
JFormattedTextField textFieldRate = ((JSpinner.DefaultEditor) editorRate).getTextField();
textFieldRate.setFont(new Font("SansSerif", Font.PLAIN, 18));
textFieldRate.setHorizontalAlignment(JTextField.CENTER);
textFieldRate.setOpaque(false); 
heartPanel.add(heartRateLabel);
heartPanel.add(spnHeartRate);
treatmentPanel.add(heartPanel);
heartRateLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
textFieldRate.setForeground(Color.GREEN);

spnHeartRate.addChangeListener(e -> {
    int value = (int) spnHeartRate.getValue();
    if (value < 60 || value > 100) {
        textFieldRate.setForeground(Color.RED);
    } else {
        textFieldRate.setForeground(Color.GREEN);
    }
});

JPanel temperaturePanel=new JPanel(new GridLayout(1,2));
JSpinner spnTemperature = new JSpinner(new SpinnerNumberModel(37.5, 0, 300, 1));
spnTemperature.setPreferredSize(new Dimension(60, 35));
JComponent editorTemp = spnTemperature.getEditor();
JFormattedTextField textFieldTemp = ((JSpinner.DefaultEditor) editorTemp).getTextField();
textFieldTemp.setFont(new Font("SansSerif", Font.PLAIN, 18));
textFieldTemp.setHorizontalAlignment(JTextField.CENTER);
textFieldTemp.setOpaque(false);     
temperaturePanel.add(temperatureLabel);
temperaturePanel.add(spnTemperature);
treatmentPanel.add(temperaturePanel);
temperatureLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
textFieldTemp.setForeground(Color.GREEN);

spnTemperature.addChangeListener(e -> {
    int value = (int) spnHeartRate.getValue();
    if (value < 36.0 || value > 38.0) {
        textFieldTemp.setForeground(Color.RED);
    } else {
        textFieldTemp.setForeground(Color.GREEN);
    }
});


        add(jpInfo, BorderLayout.BEFORE_FIRST_LINE);
        medicalPanel.add(jpCenter);
        jpInfo.add(jpTop);

        jpTop.setBorder(BorderFactory.createEmptyBorder(20, 500, 50, 0));
        jpInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jpCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 30, 0));
        treatmentPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 0));

JPanel medicinePanel = new JPanel(new GridLayout(0, 2));

JButton addMedicineButton = new JButton("Add Medicine");

JPanel buttonPanel1 = new JPanel();
buttonPanel1.add(addMedicineButton);

JPanel medicineContainer = new JPanel();

medicineContainer.add(medicinePanel); 
medicineContainer.add(buttonPanel1);      
Runnable addMedicineRow = () -> {
      if (medicineCount[0] >= MAX_MEDICINES) {
        JOptionPane.showMessageDialog(null, "You can only add up to 4 medicines.");
        return;
    }
    JComboBox<String> medicineComboBox = new JComboBox<>(medicineList);
        medicineComboBox.setPreferredSize(new Dimension(200, 50));
        medicineComboBox.setFont(new Font("SansSerif", Font.PLAIN, 20));
        JComboBox<String> quantityComboBox = new JComboBox<>(quantityList);
        quantityComboBox.setPreferredSize(new Dimension(200, 50));
        quantityComboBox.setFont(new Font("SansSerif", Font.PLAIN, 20));
    medicineComboBox.setBorder(BorderFactory.createTitledBorder("Medicine"));
    quantityComboBox.setBorder(BorderFactory.createTitledBorder("Quantity(pieces)"));

    medicinePanel.add(medicineComboBox);
    medicinePanel.add(quantityComboBox);

    medicinePanel.revalidate();
    medicinePanel.repaint();
        medicineCount[0]++;

};

addMedicineRow.run();

addMedicineButton.addActionListener(e -> addMedicineRow.run());

JPanel eastPanel = new JPanel(new BorderLayout());
JPanel medicineSection = new JPanel(new FlowLayout());
JLabel medicineLabel=new JLabel("Medicines");
treatmentPanel.add(medicineLabel);
medicineLabel.setFont(new Font("SansSerif", Font.BOLD, 28));

medicineSection.add(medicineContainer);

eastPanel.add(treatmentPanel, BorderLayout.NORTH);
eastPanel.add(medicineSection);

medicalPanel.add(eastPanel);
        add(medicalPanel);





        
         class DiagnosisListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String selected = (String) diagnosisComboBox.getSelectedItem();
        if ("Others".equals(selected)) {
            othersFields.setVisible(true);
        } else {
            othersFields.setVisible(false);
        }
        diagnosisPanel.revalidate();
        diagnosisPanel.repaint();
    }
    }
         
        diagnosisComboBox.addActionListener(new DiagnosisListener());
      
        JPanel jpSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
        jpSouth.add(jbtBack);
        jpSouth.add(jbtEdit);
        jpSouth.add(jbtDel);
        Dimension buttonSize = new Dimension(150, 50);
        jpSouth.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
jbtBack.setPreferredSize(buttonSize);
jbtEdit.setPreferredSize(buttonSize);
jbtDel.setPreferredSize(buttonSize);
add(jpSouth, BorderLayout.SOUTH);
    }
    
    
    public static void main(String[] args) {
          TreatmentRecordDetails frm=new TreatmentRecordDetails();   
          frm.setTitle("Treatment Details");
          frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frm.setLocationRelativeTo(null);
          frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frm.setVisible(true);
    }
}
