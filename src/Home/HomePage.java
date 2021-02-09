package Home;

import Login.LoginPage;
import com.sun.javafx.logging.JFRInputEvent;
import matches.upcoming_matches;
import mybookings.mybookings;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;

public class HomePage extends JFrame {
    JFrame jf = new JFrame();
    JLabel welcomelbl;
    public  HomePage(String username, String userid){
    	setTitle("Home Page");
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\LOGO.png"));
    	getContentPane().setBackground(new Color(0, 0, 51));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300,702);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        JPanel background = new JPanel();
        background.setBounds(0,0,1300,702);
        ImageIcon pic = new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\GAME ON\\src\\Stadiumblur.png");
        JLabel lb = new JLabel(pic);
        background.add(lb);
        getContentPane().add(background);

        JButton matchesbtn = new JButton("Upcoming Matches");
        matchesbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        matchesbtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 2), new LineBorder(new Color(0, 0, 51), 4)));
        matchesbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new upcoming_matches(userid);
        	}
        });
        matchesbtn.setBackground(new Color(255, 215, 0));
        matchesbtn.setForeground(new Color(0, 0, 0));
        matchesbtn.setFont(new Font("Verdana", Font.BOLD, 30));
        matchesbtn.setBounds(194, 565, 378, 58);
        matchesbtn.setFocusable(false);
        //getContentPane().add(matchesbtn);
        lb.add(matchesbtn);

        JButton bookingsbtn = new JButton("My Bookings");
        bookingsbtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 2), new LineBorder(new Color(0, 0, 51), 4)));
        bookingsbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bookingsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mybookings a = new mybookings(userid);
                a.setVisible(true);
            }
        });
        bookingsbtn.setBackground(new Color(255, 215, 0));
        bookingsbtn.setForeground(new Color(0, 0, 0));
        bookingsbtn.setFont(new Font("Verdana", Font.BOLD, 30));
        bookingsbtn.setBounds(737, 565, 378, 58);
        bookingsbtn.setFocusable(false);
        //getContentPane().add(bookingsbtn);
        lb.add(bookingsbtn);

        JLabel toplbl = new JLabel("TICKET BUDDY");
        toplbl.setForeground(new Color(255, 255, 255));
        toplbl.setOpaque(true);
        toplbl.setFont(new Font("Serif", Font.BOLD, 50));
        toplbl.setHorizontalAlignment(SwingConstants.CENTER);
        toplbl.setBackground(new Color(0, 0, 51));
        toplbl.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 4, true), new LineBorder(new Color(0, 0, 51), 4, true)));
        toplbl.setBounds(426, 26, 441, 95);
        //getContentPane().add(toplbl);
        lb.add(toplbl);
        
        welcomelbl = new JLabel("Welcome "+username);
        welcomelbl.setBorder(new LineBorder(new Color(255, 255, 255), 2));
        welcomelbl.setOpaque(true);
        welcomelbl.setForeground(new Color(255, 255, 255));
        welcomelbl.setBackground(new Color(0, 0, 51));
        welcomelbl.setFont(new Font("Dialog", Font.BOLD, 50));
        welcomelbl.setHorizontalAlignment(SwingConstants.CENTER);
        welcomelbl.setBounds(315, 313, 651, 89);
        //getContentPane().add(welcomelbl);
        lb.add(welcomelbl);

        this.setVisible(true);
    }
    public static void main (String[] args) {
        new LoginPage();
    }
}
