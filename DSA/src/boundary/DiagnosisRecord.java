package boundary;


import entity.Patient;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DiagnosisRecord extends JPanel{
    private JFrame frame;
    private JPanel previousPage;
    private JPanel buttonPanel;
    private Patient patient;
    private boolean isNew;
    final int MAX_MEDICINES = 5;
    final int[] medicineCount = {1}; 
    
    private DefaultTableModel medicineModel;
    private JTable medicineTable;
    
    
    private JLabel pressureLabel;
    private JLabel heartLabel;
    private JLabel temperatureLabel;
    private JLabel labelDiagnosis;
    private JLabel labelPatientStatus;
    private JLabel treatmentID;
    
    private JTextField othersFields = new JTextField(20);
    
    
    String[] patientStatuses = {
    "Under Observation",
    "Stable",
    "Critical",
    "In Surgery",
    "Recovering"
};
    
    JButton submitBtn;
    private JLabel patientName;
    private JLabel doctorName;

    
    private JButton btnBack;
   
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
    
    
    public DiagnosisRecord(JFrame frame,JPanel previousPage,Patient patient,boolean isNew){
        this.frame = frame;
        this.previousPage = previousPage;
        this.patient=patient;
        this.isNew=isNew;
        
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        RecordMaintenance rm = new RecordMaintenance(frame, previousPage);
        btnBack = rm.iconButton("Back", "/picture/backIcon.png");
ImageIcon icon = new ImageIcon(getClass().getResource("/picture/submit.png"));
Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
submitBtn = new JButton("", new ImageIcon(img));
submitBtn.setBackground(new Color(0,0,0,0));
submitBtn.setFont(new Font("Serif", Font.PLAIN, 25));
submitBtn.setBorderPainted(false);
submitBtn.setContentAreaFilled(false);
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
        
         
           treatmentID=labelFormat("Treatment ID: T202507260001");
treatmentID.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(btnBack,BorderLayout.WEST  );
        topPanel.add(treatmentID,BorderLayout.CENTER);
        topPanel.add(submitBtn,BorderLayout.EAST);
          
        add(topPanel,BorderLayout.NORTH);
        add(mainPanel(),BorderLayout.CENTER);
    }
    
    private JPanel mainPanel(){
        JPanel panel =new JPanel();
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),                
            BorderFactory.createEmptyBorder(20, 20, 20, 20)             
        ));
        
        panel.add(personalInfoModule(),BorderLayout.NORTH);
        panel.add(medicalInfoModule(),BorderLayout.CENTER);
        panel.add(createMedicineTablePanel(),BorderLayout.SOUTH);
        
        
        
        return panel;
    }
    
    private JPanel personalInfoModule(){
        JPanel panel= new JPanel(new GridLayout(2,1,0,10));
        JPanel panelA = new JPanel(new BorderLayout());
        panelA.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),                
            BorderFactory.createEmptyBorder(10, 10, 10, 10)             
        ));
        JPanel panelB = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        panelB.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),                
            BorderFactory.createEmptyBorder(10, 10, 10, 10)             
        ));
        
         patientName = labelFormat("Patient : "+ "kelly chua phei erl");
       
       doctorName = labelFormat("Doctor : "+ "tifany Chua Li Fang");
        
       LocalDate today = LocalDate.now();
        JLabel labelDate = labelFormat("Date: " + today.toString());
 
       
        
       panelA.add(patientName,BorderLayout.CENTER);
       panelA.add(doctorName,BorderLayout.WEST);
       patientName.setHorizontalAlignment(SwingConstants.CENTER);

       panelA.add(labelDate,BorderLayout.EAST);
       panelA.setPreferredSize(new Dimension(1900,100));
               JPanel symptomsForm=new JPanel(new BorderLayout());

       JLabel labelSymptoms = new JLabel("Symptoms:");
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
Font checkboxFont = new Font("SansSerif", Font.PLAIN, 20);

for (Component comp : symptomPanel.getComponents()) {
    if (comp instanceof JCheckBox) {
        comp.setFont(checkboxFont);
    }
}

symptomsForm.add(symptomPanel);
       
       panelB.add(labelSymptoms);
       panelB.add(symptomsForm);
       labelSymptoms.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 40));
       
        panel.add(panelA,BorderLayout.NORTH);
        panel.add(panelB,BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel medicalInfoModule(){
        JPanel panel =new JPanel(new GridLayout(0,3,20,50));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),                
            BorderFactory.createEmptyBorder(20, 20, 20, 20)             
        ));
       
      
       JPanel pressurePanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
JPanel pressureField=new JPanel(new FlowLayout(FlowLayout.CENTER));
JSpinner spnPressure = new JSpinner(new SpinnerNumberModel(120, 0, 300, 1));
JSpinner spnPressure2 = new JSpinner(new SpinnerNumberModel(80, 0, 300, 1));
        spnPressure.setPreferredSize(new Dimension(150, 60));
        spnPressure2.setPreferredSize(new Dimension(150, 60));


JComponent editor = spnPressure.getEditor();
JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();

pressureLabel = labelFormat("Blood Pressure (mmHg) : ");
textField.setFont(new Font("SansSerif", Font.PLAIN, 18));
textField.setHorizontalAlignment(JTextField.CENTER);
textField.setOpaque(false);        

JComponent editorDiastolic = spnPressure2.getEditor();
JFormattedTextField textFieldDiastolic = ((JSpinner.DefaultEditor) editorDiastolic).getTextField();
textFieldDiastolic.setFont(new Font("SansSerif", Font.PLAIN, 18));
textFieldDiastolic.setHorizontalAlignment(JTextField.CENTER);
textFieldDiastolic.setOpaque(false); 
pressurePanel.add(pressureLabel);
pressurePanel.add(spnPressure);
pressurePanel.add(spnPressure2);
pressurePanel.add(pressureField);
       
textFieldDiastolic.setForeground(Color.GREEN);
textField.setForeground(Color.GREEN);

spnPressure.addChangeListener(e -> {
    int value = (int) spnPressure.getValue();
    if (value < 90 || value > 140) {
        textField.setForeground(Color.RED);
    } else {
        textField.setForeground(Color.GREEN);
    }
});

spnPressure2.addChangeListener(e -> {
    int value = (int) spnPressure2.getValue();
    if (value < 60|| value >90) {
        textFieldDiastolic.setForeground(Color.RED);
    } else {
        textFieldDiastolic.setForeground(Color.GREEN);
    }
});


       heartLabel = labelFormat("Heart Rate (bpm):");
       JPanel heartPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));

       JSpinner spnHeartRate = new JSpinner(new SpinnerNumberModel(80, 0, 300, 1));
spnHeartRate.setPreferredSize(new Dimension(250, 60));

JComponent editorRate = spnHeartRate.getEditor();
JFormattedTextField textFieldRate = ((JSpinner.DefaultEditor) editorRate).getTextField();
textFieldRate.setFont(new Font("SansSerif", Font.PLAIN, 18));
textFieldRate.setHorizontalAlignment(JTextField.CENTER);
textFieldRate.setOpaque(false); 

textFieldRate.setForeground(Color.GREEN);

spnHeartRate.addChangeListener(e -> {
    int value = (int) spnHeartRate.getValue();
    if (value < 60 || value > 100) {
        textFieldRate.setForeground(Color.RED);
    } else {
        textFieldRate.setForeground(Color.GREEN);
    }
});
heartPanel.add(heartLabel);
heartPanel.add(spnHeartRate);

//temperature panel
       temperatureLabel = labelFormat("Temperature (°C):");
JPanel temperaturePanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
JSpinner spnTemperature = new JSpinner(new SpinnerNumberModel(37.5, 0, 300, 1));
spnTemperature.setPreferredSize(new Dimension(250,60));
JComponent editorTemp = spnTemperature.getEditor();
JFormattedTextField textFieldTemp = ((JSpinner.DefaultEditor) editorTemp).getTextField();
textFieldTemp.setFont(new Font("SansSerif", Font.PLAIN, 18));
textFieldTemp.setHorizontalAlignment(JTextField.CENTER);
textFieldTemp.setOpaque(false); 
temperaturePanel.add(temperatureLabel);
temperaturePanel.add(spnTemperature);
textFieldTemp.setForeground(Color.GREEN);

spnTemperature.addChangeListener(e -> {
    int value = (int) spnHeartRate.getValue();
    if (value < 36.0 || value > 38.0) {
        textFieldTemp.setForeground(Color.RED);
    } else {
        textFieldTemp.setForeground(Color.GREEN);
    }
});       


// Diagnosis panel
JPanel diagnosisPanel=new JPanel(new BorderLayout());
    JPanel layoutDesign=new JPanel(new GridLayout(0,2));
       labelDiagnosis = labelFormat("Diagnosis:");
       layoutDesign.add(labelDiagnosis);
       JComboBox<String> diagnosisComboBox = new JComboBox<>(diagnoses);
        diagnosisComboBox.setPreferredSize(new Dimension(250, 30));
        diagnosisComboBox.setFont(new Font("SansSerif", Font.PLAIN, 20));
        JPanel comboBoxWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        comboBoxWrapper.add(diagnosisComboBox);
        layoutDesign.add(comboBoxWrapper);
        labelDiagnosis.setHorizontalAlignment(SwingConstants.RIGHT);
        labelDiagnosis.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 35));
        
        
JLabel additionLabel = labelFormat("Please specify the diagnosis:");
additionLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
additionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
 additionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 35));
layoutDesign.add(additionLabel);        JPanel otherPanel=new JPanel();
        otherPanel.add(othersFields);
        othersFields.setFont(new Font("SansSerif", Font.PLAIN, 18));

        layoutDesign.add(otherPanel,BorderLayout.SOUTH);
        diagnosisPanel.add(layoutDesign);
         otherPanel.setVisible(false);
         additionLabel.setVisible(false);
 //listener for diagnosis        
         class DiagnosisListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String selected = (String) diagnosisComboBox.getSelectedItem();
        if ("Others".equals(selected)) {
            otherPanel.setVisible(true);
            additionLabel.setVisible(true);
        } else {
            otherPanel.setVisible(false);
            additionLabel.setVisible(false);
        }
        diagnosisPanel.revalidate();
        diagnosisPanel.repaint();
    }
    }
         
        diagnosisComboBox.addActionListener(new DiagnosisListener());
         
         
         
      //patient status panel   
      JPanel statusPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
       labelPatientStatus = labelFormat("Patient Status:");
       JComboBox<String> statusDropdown = new JComboBox<>(patientStatuses);
       statusDropdown.setPreferredSize(new Dimension(250,50));
       statusDropdown.setFont(new Font("SansSerif", Font.PLAIN, 18));
       statusPanel.add(labelPatientStatus);
       statusPanel.add(statusDropdown);
        labelPatientStatus.setBorder(BorderFactory.createEmptyBorder(0, 45, 0, 0));
       
        
        JPanel followUpPanel=new JPanel();
         JLabel labelFollowUp;
        labelFollowUp = labelFormat("Follow-up Required:");
        followUpPanel.add(labelFollowUp);
        labelFollowUp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 16));
        ButtonGroup followButton = new ButtonGroup();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
        JRadioButton yesBtn = new JRadioButton("Yes");
        JRadioButton noBtn = new JRadioButton("No");
        followButton.add(yesBtn);
        followButton.add(noBtn);
        buttonPanel.add(yesBtn);
        buttonPanel.add(noBtn);

        Font rbFont = new Font("SansSerif", Font.PLAIN, 24);
        yesBtn.setFont(rbFont);
        noBtn.setFont(rbFont);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 35));
        followUpPanel.add(buttonPanel);
     
//medicine Panel
    
       panel.add(pressurePanel);
       panel.add(heartPanel);
       panel.add(temperaturePanel);
       panel.add(diagnosisPanel);
       panel.add(statusPanel);
       panel.add(followUpPanel);

        return panel;
    }
    
    private JPanel createMedicineTablePanel() {
    String[] columnNames = {"Medicine Name", "Quantity"};
    Object[][] data = {}; 

    JLabel medicineLabel = labelFormat("Medicines ");
    medicineLabel.setHorizontalAlignment(SwingConstants.LEFT);

    medicineModel = new DefaultTableModel(data, columnNames);
    medicineTable = new JTable(medicineModel);
    medicineTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 22));
    medicineTable.setFont(new Font("SansSerif", Font.PLAIN, 18));
    medicineTable.setRowHeight(30);

    JScrollPane scrollPane = new JScrollPane(medicineTable);
    scrollPane.setPreferredSize(new Dimension(600, 250));

    JLabel emptyLabel = new JLabel("No medicines added", SwingConstants.CENTER);
    emptyLabel.setFont(new Font("SansSerif", Font.ITALIC, 18));
    emptyLabel.setForeground(Color.GRAY);
    emptyLabel.setVisible(true); // Initially visible

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(600, 250));
    scrollPane.setBounds(0, 0, 600, 250);
    emptyLabel.setBounds(0, 100, 600, 30); // Centered overlay
    layeredPane.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
    layeredPane.add(emptyLabel, JLayeredPane.PALETTE_LAYER);

    JPanel medicinePanel = new JPanel();
    medicinePanel.add(layeredPane);

    JPanel panelMedical = new JPanel(new BorderLayout());
    panelMedical.add(medicineLabel, BorderLayout.NORTH);

    JPanel addMedicinePanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    JButton addButton = new JButton("+ Medicines");
    addButton.setPreferredSize(new Dimension(150, 50));
    addButton.setFont(new Font("SansSerif", Font.BOLD, 20));
    addButton.setForeground(Color.WHITE);
    addButton.setBackground(new Color(76, 175, 80));
    addMedicinePanel.add(addButton);

    addButton.addActionListener(e -> {
    // Create input fields
    JTextField medicineField = new JTextField(15);
    JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    quantitySpinner.setPreferredSize(new Dimension(60, 25));

    // Create a panel with both inputs
    JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    inputPanel.add(new JLabel("Medicine Name:"));
    inputPanel.add(medicineField);
    inputPanel.add(new JLabel("Quantity:"));
    inputPanel.add(quantitySpinner);

    // Show the message dialog with inputs
    int result = JOptionPane.showConfirmDialog(
        null,
        inputPanel,
        "Add Medicine",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE
    );

    // Process input if OK clicked
    if (result == JOptionPane.OK_OPTION) {
        String medicineName = medicineField.getText().trim();
        int quantity = (int) quantitySpinner.getValue();

        if (medicineName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a medicine name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add to table
        medicineModel.addRow(new Object[]{medicineName, quantity});
        emptyLabel.setVisible(false); // Hide the 'no medicines' label
    }
});
    
    medicineTable.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int selectedRow = medicineTable.rowAtPoint(e.getPoint());
        if (selectedRow >= 0) {
            String medicineName = medicineModel.getValueAt(selectedRow, 0).toString();
            int quantity = (int) medicineModel.getValueAt(selectedRow, 1);

            int result = JOptionPane.showConfirmDialog(
                null,
                "Delete \"" + medicineName + " x " + quantity + "\"?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                // Remove from table
                medicineModel.removeRow(selectedRow);

                /*for (int i = 0; i < medicineList.size(); i++) {
                    if (medicineList.get(i).name.equals(medicineName) &&
                        medicineList.get(i).quantity == quantity) {
                        medicineList.remove(i);
                        break;
                    }
                }*/

                // Show empty label if list is empty
                emptyLabel.setVisible(medicineModel.getRowCount() == 0);
            }
        }
    }
});


    emptyLabel.setVisible(medicineModel.getRowCount() == 0);

    JPanel tablePanel = new JPanel(new GridLayout(1, 3, 20, 20));
    tablePanel.add(panelMedical);
    tablePanel.add(medicinePanel);
    tablePanel.add(addMedicinePanel);

    tablePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
    ));
    medicinePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    addMedicinePanel.setBorder(BorderFactory.createEmptyBorder(200, 0, 0, 0));

    return tablePanel;
}


    
      private JLabel labelFormat(String text) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("Serif", Font.PLAIN, 25));
    label.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0)); 
    return label;
}
    

    public static void main(String[] args){
        JFrame frame=new JFrame();
        JPanel previousPage = new JPanel();
        Patient patient = new Patient();
        boolean isNew=true;
        JPanel diagnosisRecord = new DiagnosisRecord(frame,previousPage,patient,isNew);
        frame.add(diagnosisRecord);
        frame.setVisible(true);
    }
}
