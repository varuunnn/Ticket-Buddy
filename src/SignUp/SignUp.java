package SignUp;

import Home.HomePage;
import Login.LoginPage;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Cursor;

public class SignUp extends JFrame {
	private JTextField nametf;
	private JTextField usertf;
	private JTextField emailtf;
	private JTextField mobiletf;
	private JPasswordField passwordtf;
	JLabel name_valid;
	JLabel id_valid;
	JLabel email_valid;
	JLabel mobile_valid;
	JLabel password_valid;
	String username = "";
	String userid = "";

	public SignUp() {
		getContentPane().setBackground(new Color(0, 0, 51));
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\LOGO.png"));
		setTitle("Sign Up");
		setSize(683,510);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You can Register here...");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setBounds(131, 24, 403, 47);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(68, 79, 529, 2);
		getContentPane().add(separator);
		
		JLabel userlbl = new JLabel("User ID");
		userlbl.setForeground(new Color(255, 255, 255));
		userlbl.setFont(new Font("Serif", Font.PLAIN, 20));
		userlbl.setBounds(89, 145, 62, 28);
		getContentPane().add(userlbl);
		
		JLabel namelbl = new JLabel("Name");
		namelbl.setForeground(new Color(255, 255, 255));
		namelbl.setFont(new Font("Serif", Font.PLAIN, 20));
		namelbl.setBounds(89, 94, 83, 25);
		getContentPane().add(namelbl);
		
		JLabel passwordlbl = new JLabel("Password");
		passwordlbl.setForeground(new Color(255, 255, 255));
		passwordlbl.setFont(new Font("Serif", Font.PLAIN, 20));
		passwordlbl.setBounds(89, 314, 78, 28);
		getContentPane().add(passwordlbl);
		
		JLabel emaillbl = new JLabel("Email");
		emaillbl.setForeground(new Color(255, 255, 255));
		emaillbl.setFont(new Font("Serif", Font.PLAIN, 20));
		emaillbl.setBounds(89, 200, 47, 28);
		getContentPane().add(emaillbl);
		
		JLabel mobilelbl = new JLabel("Mobile No.");
		mobilelbl.setForeground(new Color(255, 255, 255));
		mobilelbl.setFont(new Font("Serif", Font.PLAIN, 20));
		mobilelbl.setBounds(89, 257, 92, 28);
		getContentPane().add(mobilelbl);

		name_valid = new JLabel("");
		name_valid.setForeground(Color.RED);
		name_valid.setFont(new Font("Tahoma", Font.ITALIC, 13));
		name_valid.setBounds(504, 94, 149, 25);
		getContentPane().add(name_valid);

		id_valid = new JLabel("");
		id_valid.setForeground(Color.RED);
		id_valid.setFont(new Font("Tahoma", Font.ITALIC, 13));
		id_valid.setBounds(504, 148, 149, 25);
		getContentPane().add(id_valid);

		email_valid = new JLabel("");
		email_valid.setForeground(Color.RED);
		email_valid.setFont(new Font("Tahoma", Font.ITALIC, 13));
		email_valid.setBounds(504, 203, 149, 25);
		getContentPane().add(email_valid);

		mobile_valid = new JLabel("");
		mobile_valid.setForeground(Color.RED);
		mobile_valid.setFont(new Font("Tahoma", Font.ITALIC, 13));
		mobile_valid.setBounds(504, 260, 149, 25);
		getContentPane().add(mobile_valid);

		password_valid = new JLabel("");
		password_valid.setForeground(Color.RED);
		password_valid.setFont(new Font("Tahoma", Font.ITALIC, 13));
		password_valid.setBounds(504, 317, 149, 25);
		getContentPane().add(password_valid);
		
		nametf = new JTextField();
		nametf.setForeground(Color.BLACK);
		nametf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String PATTERN = "^[a-zA-Z]{2,30}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(nametf.getText());
				if(!match.matches()) {
					name_valid.setText("Invalid Input");
				}
				else {name_valid.setText("");}
			}
		});
		nametf.setFont(new Font("Dialog", Font.PLAIN, 20));
		nametf.setBounds(292, 94, 200, 28);
		getContentPane().add(nametf);
		nametf.setColumns(10);
		
		usertf = new JTextField();
		usertf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String PATTERN = "^[a-zA-Z0-9_]{6,10}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(usertf.getText());
				if(!match.matches()) {
					id_valid.setText("Invalid Input");
				}
				else {id_valid.setText("");}
			}
		});
		usertf.setForeground(Color.BLACK);
		usertf.setFont(new Font("Dialog", Font.PLAIN, 20));
		usertf.setBounds(292, 145, 200, 28);
		getContentPane().add(usertf);
		usertf.setColumns(10);
		
		emailtf = new JTextField();
		emailtf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9_.]{3,30}@[a-zA-Z]{1,10}.com$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(emailtf.getText());
				if(!match.matches()) {
					email_valid.setText("Invalid Input");
				}
				else {email_valid.setText("");}
			}
		});
		emailtf.setFont(new Font("Dialog", Font.PLAIN, 20));
		emailtf.setBounds(292, 203, 200, 28);
		getContentPane().add(emailtf);
		emailtf.setColumns(10);
		
		mobiletf = new JTextField();
		mobiletf.setFont(new Font("Dialog", Font.PLAIN, 20));
		mobiletf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[0-9]{10}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(mobiletf.getText());
				if(!match.matches()) {
					mobile_valid.setText("Invalid Input");
				}
				else {mobile_valid.setText("");}
			}
		});
		mobiletf.setBounds(292, 260, 200, 28);
		getContentPane().add(mobiletf);
		mobiletf.setColumns(10);
		
		passwordtf = new JPasswordField();
		passwordtf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9]{6,12}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(passwordtf.getText());
				if(!match.matches()) {
					password_valid.setText("Invalid Input");
				}
				else {password_valid.setText("");}
			}
		});
		passwordtf.setFont(new Font("Dialog", Font.PLAIN, 20));
		passwordtf.setBounds(292, 317, 200, 28);
		getContentPane().add(passwordtf);

		JButton signupbtn = new JButton("");
		signupbtn.setContentAreaFilled(false);
		signupbtn.setFocusPainted(false);
		signupbtn.setBorderPainted(false);
		signupbtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\button_sign-up.png"));
		signupbtn.setOpaque(false);
		signupbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signupbtn.setBackground(new Color(255, 215, 0));
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if((name_valid.getText().isEmpty() && !nametf.getText().isEmpty()) && (id_valid.getText().isEmpty() && !usertf.getText().isEmpty()) && (email_valid.getText().isEmpty() && !emailtf.getText().isEmpty()) && (mobile_valid.getText().isEmpty() && !mobiletf.getText().isEmpty()) && (password_valid.getText().isEmpty() && !passwordtf.getText().isEmpty())){
						//Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Game_On", "root", "1234varun");
						String isavailable = "select user_id,email,user_password from User where (user_id='"+ usertf.getText() +"' or email='"+ emailtf.getText() +"' or user_password='"+ passwordtf.getText() +"');";
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(isavailable);
						if(!rs.next()) {
							String query = "insert into User values (?,?,?,?,?)";
							PreparedStatement pst = con.prepareStatement(query);
							pst.setString(1, nametf.getText());
							pst.setString(2, usertf.getText());
							pst.setString(3, emailtf.getText());
							pst.setString(4, mobiletf.getText());
							pst.setString(5, passwordtf.getText());
							int count = pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Registration Successful");
							pst.close();
							st.close();
							con.close();
							userid = usertf.getText();
							username = nametf.getText();
							dispose();
							LoginPage l = new LoginPage();
							l.setVisible(true);
							//HomePage h = new HomePage(username, userid);

						}
						else{
							JOptionPane.showMessageDialog(null,"Account already exists","Registration Error",JOptionPane.ERROR_MESSAGE);
							nametf.setText("");
							usertf.setText("");
							emailtf.setText("");
							mobiletf.setText("");
							passwordtf.setText("");
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"All fields must be filled","Registration Error",JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception ex) {System.out.print(ex);}
			}
		});
		signupbtn.setFocusable(false);
		signupbtn.setFont(new Font("Tahoma", Font.BOLD, 27));
		signupbtn.setBounds(236, 379, 164, 60);
		getContentPane().add(signupbtn);

		setLocationRelativeTo(null);
		setVisible(true);
		
	}

}
