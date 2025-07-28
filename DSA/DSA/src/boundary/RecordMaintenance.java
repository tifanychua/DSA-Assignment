package boundary;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RecordMaintenance extends JPanel{
    private JFrame frame;
    private JPanel previousPage;
    
    public RecordMaintenance(JFrame frame,JPanel previousPage){
        this.frame = frame;
        this.previousPage = previousPage;
        
       setLayout(new BorderLayout());
       JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
       topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
       
       JButton btnBack = iconButton("Back", "/picture/backIcon.png");
       
       topPanel.add(btnBack);
       
       add(topPanel,BorderLayout.NORTH);
       JPanel contentPanel = patientModule();
       add(contentPanel,BorderLayout.CENTER);
        
       
       btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBack.setFont(new Font("Serif", Font.PLAIN, 25));
                frame.getContentPane().removeAll();
                frame.add(previousPage);
                frame.revalidate();
                frame.repaint();
         }
          });
       
       
    }
     private JPanel searchPanel(String type){
        JPanel panel =new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JTextField search = new JTextField();
        search.setFont(new Font("Serif", Font.PLAIN, 18));
        search.setPreferredSize(new Dimension(500, 40));
        JButton btnSearch = new JButton("Search");
        btnSearch.setPreferredSize(new Dimension(150, 40));
        btnSearch.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(search);
        panel.add(btnSearch);
        
        add(panel);
        return panel;
    }
     
    private JPanel patientModule(){
        JPanel panelA=new JPanel();
        panelA.setLayout(new BorderLayout());
        panelA.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        JPanel searchPanel = searchPanel("patient"); 
        panelA.add(searchPanel, BorderLayout.NORTH);
        
        String[] columnNames = {"IC", "Name","Phone Number","Blood Type","Next Appointment"};

        String[][] data = {
            {"010215021133", "John Doe", "012-3456789", "A"},
            {"020425067724", "Jane Lee", "013-2345678", "B"},
            {"030526070242", "Ali Bin Ahmad", "014-3456789", "AB"}
        };
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        
        table.setRowHeight(28);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 16));

        JScrollPane scrollPane = new JScrollPane(table);
        panelA.add(scrollPane, BorderLayout.CENTER);
        
        JButton detail = new JButton("More Detail");
        detail.setPreferredSize(new Dimension(300, 40));
        detail.setFont(new Font("Serif", Font.BOLD, 20));
        
        JButton delete = new JButton("Delete");
        delete.setPreferredSize(new Dimension(300, 40));
        delete.setFont(new Font("Serif", Font.BOLD, 20));
        
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        southPanel.add(detail);
        southPanel.add(delete);
        panelA.add(southPanel, BorderLayout.SOUTH);
        
        return panelA;
    }
    
    public JButton iconButton(String text, String imagePath) {
       
    ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
    Image img = icon.getImage();
    Image resizedImg = img.getScaledInstance(50, 40, Image.SCALE_SMOOTH); 
    ImageIcon resizedIcon = new ImageIcon(resizedImg);

    JButton button = new JButton(text, resizedIcon);
    
        
    button.setPreferredSize(new Dimension(250, 60));
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);
    button.setOpaque(false);
    button.setIconTextGap(10);
    button.setFont(new Font("Serif", Font.PLAIN, 16));
    
    return button;
}
    
    public static void main(String[] args){
        JFrame frame=new JFrame();
        JPanel previousPage = new JPanel();
        JPanel recordMaintenance = new RecordMaintenance(frame,previousPage);
        frame.add(recordMaintenance);
        frame.setVisible(true);
    }
    
   
}
