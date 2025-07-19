/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pei Wen
 */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.awt.event.*;
import javax.swing.table.JTableHeader;

public class PaymentPage extends JFrame{
    
    private JLabel jlPatient = new JLabel("Patient ID");
    private JLabel jlPatientName = new JLabel("Patient Name");
    private JLabel jlPaymentDate = new JLabel("Payment Date");
    private JLabel jlAmount = new JLabel("Amount");
    private JLabel jlPaymentMethod = new JLabel("Payment Method");
    
    private JTextField jtfPatient = new JTextField(50);
    private JTextField jtfPatientName = new JTextField(50);
    private JTextField jtfPaymentDate = new JTextField(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    private JTextField jtfAmount = new JTextField(50);
    
    private JButton submit = new JButton("Submit");
    private JButton cancel = new JButton("Cancel");
    
    public PaymentPage(){
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(submit);
        p2.add(cancel);
        
        String[] paymentType = {"Card", "Cash", "E-wallet"};
        JComboBox<String> paymentMethod = new JComboBox<>(paymentType);
        
        JPanel p1 = new JPanel(new GridLayout(6, 6));
        p1.add(jlPatient);
        p1.add(jtfPatient);
        p1.add(jlPatientName);
        p1.add(jtfPatientName);
        p1.add(jlPaymentDate);
        p1.add(jtfPaymentDate);
        p1.add(jlAmount);
        p1.add(jtfAmount);
        p1.add(jlPaymentMethod);
        p1.add(paymentMethod);
        p1.add(new JLabel(""));
        p1.add(p2);
        
        p1.setBorder(new TitledBorder("Enter Details:"));
        jtfPaymentDate.setEditable(false);
        jtfAmount.setEditable(false);

        String[] columnNames = {"Product Name", "Quantity", "Unit", "Price"};
        Object[][] data = {
            {"Paracetamol", 100, "Tab", 35.20},
            {"Ibuprofen", 50, "Tab", 40.00}  
        };
        
        JTable table = new JTable(data, columnNames);
        JTableHeader header = table.getTableHeader();
        
        header.setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(table);
        
        scrollPane.setPreferredSize(new Dimension(300, 300));
        
        add(p1, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        
        cancel.addActionListener(new CancelListener());
        submit.addActionListener(new AddListener());
        
        setTitle("Payment Information");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
 
    }
    
    private class CancelListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            dispose();
        }
    }
    
    private class AddListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            dispose();
        }
    }
    
    public static void main(String[] args){
        new PaymentPage();
    }
    
}
