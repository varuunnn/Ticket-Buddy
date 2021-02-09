package Login;
import Admin.AdminPage;
import Home.HomePage;
import SignUp.SignUp;
import matches.upcoming_matches;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginPage extends JFrame {
    String type;
	private JTextField unametf;
	private JPasswordField passtf;
	String username = "";
	String userid = "";
    public LoginPage()
    {
    	getContentPane().setBackground(new Color(0, 0, 51));
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\LOGO.png"));
    	setTitle("Login Page");
        getContentPane().setLayout(null);
        
        JLabel toplbl = new JLabel("You can Login here...");
        toplbl.setBackground(Color.WHITE);
        toplbl.setForeground(new Color(255, 255, 255));
        toplbl.setHorizontalAlignment(SwingConstants.CENTER);
        toplbl.setFont(new Font("Verdana", Font.BOLD, 30));
        toplbl.setBounds(95, 24, 391, 38);
        getContentPane().add(toplbl);
        
        JLabel unamelbl = new JLabel("User ID");
        unamelbl.setForeground(new Color(255, 255, 255));
        unamelbl.setHorizontalAlignment(SwingConstants.CENTER);
        unamelbl.setFont(new Font("Serif", Font.PLAIN, 20));
        unamelbl.setBounds(144, 98, 78, 31);
        getContentPane().add(unamelbl);
        
        JLabel passlbl = new JLabel("Password");
        passlbl.setForeground(new Color(255, 255, 255));
        passlbl.setHorizontalAlignment(SwingConstants.CENTER);
        passlbl.setFont(new Font("Serif", Font.PLAIN, 20));
        passlbl.setBounds(144, 154, 78, 31);
        getContentPane().add(passlbl);
        
        unametf = new JTextField();
        unametf.setFont(new Font("Dialog", Font.PLAIN, 20));
        unametf.setBounds(289, 102, 165, 29);
        getContentPane().add(unametf);
        unametf.setColumns(10);
        
        passtf = new JPasswordField();
        passtf.setFont(new Font("Dialog", Font.PLAIN, 20));
        passtf.setBounds(289, 157, 165, 31);
        getContentPane().add(passtf);
        
        JLabel utypelbl = new JLabel("User Type");
        utypelbl.setForeground(new Color(255, 255, 255));
        utypelbl.setFont(new Font("Serif", Font.PLAIN, 20));
        utypelbl.setHorizontalAlignment(SwingConstants.CENTER);
        utypelbl.setBounds(144, 238, 82, 29);
        getContentPane().add(utypelbl);
        
        JComboBox typecbox = new JComboBox();
        typecbox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typecbox.setBackground(new Color(255, 255, 255));
        typecbox.setForeground(new Color(0, 0, 0));
        typecbox.setFocusable(false);
        typecbox.setModel(new DefaultComboBoxModel(new String[] {"User", "Admin"}));
        typecbox.setFont(new Font("Serif", Font.PLAIN, 20));
        typecbox.setBounds(289, 238, 165, 28);
        getContentPane().add(typecbox);
        
        JButton loginbtn = new JButton("");
        loginbtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\button_login.png"));
        loginbtn.setContentAreaFilled(false);
        loginbtn.setFocusPainted(false);
        loginbtn.setBorderPainted(false);
        loginbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginbtn.setForeground(new Color(0, 0, 0));
        loginbtn.setBackground(new Color(255, 215, 0));
        loginbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        		    if(unametf.getText().isEmpty() && passtf.getText().isEmpty()){
        		        JOptionPane.showMessageDialog(null,"All fields must be filled","Login Error",JOptionPane.ERROR_MESSAGE);
                    }
        			//Class.forName("com.mysql.jdbc.Driver");
        			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On","root","1234varun");
        			Statement st = con.createStatement();
        			if("User".equals(typecbox.getSelectedItem())) {
                        String query = "select * from user where user_id = '" + unametf.getText() + "'";
                        ResultSet rs = st.executeQuery(query);
                        if (rs.next()) {
                            if (passtf.getText().equals(rs.getString("user_password"))) {
                                unametf.setText("");
                                passtf.setText("");
                                username = rs.getString("name");
                                userid = rs.getString("user_id");
                                dispose();
                                JOptionPane.showMessageDialog(null, "Login Successful as " + typecbox.getSelectedItem());
                                new HomePage(username, userid);
                            } else {
                                JOptionPane.showMessageDialog(null, "Incorrect Password", "Login Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, typecbox.getSelectedItem() + " not found", "Login Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
        			else if("Admin".equals(typecbox.getSelectedItem())){
                        String query = "select * from admin where admin_id = '" + unametf.getText() + "'";
                        ResultSet rs = st.executeQuery(query);
                        if (rs.next()) {
                            if (passtf.getText().equals(rs.getString("admin_pass"))) {
                                unametf.setText("");
                                passtf.setText("");
                                dispose();
                                JOptionPane.showMessageDialog(null, "Login Successful as " + typecbox.getSelectedItem());
                                //new HomePage(username, userid);
                                AdminPage a = new AdminPage();
                            } else {
                                JOptionPane.showMessageDialog(null, "Incorrect Password", "Login Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, typecbox.getSelectedItem() + " not found", "Login Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
        			st.close();
        			con.close();
        		}catch(Exception ex) {System.out.print(ex);}
        	}
        });
        loginbtn.setFocusable(false);
        loginbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        loginbtn.setBounds(331, 328, 167, 49);
        getContentPane().add(loginbtn);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(91, 75, 400, 2);
        getContentPane().add(separator);
        
        JButton signupbtn = new JButton("");
        signupbtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\button_sign-up.png"));
        signupbtn.setContentAreaFilled(false);
        signupbtn.setFocusPainted(false);
        signupbtn.setBorderPainted(false);
        signupbtn.setForeground(new Color(0, 0, 0));
        signupbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signupbtn.setBackground(new Color(255, 215, 0));
        signupbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    dispose();
                SignUp s = new SignUp();
                s.setVisible(true);
        	}
        });
        signupbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        signupbtn.setBounds(82, 328, 167, 49);
        signupbtn.setFocusable(false);
        getContentPane().add(signupbtn);
        
        JLabel newlbl = new JLabel("New User?");
        newlbl.setHorizontalAlignment(SwingConstants.CENTER);
        newlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        newlbl.setForeground(new Color(0, 102, 153));
        newlbl.setBounds(123, 304, 82, 23);
        getContentPane().add(newlbl);
        setSize(600,450);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}