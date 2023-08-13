package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateOnlinePresenceInfo extends JFrame implements ActionListener {

    JTextField tfNID, tfWebsiteName, tfUserId;
    
    JLabel lblNID;
    JButton update, back;
    String NID;

    UpdateOnlinePresenceInfo(String NID) {
        this.NID=NID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Online Presence Information");
        heading.setBounds(270, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        lblNID = new JLabel();
        lblNID.setBounds(150, 150, 150, 30);
        add(lblNID);

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
        
        tfUserId = new JTextField();
        tfUserId.setBounds(150, 200, 150, 30);
        add(tfUserId);

        update = new JButton("Update Details");
        update.setBounds(250, 550, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        //Fetch values to textfields:
        try {
            ConnectMSSQL c = new ConnectMSSQL();
            String query = "select * from OnlinePresence where NID = " + NID;
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblNID.setText(rs.getString("NID"));
                tfWebsiteName.setText(rs.getString("WebsiteName"));
                tfUserId.setText(rs.getString("tfUserId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String WebsiteName = tfWebsiteName.getText();
            String UserId = tfUserId.getText();
            
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "update OnlinePresence set WebsiteName = '" + WebsiteName + "', UserId = '" + UserId+"'where NID = " + NID;

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new ViewProfile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewOnlinePresenceInfo();
        }
    }

    public static void main(String[] args) {
        new UpdateOnlinePresenceInfo("");
    }
}
