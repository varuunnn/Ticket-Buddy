package mybookings;
import javafx.application.Application;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class mybookings extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel model;

	private void shows(String id)
	{
		model=new DefaultTableModel();
		model.addColumn("DATE");
		model.addColumn("MATCH NAME");
		model.addColumn("SEAT NUMBER");
		model.addColumn("STAND");
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On","root","1234varun");
			String query= "select match_date,match_name,seat_no,stand_name from booked_seat where user_id='"+id+"'";
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				model.addRow(new Object[] {
					rs.getString("match_date"),
					rs.getString("match_name"),
					rs.getString("seat_no"),
					rs.getString("stand_name")
				});
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(144);
			table.getColumnModel().getColumn(1).setPreferredWidth(144);
			table.getColumnModel().getColumn(2).setPreferredWidth(144);
			table.getColumnModel().getColumn(3).setPreferredWidth(144);
		}
		catch(Exception e) {
			System.out.println("ERROR " +e);
		}
		
	}

	public mybookings(String user_id) {
		String id = user_id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 688, 429);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("YOUR BOOKINGS...");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(36, 11, 167, 30);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 52, 579, 292);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		shows(id);
		this.setVisible(true);
	}
}
