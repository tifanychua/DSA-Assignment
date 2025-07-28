package boundary;


import control.QueueControl;
import entity.PatientQueueEntry;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class QueueManagement extends JPanel{
    private JFrame frame;
    private JPanel previousPage;
    private JPanel btn;
    private JPanel infoPanel;
    private JPanel queuePanel;
    
    private JLabel queueLabel;
    private JLabel IC;
    private JLabel tfIC;
    private JLabel name;
    private JLabel tfName;
    
    private JButton btnDone;
    private JButton btnMiss;
    
    private JLabel selectedLabel;
    private String selectedRoom;
    
    private DefaultTableModel tableModel;
    private JTable queueTable;
    
    private boolean isCompleted=true;
    private boolean result;
    
    public QueueManagement(JFrame frame,JPanel previousPage){
        this.frame = frame;
        this.previousPage = previousPage;
        setLayout(new BorderLayout());
       JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
       topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
       
       RecordMaintenance rm = new RecordMaintenance(frame, previousPage);
       JButton btnBack = rm.iconButton("Back", "/picture/backIcon.png");
       JButton btnNext = rm.iconButton("Next", "/picture/nextIcon.png");
       JButton btnQueue = rm.iconButton("All Queues", "/picture/queueIcon.png");
       
       topPanel.add(btnBack);
       topPanel.add(btnNext);
       topPanel.add(btnQueue);
       
       add(topPanel,BorderLayout.NORTH);
        infoPanel=mainPanel();
        queuePanel = allQueuePanel();
        
        add(infoPanel, BorderLayout.CENTER);
        add(queuePanel, BorderLayout.CENTER);
        
        infoPanel.setVisible(false);
        queuePanel.setVisible(false);
        System.out.println(result);
       btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validateDone()){
                isCompleted = false;
                JOptionPane.showMessageDialog(null,"Please complete this patient.","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                frame.getContentPane().removeAll();
                frame.add(previousPage);
                frame.revalidate();
                frame.repaint();
                }
         }
          });
       
       btnNext.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            btnNext.setFont(new Font("Serif", Font.PLAIN, 25));
            btnQueue.setFont(new Font("Serif", Font.PLAIN, 16));
            add(infoPanel,BorderLayout.CENTER);
            infoPanel.setVisible(true);
            queuePanel.setVisible(false);
            result = validateDone();
            if(!result){
                isCompleted = false;
                JOptionPane.showMessageDialog(null,"Please complete this patient.","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                PatientQueueEntry nextPatient = QueueControl.getInstance().callNextPatient();
                if (nextPatient != null) {
                JOptionPane.showMessageDialog(null, 
                    "Now calling: " + nextPatient.getQueueNumber() + "\nName: " + nextPatient.getName());
                
                queueLabel.setText(nextPatient.getQueueNumber());
                tfIC.setText(nextPatient.getIC());
                tfName.setText(nextPatient.getName());
                
                queueLabel.setVisible(true);
                tfIC.setVisible(true);
                tfName.setVisible(true);
                IC.setVisible(true);
                name.setVisible(true);
                btnDone.setVisible(true);
                btnMiss.setVisible(true);
                isCompleted = false;
            } else {
                queueLabel.setVisible(false);
                tfIC.setVisible(false);
                tfName.setVisible(false);
                IC.setVisible(false);
                name.setVisible(false);
                btnDone.setVisible(false);
                btnMiss.setVisible(false);
                JOptionPane.showMessageDialog(null, "No next patient.");
                isCompleted = true;
                
            }
            }
        }
    });
       
       btnQueue.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (!validateDone()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Please complete this patient.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return; 
            }

            btnNext.setFont(new Font("Serif", Font.PLAIN, 16));
            btnQueue.setFont(new Font("Serif", Font.PLAIN, 25));
            add(queuePanel, BorderLayout.CENTER);
            infoPanel.setVisible(false);
            queuePanel.setVisible(true);
            refreshQueueTable();
        }
    });
    }
   

    private JPanel mainPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(50, 300, 50, 300));
        
        queueLabel = new JLabel();
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
        JPanel panel = new JPanel(new GridLayout(2,2,0,10));
        
        IC = labelFormat("IC : ");
        tfIC=labelFormat("");
        name = labelFormat("Name : ");
        tfName=labelFormat("");

        
        panel.add(IC);
        panel.add(tfIC);
        panel.add(name);
        panel.add(tfName);
        
        
        return panel;
    }
    
    private JPanel allQueuePanel(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 90, 30, 90));
        String[] columnNames = {"Queue Number", "IC", "Name", "Patient Entry by", "Status"};
        String[][] data = QueueControl.getInstance().getAllQueue();

        
        tableModel = new DefaultTableModel(data, columnNames);
        queueTable = new JTable(tableModel);
        
        queueTable.setRowHeight(28);
        queueTable.setFont(new Font("Serif", Font.PLAIN, 16));
        queueTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 16));

        JScrollPane scrollPane = new JScrollPane(queueTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JLabel label = new JLabel("All Queues Displayed Below");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(label, BorderLayout.NORTH); 
        
        return panel;
    }
    
    private void refreshQueueTable() {
    String[][] updatedData = QueueControl.getInstance().getAllQueue();

    // Clear current table
    tableModel.setRowCount(0);

    // Add updated rows
    for (String[] row : updatedData) {
        tableModel.addRow(row);
    }
}
    
    private JPanel buttonPanel(){
         btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); 
         btnDone = buttonFormat("Done");
         btnMiss = buttonFormat("Missing");
         
        btn.add(btnDone);
        btn.add(btnMiss);
          
          btnDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null,"Now go to consultation mode");
             isCompleted=true;
             infoPanel.setVisible(false);
            }
        });
          
           btnMiss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null,"Oops this patient is missing. \nPlease click next to accept new patient.");
             isCompleted = true;
             infoPanel.setVisible(false);
            }
        });
                return btn;
    }
   
    private boolean validateDone(){
        if(!isCompleted){
            return false;
        }
            return true;
        
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
