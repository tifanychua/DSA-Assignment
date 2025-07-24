package boundary;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QueueManagement extends JPanel{
    private JFrame frame;
    private JPanel previousPage;
    private JPanel btn;
    private JPanel infoPanel;
    
    private JLabel queueLabel;
    private JLabel IC;
    private JLabel tfIC;
    private JLabel name;
    private JLabel tfName;
    private JLabel doctor;
    private JLabel tfDoctor;
    private JLabel room;
    private JLabel tfRoom;
    
    private JButton btnAccept;
    private JButton btnDone;
    private JButton btnMiss;
    
    private JLabel selectedLabel;
    private String selectedRoom;
    
    public QueueManagement(JFrame frame,JPanel previousPage){
        this.frame = frame;
        this.previousPage = previousPage;
        setLayout(new BorderLayout());
       JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
       topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
       
       RecordMaintenance rm = new RecordMaintenance(frame, previousPage);
       JButton btnBack = rm.iconButton("Back", "/picture/backIcon.png");
       JButton btnNext = rm.iconButton("Next", "/picture/nextIcon.png");
       
       topPanel.add(btnBack);
       topPanel.add(btnNext);
       
       add(topPanel,BorderLayout.NORTH);
        infoPanel=mainPanel();
       btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(previousPage);
                frame.revalidate();
                frame.repaint();
         }
          });
       
       btnNext.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            btnNext.setFont(new Font("Serif", Font.PLAIN, 25));
            add(infoPanel,BorderLayout.CENTER);
            infoPanel.setVisible(true);
        }
        public void mouseReleased(MouseEvent e) {
            btnNext.setFont(new Font("Serif", Font.PLAIN, 16));
        }
    });
       
      
       
    }
   

    private JPanel mainPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(50, 300, 50, 300));
        
        queueLabel = new JLabel("101");
        queueLabel.setPreferredSize(new Dimension(250, 250));
        queueLabel.setOpaque(true);
        queueLabel.setBackground(Color.WHITE);
        queueLabel.setFont(new Font("Serif", Font.PLAIN, 28));
        queueLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        queueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(queueLabel,BorderLayout.NORTH);
        panel.add(infoQueue(),BorderLayout.CENTER);
        panel.add(buttonPanel(), BorderLayout.SOUTH);
        
        return panel;
    }
   
    
    private JPanel infoQueue(){
        JPanel panel = new JPanel(new GridLayout(2,4,0,10));
        
        IC = labelFormat("IC : ");
        tfIC=labelFormat("");
        name = labelFormat("Name : ");
        tfName=labelFormat("");
        doctor = labelFormat("Doctor : ");
        tfDoctor=labelFormat("");
        room = labelFormat("Room : ");
        tfRoom=labelFormat("");
        
        panel.add(IC);
        panel.add(tfIC);
        panel.add(name);
        panel.add(tfName);
        panel.add(doctor);
        panel.add(tfDoctor);
        panel.add(room);
        panel.add(tfRoom);
        
        
        return panel;
    }
    
    private JPanel buttonPanel(){
         btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); 
         btnAccept = buttonFormat("Accept");
         btnDone = buttonFormat("Done");
         btnMiss = buttonFormat("Missing");
         
        btn.add(btnAccept);
        btn.add(btnDone);
        btn.add(btnMiss);

        btnDone.setVisible(false);
        btnMiss.setVisible(false);
        
          btnAccept.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAccept.setVisible(false);
                btnDone.setVisible(true);
                btnMiss.setVisible(true);
                tfRoom.setText(selectedRoom);
                if (selectedLabel != null)
                    selectedLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));

            }
          });
          
          btnDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null,"Now go to consultation mode");
             infoPanel.setVisible(false);
            }
        });
          
           btnMiss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null,"Oops this patient is missing. \nPlease click next to accept new patient.");
             infoPanel.setVisible(false);
            }
        });
                return btn;
    }
    
    private JLabel labelFormat(String text) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("Serif", Font.PLAIN, 30));
    label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); 
    return label;
}
    
    private JButton buttonFormat(String text) {
    JButton button = new JButton(text);
    button.setPreferredSize(new Dimension(200, 50));
    button.setFont(new Font("Serif", Font.BOLD, 16));
    button.setFocusPainted(false); 
    return button;
}
    
    
    private JButton topButton(String text) {
       
    JButton button = new JButton(text);
    button.setPreferredSize(new Dimension(200, 60));
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);
    button.setOpaque(false);
    button.setIconTextGap(10);
    button.setFont(new Font("Serif", Font.PLAIN, 18));
    
    return button;
}
    
    public static void main(String[] args){
        JFrame frame=new JFrame();
        JPanel previousPage = new JPanel();
        JPanel queueManagement = new QueueManagement(frame,previousPage);
        frame.add(queueManagement);
        frame.setVisible(true);
    }
}
