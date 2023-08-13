package citizenprofilemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveProfile extends JFrame implements ActionListener {
    
    Choice cNID;
    JButton delete, back;
    
    RemoveProfile() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.jpg"));
        Image i2 = i1.getImage().getScaledInstance(842, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 842, 600);
        add(image);
        
        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 50, 100, 30);
        labelNID.setFont(new Font("serif", Font.BOLD, 30));
        labelNID.setForeground(Color.WHITE);
        image.add(labelNID);
        
        cNID = new Choice();
        cNID.setBounds(200, 50, 150, 30);
        cNID.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(cNID);
        
        try {
            ConnectMSSQL c = new ConnectMSSQL();
            String query = "select * from person";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cNID.add(rs.getString("NID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 250, 50);
        labelname.setFont(new Font("serif", Font.BOLD, 30));
        labelname.setForeground(Color.WHITE);
        image.add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(300, 100, 500, 50);
        lblname.setFont(new Font("serif", Font.PLAIN, 30));
        lblname.setForeground(Color.WHITE);
        image.add(lblname);
        
        JLabel labelMobileNumber = new JLabel("Mobile Number");
        labelMobileNumber.setBounds(50, 150, 250, 50);
        labelMobileNumber.setFont(new Font("serif", Font.BOLD, 30));
        labelMobileNumber.setForeground(Color.WHITE);
        image.add(labelMobileNumber);
        
        JLabel lblMobileNumber = new JLabel();
        lblMobileNumber.setBounds(300, 150, 500, 50);
        lblMobileNumber.setFont(new Font("serif", Font.PLAIN, 30));
        lblMobileNumber.setForeground(Color.WHITE);
        image.add(lblMobileNumber);
        
        JLabel labelemail = new JLabel("Email ID");
        labelemail.setBounds(50, 200, 250, 50);
        labelemail.setForeground(Color.WHITE);
        labelemail.setFont(new Font("serif", Font.BOLD, 30));
        image.add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(300, 200, 500, 50);
        lblemail.setFont(new Font("serif", Font.PLAIN, 30));
        lblemail.setForeground(Color.WHITE);
        image.add(lblemail);
        
        try {
            ConnectMSSQL c = new ConnectMSSQL();
            String query = "select * from person where NID = '"+cNID.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblMobileNumber.setText(rs.getString("MobileNumber"));
                lblemail.setText(rs.getString("EmailId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cNID.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    ConnectMSSQL c = new ConnectMSSQL();
                    String query = "select * from person where NID = "+cNID.getSelectedItem();
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblMobileNumber.setText(rs.getString("MobileNumber"));
                        lblemail.setText(rs.getString("EmailId"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(50, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        image.add(delete);
        
        back = new JButton("Back");
        back.setBounds(300, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
                
        setSize(842, 600);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "delete from birthRegistration where NID = '"+cNID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                query = "delete from nationalIdCard where NID = '"+cNID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                query = "delete from passport where NID = '"+cNID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                query = "delete from WorkHistory where NID = '"+cNID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                query = "delete from PermanentAddress where NID = '"+cNID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                query = "delete from OnlinePresence where NID = '"+cNID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                query = "delete from EducationalQualifications where NID = '"+cNID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                query = "delete from drivingLicense where NID = '"+cNID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                query = "delete from tradeLicense where NID = '"+cNID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                query = "delete from person where NID = '"+cNID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveProfile();
    }
}
