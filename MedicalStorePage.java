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
import javax.swing.table.*;

public class MedicalStorePage extends JFrame{
    
    private JButton btn1 = new JButton("Edit");
    private JButton addBtn = new JButton("Add");
    private JButton purchaseBtn = new JButton("Procurement");
    
    public MedicalStorePage(){
        
        String[] columnNames = {"Product Name", "Quantity", "Unit", "Price", ""};
        Object[][] data = {
            {"Paracetamol", 100, "Tab", 35.20, btn1},
            {"Ibuprofen", 50, "Tab", 40.00, btn1}  
        };
        
        JPanel p1 = new JPanel(new BorderLayout());
        
        JTable table = new JTable(data, columnNames);
        JTableHeader header = table.getTableHeader();
        
        header.setBounds(50, 30, 700, 20);
        header.setReorderingAllowed(false);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        
        table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        table.setRowHeight(30);
        
        JScrollPane scrollPane = new JScrollPane(table);
        p1.add(scrollPane);
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(addBtn);
        p2.add(purchaseBtn);
        p2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.NORTH);
        
        addBtn.addActionListener(new AddNewMedical());
        purchaseBtn.addActionListener(new Procurement());
        
        setJMenuBar(new MenuBar().createMenuBar());
        setTitle("Medical Store Page");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private class AddNewMedical implements ActionListener{
        public void actionPerformed (ActionEvent e){
            new AddMedicalPage();
        }
    }
    
    private class Procurement implements ActionListener{
        public void actionPerformed (ActionEvent e){
            new ProcurementPage();
        }
    }
    
    
    public static void main(String[] args){
        new MedicalStorePage();
    }
}
