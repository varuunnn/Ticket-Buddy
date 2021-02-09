package matches;

import Stadiums.stadium;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Cursor;


public class upcoming_matches extends JFrame {

    public JFrame frmUpcomingMatches;
    public JTable table;
    public String match_name;
    public String match_date;

    public upcoming_matches(String userid) {
        //initialize();
        frmUpcomingMatches = new JFrame();
        frmUpcomingMatches.getContentPane().setBackground(new Color(0, 0, 51));
        frmUpcomingMatches.setTitle("Upcoming Matches");
        frmUpcomingMatches.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\LOGO.png"));
        frmUpcomingMatches.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                shows();
            }
        });
        frmUpcomingMatches.setBounds(100, 100, 689, 433);
        frmUpcomingMatches.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmUpcomingMatches.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Matches Available");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(35, 13, 219, 23);
        frmUpcomingMatches.getContentPane().add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setEnabled(false);
        scrollPane.setBounds(35, 71, 601, 237);
        frmUpcomingMatches.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setRowHeight(50);

        JButton bookbtn = new JButton("");
        bookbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bookbtn.setContentAreaFilled(false);
        bookbtn.setBorderPainted(false);
        bookbtn.setBorder(null);
        bookbtn.setOpaque(false);
        bookbtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\button_book.png"));
        bookbtn.setFocusable(false);
        bookbtn.setBackground(Color.BLUE);
        bookbtn.setForeground(Color.WHITE);
        bookbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int i = table.getSelectedRow();
                    match_name = table.getModel().getValueAt(i, 1).toString();
                    match_date = table.getModel().getValueAt(i, 0).toString();
                    stadium s = new stadium(match_name, match_date,userid);
                    s.setVisible(true);
                    frmUpcomingMatches.dispose();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Select a Match and go ahead");
                }
            }
        });
        bookbtn.setBounds(401, 321, 135, 52);
        frmUpcomingMatches.getContentPane().add(bookbtn);

        JButton refreshbtn = new JButton("");
        refreshbtn.setContentAreaFilled(false);
        refreshbtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\button_refresh.png"));
        refreshbtn.setOpaque(false);
        refreshbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refreshbtn.setBorder(null);
        refreshbtn.setBorderPainted(false);
        refreshbtn.setFocusable(false);
        refreshbtn.setBackground(new Color(0, 0, 51));
        refreshbtn.setForeground(Color.WHITE);
        refreshbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shows();
            }
        });
        refreshbtn.setBounds(133, 321, 135, 52);
        frmUpcomingMatches.getContentPane().add(refreshbtn);

        JLabel lblNewLabel_1 = new JLabel("Select a Match click and on \"Book\"");
        lblNewLabel_1.setForeground(new Color(255, 215, 0));
        lblNewLabel_1.setBounds(45, 49, 213, 16);
        frmUpcomingMatches.getContentPane().add(lblNewLabel_1);
        frmUpcomingMatches.setLocationRelativeTo(null);
        frmUpcomingMatches.setVisible(true);
    }

    public void shows()
    {
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("DATE");
        model.addColumn("MATCHES");
        model.addColumn("STADIUM");
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On","root","1234varun");
            String query= "select * from Match_display";
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()) {
                model.addRow(new Object[] {
                        rs.getString("match_date"),
                        rs.getString("match_name"),
                        rs.getString("stadium")
                });
            }
            rs.close();
            st.close();
            con.close();

            table.setModel(model);
            table.setAutoResizeMode(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(199);
            table.getColumnModel().getColumn(1).setPreferredWidth(199);
            table.getColumnModel().getColumn(2).setPreferredWidth(199);
            for (int c = 0; c < table.getColumnCount(); c++)
            {
                Class<?> col_class = table.getColumnClass(c);
                table.setDefaultEditor(col_class, null);        // remove editor
            }
        }
        catch(Exception e) {
            System.out.println("ERROR " +e);
        }
    }

}