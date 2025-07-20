/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.JTableHeader;

public class TreatmentHistory extends JFrame {
        private JLabel topicLabel=new JLabel("Patient Treatment History");
        private JButton okButton=new JButton("OK");
    public TreatmentHistory() {
        JPanel jpTop=new JPanel();
        topicLabel.setFont(new Font("SansSerif", Font.BOLD, 56));
        String[] columnNames = {"Treatment ID", "Diagnosis", "Treatment Type", "Status", "Follow-up", "Date"};

        Object[][] data = {
            {"T001", "ABC Supplies", "0123456789", "Cocoa", "2025-07-20", "abc@supplies.com"},
            {"S002", "XYZ Traders", "0987654321", "Sugar", 10.5, "xyz@traders.com"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFont(new Font("SansSerif", Font.PLAIN, 30));
        table.setRowHeight(100);  

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 32));
        jpTop.add(topicLabel,BorderLayout.CENTER);
        jpTop.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        table.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        table.setPreferredScrollableViewportSize(new Dimension(1800, 600));
        JPanel buttonPanel=new JPanel();
        Dimension buttonSize = new Dimension(150, 50); 
okButton.setPreferredSize(buttonSize);
        buttonPanel.add(okButton);
        buttonPanel.setFont(new Font("SansSerif", Font.BOLD, 24));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        add(jpTop,BorderLayout.NORTH);
        JPanel recordTable=new JPanel();
        recordTable.add(scrollPane);
        add(recordTable);
        add(buttonPanel,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
          TreatmentHistory frm=new TreatmentHistory();   
          frm.setTitle("Treatment History");
          frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frm.setLocationRelativeTo(null);
          frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frm.setVisible(true);
    }
}
