package citizenprofilemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(860, 520, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 860, 520);
        add(image);
        
        JLabel heading = new JLabel("Admin Login");
        heading.setBounds(200, 0, 500, 100);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("tahoma", Font.BOLD, 80));
        image.add(heading);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(200, 150, 300, 30);
        lblusername.setForeground(Color.BLACK);
        lblusername.setFont(new Font("", Font.BOLD, 30));
        image.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(400, 150, 300, 30);
        tfusername.setFont(new Font("", Font.PLAIN, 20));
        image.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(200, 200, 300, 30);
        lblpassword.setForeground(Color.BLACK);
        lblpassword.setFont(new Font("", Font.BOLD, 30));
        image.add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(400, 200, 300, 30);
        tfpassword.setFont(new Font("", Font.PLAIN, 20));
        image.add(tfpassword);
        
        JButton login = new JButton("Login");
        login.setBounds(400, 260, 150, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("", Font.BOLD, 30));
        login.addActionListener(this);
        image.add(login);
        

        
        setSize(860, 520);
        setLocation(450, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            if ((username.equals("sa")) && (password.equals("123456"))) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}