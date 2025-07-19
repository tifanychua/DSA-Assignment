
import java.awt.*;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author User
 */
public class PatientTreatmentRecord extends JFrame{
    private JLabel topicLabel=new JLabel("Patient Treatment Record");
    private JLabel iCLabel=new JLabel("Patient's IC:");
    private JTextField icField=new JTextField();
    private JButton searchBtn=new JButton("Search");
    
    public PatientTreatmentRecord(){
        JPanel form=new JPanel(new FlowLayout());
        JPanel jpTop=new JPanel();
        JPanel imageForm=new JPanel();
        JPanel buttonPanel=new JPanel();
        JPanel icForm=new JPanel(new GridLayout(2,1));
        topicLabel.setFont(new Font("SansSerif", Font.BOLD, 56));
        iCLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/treatment_img.png"));
        JLabel label = new JLabel(icon);
        imageForm.add(label);
        form.add(iCLabel);
        form.add(icField);
        icForm.add(form);
        buttonPanel.add(searchBtn);
        icForm.add(buttonPanel);
        Dimension buttonSize = new Dimension(150, 50); 
searchBtn.setPreferredSize(buttonSize);
searchBtn.setFont(new Font("SansSerif", Font.BOLD, 24));
        icField.setPreferredSize(new Dimension(700, 80));
icField.setFont(new Font("SansSerif", Font.BOLD, 40));
icField.setHorizontalAlignment(JTextField.CENTER);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 300, 0, 0));

        iCLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
        icForm.setBorder(BorderFactory.createEmptyBorder(50, 0, 180, 270));
        imageForm.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 100));
        jpTop.add(topicLabel,BorderLayout.CENTER);
        add(imageForm,BorderLayout.NORTH);
        add(jpTop,BorderLayout.CENTER);
        add(icForm,BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
          PatientTreatmentRecord frm=new PatientTreatmentRecord();   
          frm.setTitle("Patient Treatment Record");
          frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frm.setLocationRelativeTo(null);
          frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frm.setVisible(true);
    }
}
