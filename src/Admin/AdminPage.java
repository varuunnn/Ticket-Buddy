package Admin;
import java.sql.*;
import java.awt.EventQueue;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class AdminPage {

	private JFrame frmAdminPage;
	private JTextField stadiumtf;
	private JTextField matchestf;
	private JTextField datetf;
	private JTable table;
	DefaultTableModel model;
	private JScrollPane scrollPane;

	public AdminPage() {
		initialize();
	}

	private void Add() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On","root","1234varun");
			String query="insert into Match_display values(?,?,?)";
			PreparedStatement pa= con.prepareStatement(query);
			pa.setString(1, datetf.getText());
			pa.setString(2, matchestf.getText());
			pa.setString(3, stadiumtf.getText());
			pa.execute();
			JOptionPane.showMessageDialog(null,"ADDED");
			con.close();
			pa.close();
		}
		catch(Exception e) {
			System.out.println("ERROR " +e);
			System.out.println();
		}
	}

	private void initialize() {
		frmAdminPage = new JFrame();
		frmAdminPage.setTitle("Admin Page");
		frmAdminPage.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\LOGO.png"));
		frmAdminPage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				show();
			}
		});
		frmAdminPage.setBounds(100, 100, 695, 500);
		frmAdminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 679, 453);
		frmAdminPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setBounds(89, 245, 114, 33);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblDate);
		
		JLabel lblMatchs = new JLabel("MATCH");
		lblMatchs.setForeground(new Color(255, 255, 255));
		lblMatchs.setBounds(89, 316, 114, 33);
		lblMatchs.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblMatchs);
		
		JLabel lblStadium = new JLabel("STADIUM");
		lblStadium.setForeground(new Color(255, 255, 255));
		lblStadium.setBounds(89, 390, 114, 33);
		lblStadium.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblStadium);
		
		stadiumtf = new JTextField();
		stadiumtf.setBounds(230, 393, 143, 33);
		panel.add(stadiumtf);
		stadiumtf.setColumns(10);
		
		matchestf = new JTextField();
		matchestf.setBounds(230, 319, 143, 33);
		matchestf.setColumns(10);
		panel.add(matchestf);
		
		datetf = new JTextField();
		datetf.setBounds(230, 248, 143, 33);
		datetf.setColumns(10);
		panel.add(datetf);

		JButton addbtn = new JButton("");
		addbtn.setBorder(null);
		addbtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\button_add.png"));
		addbtn.setContentAreaFilled(false);
		addbtn.setOpaque(false);
		addbtn.setBackground(new Color(255, 204, 0));
		addbtn.setBounds(467, 242, 117, 50);
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add();
			}
		});
		panel.add(addbtn);
		
		JButton deletebtn = new JButton("");
		deletebtn.setBorder(null);
		deletebtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\button_delete.png"));
		deletebtn.setContentAreaFilled(false);
		deletebtn.setOpaque(false);
		deletebtn.setBackground(new Color(255, 204, 0));
		deletebtn.setBounds(467, 305, 117, 61);
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				String cell=table.getModel().getValueAt(i, 2).toString();
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On","root","1234varun");
					PreparedStatement ps= con.prepareStatement("delete from Match_display where stadium ='"+cell+"'");
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"DELETED");
				}
				catch(Exception e1) {
					System.out.println("ERROR " +e1);
				}
				//show();
			}
		});
		panel.add(deletebtn);
		
		JButton updatebtn = new JButton("");
		updatebtn.setBorder(null);
		updatebtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\button_update.png"));
		updatebtn.setContentAreaFilled(false);
		updatebtn.setOpaque(false);
		updatebtn.setBackground(new Color(255, 204, 0));
		updatebtn.setBounds(467, 379, 117, 47);
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show();
			}
		});
		panel.add(updatebtn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 30, 513, 185);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(50);
		frmAdminPage.setVisible(true);
	}
	
	private void show()
	{
		model=new DefaultTableModel();
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
			table.getColumnModel().getColumn(0).setPreferredWidth(170);
			table.getColumnModel().getColumn(1).setPreferredWidth(170);
			table.getColumnModel().getColumn(2).setPreferredWidth(170);
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
