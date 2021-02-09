package SelectPrice;
import SelectSeat.SelectSeat;
import matches.upcoming_matches;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class SelectPrice extends JFrame implements ActionListener{
	
	JFrame fr = new JFrame();
	JRadioButton Rs5000;
	JRadioButton Rs2500;
	JRadioButton Rs1200;
	JRadioButton Rs800;
	JComboBox c5000;
	JComboBox c2500;
	JComboBox c1200;
	JComboBox c800;
	ButtonGroup btngrp;
	public int price;
	String standname;
	private JLabel matchlbl;
	private JLabel datelbl;
	String id;
	
	public SelectPrice(String match_name, String match_date,String userid) {
		getContentPane().setBackground(new Color(0, 0, 51));
		id = userid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1943,1044);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\LOGO.png"));
		this.setTitle("Select Price");
		this.getContentPane().setLayout(null);

		JPanel background = new JPanel();
		background.setBounds(0,0,1944,1050);
		ImageIcon pic = new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\stadiumxxblur.png");
		JLabel lb = new JLabel(pic);
		background.add(lb);
		getContentPane().add(background);
		
		JLabel Map = new JLabel("");
		Map.setHorizontalAlignment(SwingConstants.CENTER);
		Map.setIcon(new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\stadium_map.jpg"));
		Map.setBounds(627, 13, 670, 579);
		lb.add(Map);
		
		ButtonGroup grp = new ButtonGroup();
		
		Panel pricepanel = new Panel();
		pricepanel.setBackground(Color.WHITE);
		pricepanel.setBounds(595, 645, 734, 253);
		lb.add(pricepanel);
		pricepanel.setLayout(null);
		
		JLabel lbl = new JLabel("Select Price");
		lbl.setBounds(12, 0, 138, 30);
		pricepanel.add(lbl);
		lbl.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 24));
		
		Rs5000 = new JRadioButton("Rs. 5,000");
		Rs5000.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Rs5000.setBackground(Color.ORANGE);
		Rs5000.setForeground(Color.BLACK);
		Rs5000.setFont(new Font("Serif", Font.PLAIN, 27));
		Rs5000.setBounds(77, 39, 138, 37);
		pricepanel.add(Rs5000);
		Rs5000.addActionListener(this);
		Rs5000.setActionCommand("Rs5000");
		Rs5000.setFocusable(false);
		grp.add(Rs5000);
		
		c5000 = new JComboBox();
		c5000.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		c5000.setBackground(Color.WHITE);
		c5000.setForeground(Color.BLACK);
		c5000.setFont(new Font("Verdana", Font.PLAIN, 27));
		c5000.setBounds(308, 38, 365, 37);
		pricepanel.add(c5000);
		c5000.addItem("Sachin Tendulkar Stand");
		c5000.addItem("MCA Stand");
		c5000.setSelectedIndex(0);
		
		
		Rs2500 = new JRadioButton("Rs. 2,500");
		Rs2500.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Rs2500.setForeground(Color.BLACK);
		Rs2500.setBackground(Color.ORANGE);
		Rs2500.setFont(new Font("Serif", Font.PLAIN, 27));
		Rs2500.setBounds(77, 89, 138, 37);
		pricepanel.add(Rs2500);
		Rs2500.addActionListener(this);
		Rs2500.setActionCommand("Rs2500");
		Rs2500.setFocusable(false);
		grp.add(Rs2500);
		
		c2500 = new JComboBox();
		c2500.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		c2500.setFont(new Font("Verdana", Font.PLAIN, 27));
		c2500.setBounds(308, 88, 365, 36);
		pricepanel.add(c2500);
		c2500.addItem("Sunil Gavaskar Stand");
		c2500.addItem("Vijay Merchant Stand");
		c2500.setSelectedIndex(0);
		
		
		Rs1200 = new JRadioButton("Rs. 1,200");
		Rs1200.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Rs1200.setBackground(Color.ORANGE);
		Rs1200.setForeground(Color.BLACK);
		Rs1200.setFont(new Font("Serif", Font.PLAIN, 27));
		Rs1200.setBounds(77, 142, 138, 36);
		pricepanel.add(Rs1200);
		Rs1200.addActionListener(this);
		Rs1200.setActionCommand("Rs1200");
		Rs1200.setFocusable(false);
		grp.add(Rs1200);
		
		c1200 = new JComboBox();
		c1200.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		c1200.setFont(new Font("Verdana", Font.PLAIN, 27));
		c1200.setBounds(308, 141, 365, 36);
		pricepanel.add(c1200);
		c1200.addItem("Vitthal Devachi Stand");
		c1200.addItem("Garware Stand");
		c1200.setSelectedIndex(0);
		
		
		Rs800 = new JRadioButton("Rs. 800");
		Rs800.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Rs800.setForeground(Color.BLACK);
		Rs800.setBackground(Color.ORANGE);
		Rs800.setFont(new Font("Serif", Font.PLAIN, 27));
		Rs800.setBounds(77, 194, 138, 36);
		pricepanel.add(Rs800);
		Rs800.addActionListener(this);
		Rs800.setActionCommand("Rs800");
		Rs800.setFocusable(false);
		grp.add(Rs800);

		c800 = new JComboBox();
		c800.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		c800.setFont(new Font("Verdana", Font.PLAIN, 27));
		c800.setBounds(308, 193, 365, 36);
		pricepanel.add(c800);
		c800.addItem("Grand Stand");
		c800.addItem("North Stand");
		c800.setSelectedIndex(0);

		btngrp = new ButtonGroup();
		btngrp.add(Rs5000);
		btngrp.add(Rs2500);
		btngrp.add(Rs1200);
		btngrp.add(Rs800);

		JButton proceedbtn = new JButton("Proceed");
		proceedbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		proceedbtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 2, true), new LineBorder(new Color(0, 0, 51), 4)));
		proceedbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					price = Integer.parseInt(btngrp.getSelection().getActionCommand().substring(2));
					String str = btngrp.getSelection().getActionCommand();
					if (str.equals("Rs5000")) {
						standname = (String) c5000.getSelectedItem();
					} else if (str.equals("Rs2500")) {
						standname = (String) c2500.getSelectedItem();
					} else if (str.equals("Rs1200")) {
						standname = (String) c1200.getSelectedItem();
					} else if (str.equals("Rs800")) {
						standname = (String) c800.getSelectedItem();
					}
					//System.out.println(standname);
					dispose();
					SelectSeat s = new SelectSeat(price, standname, match_name, match_date, userid);
					s.setVisible(true);
				}catch(Exception ex){JOptionPane.showMessageDialog(null, "Please Select Price and Stand");};
			}
		});
		proceedbtn.setFocusable(false);
		proceedbtn.setForeground(new Color(0, 0, 0));
		proceedbtn.setBackground(new Color(255, 204, 0));
		proceedbtn.setFont(new Font("Serif", Font.PLAIN, 30));
		proceedbtn.setBounds(1131, 916, 191, 57);
		proceedbtn.addActionListener(this);
		lb.add(proceedbtn);
		
		JButton backbtn = new JButton("Back");
		backbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backbtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 2, true), new LineBorder(new Color(0, 0, 51), 4, true)));
		backbtn.setFocusable(false);
		backbtn.setBackground(new Color(255, 204, 0));
		backbtn.setForeground(new Color(0, 0, 0));
		backbtn.setFont(new Font("Serif", Font.PLAIN, 30));
		backbtn.setBounds(615, 916, 191, 57);
		backbtn.addActionListener(this);
		backbtn.setActionCommand("Back");
		lb.add(backbtn);
		
		matchlbl = new JLabel("Match : "+match_name);
		matchlbl.setBackground(new Color(0, 0, 51));
		matchlbl.setOpaque(true);
		matchlbl.setHorizontalAlignment(SwingConstants.CENTER);
		matchlbl.setForeground(new Color(255, 255, 255));
		matchlbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		matchlbl.setBounds(65, 78, 512, 57);
		lb.add(matchlbl);
		
		datelbl = new JLabel("Date : "+match_date);
		datelbl.setBackground(new Color(0, 0, 51));
		datelbl.setOpaque(true);
		datelbl.setHorizontalAlignment(SwingConstants.CENTER);
		datelbl.setForeground(new Color(255, 255, 255));
		datelbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		datelbl.setBounds(65, 148, 512, 57);
		lb.add(datelbl);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Rs5000") {
			c5000.setEnabled(true);
			c2500.setEnabled(false);
			c1200.setEnabled(false);
			c800.setEnabled(false);
		}
		else if(e.getActionCommand()=="Rs2500") {
			c5000.setEnabled(false);
			c2500.setEnabled(true);
			c1200.setEnabled(false);
			c800.setEnabled(false);
		}
		else if(e.getActionCommand()=="Rs1200") {
			c5000.setEnabled(false);
			c2500.setEnabled(false);
			c1200.setEnabled(true);
			c800.setEnabled(false);
		}
		else if(e.getActionCommand()=="Rs800") {
			c5000.setEnabled(false);
			c2500.setEnabled(false);
			c1200.setEnabled(false);
			c800.setEnabled(true);
		}
		
		if(e.getActionCommand() == "Back") {
			dispose();
			new upcoming_matches(id);
		}
	}
}
