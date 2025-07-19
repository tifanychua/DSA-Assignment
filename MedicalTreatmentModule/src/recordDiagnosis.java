import java.awt.*;
import java.awt.event.*;
import javax.swing.*;^

// UI(view) -> control -> DA(model) -> Domain

public class recordDiagnosis extends JFrame {

    private JTextField jtfTreatID = new JTextField(9);
    private JTextField jtfPatientName = new JTextField(20);
    private JTextField jtfDate = new JTextField(9);
    private JTextField jtfDoctor = new JTextField(9);
    private JTextField jtfDiagnosis = new JTextField();
    private JTextField jtfTreatment = new JTextField();
    private JTextField jtfNote = new JTextField();
    private JTextField jtfPatient = new JTextField();
    private JTextField jtfFollowUp = new JTextField();
    private JButton jbtAdd = new JButton("Back");
    private JButton jbtDelete = new JButton("Submit");
    private JLabel topLabel=new JLabel("Patient Diagnosis Record");

    public recordDiagnosis() {
        JPanel jpTop=new JPanel(new FlowLayout());
        JPanel jpInfo=new JPanel(new FlowLayout(FlowLayout.CENTER,20,15));
        Font font = new Font("SansSerif", Font.BOLD, 48); 
        topLabel.setFont(font);
        jpTop.add(topLabel);
        JPanel jpCenter = new JPanel(new GridLayout(6, 2));
        JLabel labelTreatmentID = new JLabel("Treatment ID:");
        labelTreatmentID.setFont(new Font("SansSerif", Font.BOLD, 18));
        jpInfo.add(labelTreatmentID);
        jpInfo.add(jtfTreatID);
        JLabel labelPatient = new JLabel("Patient Name:");
        labelPatient.setFont(new Font("SansSerif", Font.BOLD, 18));
        jpInfo.add(labelPatient);
        jpInfo.add(jtfPatientName);
        JLabel labelDate = new JLabel("Date");
        labelDate.setFont(new Font("SansSerif", Font.BOLD, 18));
        jpInfo.add(labelDate);
        jpInfo.add(jtfDate);
        JLabel labelDoctor = new JLabel("Doctor");
        labelDoctor.setFont(new Font("SansSerif", Font.BOLD, 18));
        jpCenter.add(labelDoctor);
        jpCenter.add(jtfDoctor);
        JLabel labelDiagnosis = new JLabel("Diagnosis");
        labelDiagnosis.setFont(new Font("SansSerif", Font.BOLD, 18));
        jpCenter.add(labelDiagnosis);
        jpCenter.add(jtfDiagnosis);
        JLabel labelType = new JLabel("Type of Treatment");
        labelType.setFont(new Font("SansSerif", Font.BOLD, 18));
        jpCenter.add(labelType);
        jpCenter.add(jtfTreatment);
        JLabel labelTreatment = new JLabel("Treatment Notes");
        labelTreatment.setFont(new Font("SansSerif", Font.BOLD, 18));
        jpCenter.add(labelTreatment);
        jpCenter.add(jtfNote);
        JLabel labelPatientStatus = new JLabel("Patient Status");
        labelPatientStatus.setFont(new Font("SansSerif", Font.BOLD, 18));
        jpCenter.add(labelPatientStatus);
        jpCenter.add(jtfPatient);
        JLabel labelFollowUp = new JLabel("Follow-up Required");
        labelFollowUp.setFont(new Font("SansSerif", Font.BOLD, 18));
        jpCenter.add(labelFollowUp);
        jpCenter.add(jtfFollowUp);
        add(jpTop,BorderLayout.NORTH);
        add(jpInfo);
        JPanel jpSouth = new JPanel();
        JPanel jpForm=new JPanel(new BorderLayout());
        jpForm.add(jpInfo,BorderLayout.NORTH);
        jpForm.add(jpCenter);
        add(jpForm);
        jpSouth.add(jbtAdd);
        jpSouth.add(jbtDelete);
        add(jpSouth, BorderLayout.SOUTH);
        
        
    }
    
    
    public static void main(String[] args) {
          recordDiagnosis frm=new recordDiagnosis();   
          frm.setTitle("Patient Diagnosis Record");
          frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frm.setLocationRelativeTo(null);
          frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frm.setVisible(true);
    }
}
