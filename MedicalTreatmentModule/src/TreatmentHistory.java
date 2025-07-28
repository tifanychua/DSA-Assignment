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
        String[] columnNames = {"Treatment ID", "Diagnosis","Date" , "Status", "Follow-up" };

        Object[][] data = {
            {"T001", "ABC Supplies", "0123456789", "Cocoa", "2025-07-20"},
            {"S002", "XYZ Traders", "0987654321", "Sugar", 10.5}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFont(new Font("SansSerif", Font.PLAIN, 16));
        table.setRowHeight(28);  

        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 28));
        jpTop.add(topicLabel,BorderLayout.CENTER);
        JPanel searchPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        jpTop.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        table.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        table.setPreferredScrollableViewportSize(new Dimension(1800, 550));
        JPanel buttonPanel=new JPanel();
        Dimension buttonSize = new Dimension(150, 50); 
okButton.setPreferredSize(buttonSize);
        buttonPanel.add(okButton);
        buttonPanel.setFont(new Font("SansSerif", Font.BOLD, 24));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        add(jpTop,BorderLayout.NORTH);
        JPanel recordTable=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel searchLabel=new JLabel("Search:");
        searchPanel.add(searchLabel);
        JTextField searchText=new JTextField(25);
        searchPanel.add(searchText);
                searchLabel.setFont(new Font("Serif", Font.BOLD, 28));
                searchText.setPreferredSize(new Dimension(100,30));
        JPanel infoPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.add(searchPanel);
        recordTable.add(scrollPane,BorderLayout.CENTER);
        infoPanel.add(recordTable);
        recordTable.setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 0));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));

        add(infoPanel);
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
