package boundary;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entity.Patient;

import control.PatientControl;



        

public class PatientRegister extends JPanel{
    private JFrame frame;
    private JPanel previousPage;
    private boolean isNew=true;
    
    private JLabel patientIC;
    private JTextField tfIC;
    private String ic=null;
   
    public PatientRegister(JFrame frame){
        this.frame = frame;
        
        JMenuBar menuBar=new JMenuBar();
        JMenu menu1=new JMenu("Patient");
        JMenuItem item1= new JMenuItem("Patient Registration");
        
        item1.addActionListener(e -> {
            frame.getContentPane().removeAll();
            JPanel panel =new PatientRegister(frame);
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        });
        JMenuItem item2=new JMenuItem("Record Maintainance");
        item2.addActionListener(e -> {
            frame.getContentPane().removeAll();
            JPanel panel =new RecordMaintenance(frame,PatientRegister.this);
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        });
        JMenuItem item3=new JMenuItem("Queue Management");
        item3.addActionListener(e -> {
            frame.getContentPane().removeAll();
            JPanel panel =new QueueManagement(frame,PatientRegister.this);
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        });
        JMenuItem item4=new JMenuItem("Patient Info");
         item4.addActionListener(e -> {
            frame.getContentPane().removeAll();
            Patient patient =new Patient();
            JPanel panel =new PatientInfo(frame,PatientRegister.this,patient,isNew);
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        });
        JMenu menu2=new JMenu("Doctor");
        JMenu menu3=new JMenu("Consultation");
        JMenu menu4=new JMenu("Medical Treatment");
        JMenu menu5=new JMenu("Pharmacy");
        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(item2);
        menu1.addSeparator();
        menu1.add(item3);
        menu1.addSeparator();
        menu1.add(item4);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        frame.setJMenuBar(menuBar);
        
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel(new GridLayout(3, 1,0, 20));
        patientIC = new JLabel("Patient IC : ");
        patientIC.setFont(new Font("Serif", Font.PLAIN, 40));
        tfIC = new JTextField(20);
        tfIC.setFont(new Font("Serif", Font.PLAIN, 40));
        JButton submit =new JButton("Submit");
        submit.setFont(new Font("Serif", Font.PLAIN, 40));
        
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ic = tfIC.getText().trim();
                PatientControl control = new PatientControl(frame, PatientRegister.this);
                control.processSumbitIC();
            }
        });
        
        panel.add(patientIC);
        panel.add(tfIC);
        panel.add(submit);
        
        add(panel);
    //setVisible(true);
    }
    
  
    public String getEnteredIC() {
        return ic;
    }
    
    public JTextField getTfIC() {
        return tfIC;
    }
    
    
    public static void main(String[] args){
        JFrame frame=new JFrame();
        frame.setTitle("TARUMT Clinic");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel patientReg = new PatientRegister(frame);
        frame.add(patientReg);
        frame.setVisible(true);
    }
}
