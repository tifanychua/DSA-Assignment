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
import java.awt.event.*;

public class AddMedicalPage extends JFrame{

    private JLabel name = new JLabel("Madicine Name");
    private JLabel qty = new JLabel("Quantity");
    private JLabel jlRefPrice = new JLabel("Reference Price");
    private JLabel jlSalesPrice = new JLabel("Sales Price");
    
    private JTextField medicineName = new JTextField(50);
    private JTextField medicineQty = new JTextField(50);
    private JTextField refPrice = new JTextField(50);
    private JTextField salesPrice = new JTextField(50);
    private JButton clear = new JButton("Clear");
    private JButton submit = new JButton("Submit");
    private JButton cancel = new JButton("Cancel");
    
    public AddMedicalPage(){
        
        JPanel p1 = new JPanel(new GridLayout(5, 5));
        p1.add(name);
        p1.add(medicineName);
        p1.add(qty);
        p1.add(medicineQty);
        p1.add(jlRefPrice);
        p1.add(refPrice);
        p1.add(jlSalesPrice);
        p1.add(salesPrice);
        
        TitledBorder titleBorder = new TitledBorder("New Medicine Details:");
        titleBorder.setTitleFont(new Font("Dialog", Font.BOLD, 15));
        p1.setBorder(titleBorder);
        
        Font font = new Font("Arial", Font.BOLD, 14);
        name.setFont(font);
        qty.setFont(font);
        jlRefPrice.setFont(font);
        jlSalesPrice.setFont(font);
        
        Font font2 = new Font("Arial", Font.PLAIN, 14);
        medicineName.setFont(font2);
        medicineQty.setFont(font2);
        refPrice.setFont(font2);
        salesPrice.setFont(font2);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.add(clear);
        p2.add(submit);
        p2.add(cancel);
        
        clear.addActionListener(new ClearListener());
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
    
    private class ClearListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            medicineName.setText("");
            medicineQty.setText("");
            refPrice.setText("");
            salesPrice.setText("");
            medicineName.grabFocus();
        }
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
