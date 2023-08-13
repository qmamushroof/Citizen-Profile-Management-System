package citizenprofilemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton view, add, update, remove, logout;
    
    Home() {
       
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading = new JLabel("Main Menu");
        heading.setBounds(780, 20, 500, 50);
        heading.setFont(new Font("tahoma", Font.BOLD, 50));
        image.add(heading);
        
        add = new JButton("Add Profile");
        add.setBounds(800, 100, 250, 50);
        add.setFont(new Font("", Font.BOLD, 20));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View profiles");
        view.setBounds(800, 160, 250, 50);
        view.setFont(new Font("", Font.BOLD, 20));
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update profile");
        update.setBounds(800, 220, 250, 50);
        update.setFont(new Font("", Font.BOLD, 20));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove profile");
        remove.setBounds(800, 280, 250, 50);
        remove.setFont(new Font("", Font.BOLD, 20));
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        image.add(remove);
        
        logout = new JButton("Logout");
        logout.setBounds(800, 500, 250, 50);
        logout.setFont(new Font("", Font.BOLD, 20));
        logout.setBackground(Color.RED);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        image.add(logout);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddProfile();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewProfile();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateProfile();
        }    
          else if (ae.getSource() == logout) {
            setVisible(false);
            new Login();  
        } else {
            setVisible(false);
            new RemoveProfile();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
