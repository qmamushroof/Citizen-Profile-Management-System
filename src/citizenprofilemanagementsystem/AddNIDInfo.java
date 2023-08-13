package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddNIDInfo extends JFrame implements ActionListener {

    JTextField tfNID, tfFathersName, tfMothersName, tfCityOfBirth, tfPresentAddress;
    JButton add, back;

    AddNIDInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add NID Information");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        tfNID = new JTextField();
        tfNID.setBounds(220, 150, 150, 30);
        add(tfNID);

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
            String FathersName = tfFathersName.getText();
            String MothersName = tfMothersName.getText();
            String CityOfBirth = tfCityOfBirth.getText();
            String PresentAddress = tfPresentAddress.getText();
            
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "insert into nationalIdCard(NID,FathersName,MothersName,CityOfBirth,PresentAddress,NID_person) values("+NID+",'" + FathersName + "', '" + MothersName + "', '" + CityOfBirth + "', '" + PresentAddress+"',"+NID+")";
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
        new AddNIDInfo();
    }
}
