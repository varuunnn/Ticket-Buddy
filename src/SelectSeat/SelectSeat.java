package SelectSeat;
import SelectPrice.SelectPrice;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectSeat extends JFrame {

	JSpinner spinner;
	JLabel pricelbl;
	public int a=1,count=0;
	List<String> selected = new ArrayList<String>();

	public SelectSeat(int price, String standname, String match_name, String match_date, String userid) {
		getContentPane().setBackground(new Color(0, 0, 51));
		setSize(1000,810);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\LOGO.png"));
		setTitle("Select Seat");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton paybtn = new JButton("Confirm and Pay");
		paybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a == count) {
					try {
						//Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On", "root", "1234varun");
						PreparedStatement st = null;
						for (int i = 0; i < selected.size(); i++) {
							String query = "insert into Booked_seat values(?,?,?,?,?)";
							st = con.prepareStatement(query);
							st.setString(1, userid);
							st.setString(2, selected.get(i));
							st.setString(3, match_name);
							st.setString(4, match_date);
							st.setString(5, standname);
							st.executeUpdate();
						}
						st.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Booking Successful!!\nYou can check the booking in \'My Bookings\' Section");
					} catch (Exception ex) {
						System.out.println(ex);
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Choose the seats properly");
				}
			}
		});
		paybtn.setBackground(Color.ORANGE);
		paybtn.setForeground(new Color(0, 0, 0));
		paybtn.setFont(new Font("Verdana", Font.BOLD, 30));
		paybtn.setBounds(606, 695, 321, 51);
		getContentPane().add(paybtn);
		
		JLabel lbl = new JLabel("How many Tickets?");
		lbl.setForeground(new Color(255, 255, 255));
		lbl.setBackground(new Color(255, 255, 255));
		lbl.setFont(new Font("Serif", Font.BOLD, 30));
		lbl.setBounds(108, 640, 249, 38);
		getContentPane().add(lbl);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);
		spinner.setFont(new Font("Serif", Font.BOLD, 30));
		spinner.setBounds(465, 643, 71, 33);
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ev) {
				a = (Integer)spinner.getValue();
				pricelbl.setText("Total Price = "+(price*a));
			}
		});
		getContentPane().add(spinner);
		
		JPanel mainpan = new JPanel();
		mainpan.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mainpan.setBackground(Color.WHITE);
		mainpan.setBounds(131, 114, 719, 498);
		getContentPane().add(mainpan);
		mainpan.setLayout(null);
		
		JPanel upperright = new JPanel();
		upperright.setLayout(null);
		upperright.setBounds(373, 339, 334, 132);
		mainpan.add(upperright);
		upperright.setLayout(new GridLayout(4, 14, 5, 5));
		for(int i=1;i<57;i++){
			JToggleButton ur = new JToggleButton();
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On", "root", "1234varun");
				Statement st = con.createStatement();
				String q = "select * from booked_seat where match_date='"+match_date+"' and stand_name='"+standname+"' and seat_no='ur"+i+"'";
				ResultSet rs = st.executeQuery(q);
				if(rs.next()){
					ur.setEnabled(false);
					ur.setBackground(Color.red);
				}
				else{
					ur.setBackground(Color.green);
				}
			}catch(Exception ex){System.out.println(ex);}
			ur.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(ur.isSelected()) {
						count++;
					}
					else if(!ur.isSelected()) {
						count--;
					}

					if(e.getStateChange() == ItemEvent.SELECTED){
						if(a < count){
							JOptionPane.showMessageDialog(null,"Limit crossed");
						}
						else {
							selected.add(ur.getName());
						}
					}
					if(e.getStateChange() == ItemEvent.DESELECTED){
						selected.remove(ur.getName());
					}
				}
			});
			ur.setName("ur"+i);
			upperright.add(ur);
		}
		
		JPanel lowerright = new JPanel();
		lowerright.setLayout(null);
		lowerright.setBounds(373, 25, 334, 132);
		mainpan.add(lowerright);
		lowerright.setLayout(new GridLayout(4, 14, 5, 5));
		for(int i=1;i<57;i++){
			JToggleButton lr = new JToggleButton();
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On", "root", "1234varun");
				Statement st = con.createStatement();
				String q = "select * from booked_seat where match_date='"+match_date+"' and stand_name='"+standname+"' and seat_no='lr"+i+"'";
				ResultSet rs = st.executeQuery(q);
				if(rs.next()){
					lr.setEnabled(false);
					lr.setBackground(Color.red);
				}
				else{
					lr.setBackground(Color.green);
				}
			}catch(Exception ex){System.out.println(ex);}
			lr.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(lr.isSelected()) {
						count++;

					}
					else if(!lr.isSelected()) {
						count--;
					}

					if(e.getStateChange() == ItemEvent.SELECTED){
						if(a < count){
							JOptionPane.showMessageDialog(null,"Limit crossed");
						}
						else {
							selected.add(lr.getName());
						}
					}
					if(e.getStateChange() == ItemEvent.DESELECTED){
						selected.remove(lr.getName());
					}
				}
			});
			lr.setName("lr"+i);
			lowerright.add(lr);
		}
		
		JPanel midright = new JPanel();
		midright.setLayout(null);
		midright.setBounds(373, 182, 334, 132);
		mainpan.add(midright);
		midright.setLayout(new GridLayout(4, 14, 5, 5));
		for(int i=1;i<57;i++){
			JToggleButton mr = new JToggleButton();
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On", "root", "1234varun");
				Statement st = con.createStatement();
				String q = "select * from booked_seat where match_date='"+match_date+"' and stand_name='"+standname+"' and seat_no='mr"+i+"'";
				ResultSet rs = st.executeQuery(q);
				if(rs.next()){
					mr.setEnabled(false);
					mr.setBackground(Color.red);
				}
				else{
					mr.setBackground(Color.green);
				}
			}catch(Exception ex){System.out.println(ex);}
			mr.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(mr.isSelected()) {
						count++;

					}
					else if(!mr.isSelected()) {
						count--;
					}

					if(e.getStateChange() == ItemEvent.SELECTED){
						if(a < count){
							JOptionPane.showMessageDialog(null,"Limit crossed");
						}
						else {
							selected.add(mr.getName());
						}
					}
					if(e.getStateChange() == ItemEvent.DESELECTED){
						selected.remove(mr.getName());
					}
				}
			});
			mr.setName("mr"+i);
			midright.add(mr);
		}
		
		JPanel lowerleft = new JPanel();
		lowerleft.setBounds(12, 25, 334, 132);
		mainpan.add(lowerleft);
		lowerleft.setLayout(new GridLayout(4, 14, 5, 5));
		for(int i=1;i<57;i++){
			JToggleButton ll = new JToggleButton();
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On", "root", "1234varun");
				Statement st = con.createStatement();
				String q = "select * from booked_seat where match_date='"+match_date+"' and stand_name='"+standname+"' and seat_no='ll"+i+"'";
				ResultSet rs = st.executeQuery(q);
				if(rs.next()){
					ll.setEnabled(false);
					ll.setBackground(Color.red);
				}
				else{
					ll.setBackground(Color.green);
				}
			}catch(Exception ex){System.out.println(ex);}
			ll.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(ll.isSelected()) {
						count++;

					}
					else if(!ll.isSelected()) {
						count--;
					}

					if(e.getStateChange() == ItemEvent.SELECTED){
						if(a < count){
							JOptionPane.showMessageDialog(null,"Limit crossed");
						}
						else {
							selected.add(ll.getName());
						}
					}
					if(e.getStateChange() == ItemEvent.DESELECTED){
						selected.remove(ll.getName());
					}
				}
			});
			ll.setName("ll"+i);
			lowerleft.add(ll);
		}
		
		JPanel upperleft = new JPanel();
		upperleft.setLayout(null);
		upperleft.setBounds(12, 339, 334, 132);
		mainpan.add(upperleft);
		upperleft.setLayout(new GridLayout(4, 14, 5, 5));
		for(int i=1;i<57;i++){
			JToggleButton ul = new JToggleButton();
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On", "root", "1234varun");
				Statement st = con.createStatement();
				String q = "select * from booked_seat where match_date='"+match_date+"' and stand_name='"+standname+"' and seat_no='ul"+i+"'";
				ResultSet rs = st.executeQuery(q);
				if(rs.next()){
					ul.setEnabled(false);
					ul.setBackground(Color.red);
				}
				else{
					ul.setBackground(Color.green);
				}
			}catch(Exception ex){System.out.println(ex);}
			ul.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(ul.isSelected()) {
						count++;

					}
					else if(!ul.isSelected()) {
						count--;
					}

					if(e.getStateChange() == ItemEvent.SELECTED){
						if(a < count){
							JOptionPane.showMessageDialog(null,"Limit crossed");
						}
						else {
							selected.add(ul.getName());
						}
					}
					if(e.getStateChange() == ItemEvent.DESELECTED){
						selected.remove(ul.getName());
					}
				}
			});
			ul.setName("ul"+i);
			upperleft.add(ul);
		}
		
		JPanel midleft = new JPanel();
		midleft.setLayout(null);
		midleft.setBounds(12, 182, 334, 132);
		mainpan.add(midleft);
		midleft.setLayout(new GridLayout(4, 14, 5, 5));
		for(int i=1;i<57;i++){
			JToggleButton ml = new JToggleButton();
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On", "root", "1234varun");
				Statement st = con.createStatement();
				String q = "select * from booked_seat where match_date='"+match_date+"' and stand_name='"+standname+"' and seat_no='ml"+i+"'";
				ResultSet rs = st.executeQuery(q);
				if(rs.next()){
					ml.setEnabled(false);
					ml.setBackground(Color.red);
				}
				else{
					ml.setBackground(Color.green);
				}
			}catch(Exception ex){System.out.println(ex);}
			ml.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(ml.isSelected()) {
						count++;

					}
					else if(!ml.isSelected()) {
						count--;
					}

					if(e.getStateChange() == ItemEvent.SELECTED){
						if(a < count){
							JOptionPane.showMessageDialog(null,"Limit crossed");
						}else {
							selected.add(ml.getName());
						}
					}
					if(e.getStateChange() == ItemEvent.DESELECTED){
						selected.remove(ml.getName());
					}
				}
			});
			ml.setName("ml"+i);
			midleft.add(ml);
		}

		JLabel matchlbl = new JLabel(match_name);
		matchlbl.setForeground(new Color(255, 255, 255));
		matchlbl.setHorizontalAlignment(SwingConstants.CENTER);
		matchlbl.setBackground(Color.WHITE);
		matchlbl.setFont(new Font("SansSerif", Font.BOLD, 30));
		matchlbl.setBounds(187, 13, 227, 33);
		getContentPane().add(matchlbl);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(12, 625, 958, 2);
		getContentPane().add(separator_1);
		
		pricelbl = new JLabel("Total Price = "+price);
		pricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		pricelbl.setForeground(new Color(255, 255, 255));
		pricelbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pricelbl.setBackground(Color.WHITE);
		pricelbl.setBounds(644, 640, 227, 30);
		getContentPane().add(pricelbl);
		
		JLabel standlbl = new JLabel(standname);
		standlbl.setForeground(new Color(255, 255, 255));
		standlbl.setHorizontalAlignment(SwingConstants.CENTER);
		standlbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		standlbl.setBackground(Color.WHITE);
		standlbl.setBounds(262, 65, 458, 45);
		getContentPane().add(standlbl);
		
		JButton backbtn = new JButton("Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SelectPrice s = new SelectPrice(match_name, match_date, userid);
				s.setVisible(true);
			}
		});
		backbtn.setFocusable(false);
		backbtn.setForeground(new Color(0, 0, 0));
		backbtn.setBackground(Color.ORANGE);
		backbtn.setFont(new Font("Verdana", Font.BOLD, 30));
		backbtn.setBounds(50, 705, 173, 45);
		getContentPane().add(backbtn);
		
		JLabel datelbl = new JLabel(match_date);
		datelbl.setForeground(new Color(255, 255, 255));
		datelbl.setHorizontalAlignment(SwingConstants.CENTER);
		datelbl.setFont(new Font("SansSerif", Font.BOLD, 30));
		datelbl.setBounds(601, 13, 193, 33);
		getContentPane().add(datelbl);

		setVisible(true);
	}
}
