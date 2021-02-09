package Stadiums;

import SelectPrice.SelectPrice;
import matches.upcoming_matches;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class stadium extends JFrame {

	private JPanel contentPane;


	public stadium(String match_name, String match_date, String userid) {
		setTitle("Match");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\LOGO.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel toplbl = new JLabel(match_name);
		toplbl.setForeground(new Color(255, 255, 255));
		toplbl.setBackground(Color.WHITE);
		toplbl.setBounds(33, 9, 278, 42);
		toplbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(toplbl);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\"+match_name+".jpeg"));
		lblNewLabel_1.setBounds(157, 64, 345, 168);
		contentPane.add(lblNewLabel_1);
		
		JButton bookbtn = new JButton("");
		bookbtn.setBorderPainted(false);
		bookbtn.setBorder(null);
		bookbtn.setContentAreaFilled(false);
		bookbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bookbtn.setOpaque(false);
		bookbtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\button_book.png"));
		bookbtn.setFocusable(false);
		bookbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SelectPrice s=new SelectPrice(match_name,match_date,userid);
				s.setVisible(true);
			}
		});
		bookbtn.setForeground(Color.WHITE);
		bookbtn.setFont(new Font("Tahoma", Font.BOLD, 21));
		bookbtn.setBackground(Color.BLUE);
		bookbtn.setBounds(459, 321, 148, 49);
		contentPane.add(bookbtn);
		
		JLabel lblNewLabel_1_1 = new JLabel("IF YOU WANT TO BOOK THE TICKET \r\n\r\n");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1_1.setBounds(39, 230, 612, 43);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("HIT THE BOOK BUTTON ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_2.setBounds(135, 264, 389, 37);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 53, 607, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(40, 311, 604, 14);
		contentPane.add(separator_1);
		
		JButton backbtn = new JButton("");
		backbtn.setContentAreaFilled(false);
		backbtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\button_back.png"));
		backbtn.setOpaque(false);
		backbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backbtn.setBorderPainted(false);
		backbtn.setBorder(null);
		backbtn.setFocusable(false);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				upcoming_matches a = new upcoming_matches(userid);
			}
		});
		backbtn.setForeground(Color.WHITE);
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 21));
		backbtn.setBackground(new Color(0, 0, 51));
		backbtn.setBounds(33, 321, 136, 49);
		contentPane.add(backbtn);
		
		JLabel datelbl = new JLabel("Date : "+match_date);
		datelbl.setForeground(new Color(255, 255, 255));
		datelbl.setBackground(Color.WHITE);
		datelbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		datelbl.setBounds(400, 9, 225, 42);
		contentPane.add(datelbl);
	}
}
