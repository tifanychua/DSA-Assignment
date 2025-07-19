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
import java.awt.event.*;
import java.time.format.DateTimeFormatter;

public class ProcurementPage extends JFrame{

    private JLabel jlDate = new JLabel("Purchase Date");
    private JLabel name = new JLabel("Product Name");
    private JLabel qty = new JLabel("Purchase Quantity");
    private JLabel jlRefPrice = new JLabel("Purchase Price");
    
    private JTextField jtfPaymentDate = new JTextField(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    private JTextField medicineQty = new JTextField(50);
    private JTextField medicineQtyInTablet = new JTextField(50);
    private JTextField refPrice = new JTextField(50);
    
    private JButton submit = new JButton("Submit");
    private JButton cancel = new JButton("Cancel");
    
    public ProcurementPage(){
        
        String[] nameMedicine = {"Paracetamol", "Amoxicillin", "Cough Syrup", "Eye Drops", "Cream A"};
        JComboBox<String> medicineNameList = new JComboBox<>(nameMedicine);

        JPanel p1 = new JPanel(new GridLayout(4, 4));
        p1.add(jlDate);
        p1.add(jtfPaymentDate);
        p1.add(name);
        p1.add(medicineNameList);
        p1.add(qty);
        p1.add(medicineQty);
        p1.add(jlRefPrice);
        p1.add(refPrice);
        
        Font font = new Font("Arial", Font.BOLD, 14);
        name.setFont(font);
        qty.setFont(font);
        jlRefPrice.setFont(font);
        
        Font font2 = new Font("Arial", Font.PLAIN, 14);
        medicineNameList.setFont(font2);
        medicineQty.setFont(font2);
        refPrice.setFont(font2);
        
        TitledBorder titleBorder = new TitledBorder("Purchase Details:");
        titleBorder.setTitleFont(new Font("Dialog", Font.BOLD, 15));
        p1.setBorder(titleBorder);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.add(submit);
        p2.add(cancel);
        
        cancel.addActionListener(new CancelListener());
        submit.addActionListener(new AddListener());
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        setTitle("Add New Medical");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
}
