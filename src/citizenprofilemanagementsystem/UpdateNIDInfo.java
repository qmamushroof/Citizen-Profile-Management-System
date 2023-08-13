package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateNIDInfo extends JFrame implements ActionListener {

    JTextField tfNID, tfFathersName, tfMothersName, tfCityOfBirth, tfPresentAddress;
    
    JLabel lblNID;
    JButton update, back;
    String NID;

    UpdateNIDInfo(String NID) {
        this.NID=NID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update NID Information");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        lblNID = new JLabel();
        lblNID.setBounds(220, 150, 150, 30);
        add(lblNID);

        JLabel labelFathersName = new JLabel("Father's Name");
        labelFathersName.setBounds(400, 150, 200, 30);
        labelFathersName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelFathersName);

        tfFathersName = new JTextField();
        tfFathersName.setBounds(600, 150, 150, 30);
        add(tfFathersName);

        JLabel labelMothersName = new JLabel("Mother's Name");
        labelMothersName.setBounds(50, 200, 150, 30);
        labelMothersName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelMothersName);

        tfMothersName = new JTextField();
        tfMothersName.setBounds(220, 200, 150, 30);
        add(tfMothersName);

        JLabel labelCityOfBirth = new JLabel("City Of Birth");
        labelCityOfBirth.setBounds(400, 200, 200, 30);
        labelCityOfBirth.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelCityOfBirth);

        tfCityOfBirth = new JTextField();
        tfCityOfBirth.setBounds(600, 200, 150, 30);
        add(tfCityOfBirth);

        JLabel labelPresentAddress = new JLabel("Present Address");
        labelPresentAddress.setBounds(50, 250, 150, 30);
        labelPresentAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPresentAddress);

        tfPresentAddress = new JTextField();
        tfPresentAddress.setBounds(220, 250, 150, 30);
        add(tfPresentAddress);

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
            String query = "select * from nationalIdCard where NID = " + NID;
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblNID.setText(rs.getString("NID"));
                tfFathersName.setText(rs.getString("FathersName"));
                tfMothersName.setText(rs.getString("MothersName"));
                tfCityOfBirth.setText(rs.getString("CityOfBirth"));                
                tfPresentAddress.setText(rs.getString("PresentAddress"));
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
            String FathersName = tfFathersName.getText();
            String MothersName = tfMothersName.getText();
            String CityOfBirth = tfCityOfBirth.getText();
            String PresentAddress = tfPresentAddress.getText();
            
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "update nationalIdCard set FathersName = '" + FathersName + "', MothersName = '" + MothersName + "', CityOfBirth = '" + CityOfBirth + "', PresentAddress = '" + PresentAddress +"'where NID = " + NID;

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new ViewProfile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewNIDInfo();
        }
    }

    public static void main(String[] args) {
        new UpdateNIDInfo("");
    }
}
