package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddOnlinePresenceInfo extends JFrame implements ActionListener {

    JTextField tfNID, tfWebsiteName, tfUserID;
    JButton add, back;

    AddOnlinePresenceInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Online Presence Information");
        heading.setBounds(270, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        tfNID = new JTextField();
        tfNID.setBounds(150, 150, 150, 30);
        add(tfNID);

        JLabel labelWebsiteName = new JLabel("Website Name");
        labelWebsiteName.setBounds(450, 150, 200, 30);
        labelWebsiteName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelWebsiteName);

        tfWebsiteName = new JTextField();
        tfWebsiteName.setBounds(600, 150, 150, 30);
        add(tfWebsiteName);

        JLabel labelUserID = new JLabel("User ID");
        labelUserID.setBounds(50, 200, 150, 30);
        labelUserID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelUserID);
        
        tfUserID = new JTextField();
        tfUserID.setBounds(150, 200, 150, 30);
        add(tfUserID);

        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String NID = tfNID.getText();
            String WebsiteName = tfWebsiteName.getText();
            String UserID = tfUserID.getText();
            
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "insert into OnlinePresence(NID,WebsiteName,UserId) values("+NID+",'" + WebsiteName + "', '" + UserID + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new AddProfile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new AddProfile();
        }
    }

    public static void main(String[] args) {
        new AddOnlinePresenceInfo();
    }
}
