package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddBirthRegInfo extends JFrame implements ActionListener {

    JTextField tfNID, tfRegistrationNumber, tfRegDate, tfCertificateIssueDate, tfWardNumber, tfRegisterNumber,tfPermanentAddress;
    JDateChooser dcRegistrationDate,dcCertificateIssueDate;
    JButton add, back;

    AddBirthRegInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Birth Registration Information");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        tfNID = new JTextField();
        tfNID.setBounds(220, 150, 150, 30);
        add(tfNID);

        JLabel labelRegistrationNumber = new JLabel("Registration Number");
        labelRegistrationNumber.setBounds(400, 150, 200, 30);
        labelRegistrationNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelRegistrationNumber);

        tfRegistrationNumber = new JTextField();
        tfRegistrationNumber.setBounds(600, 150, 150, 30);
        add(tfRegistrationNumber);

        JLabel labelRegDate = new JLabel("Registration Date");
        labelRegDate.setBounds(50, 200, 150, 30);
        labelRegDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelRegDate);

        dcRegistrationDate = new JDateChooser();
        dcRegistrationDate.setBounds(220, 200, 150, 30);
        add(dcRegistrationDate);

        JLabel labelCertificateIssueDate = new JLabel("Certificate Issue Date");
        labelCertificateIssueDate.setBounds(400, 200, 200, 30);
        labelCertificateIssueDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelCertificateIssueDate);

        dcCertificateIssueDate = new JDateChooser();
        dcCertificateIssueDate.setBounds(600, 200, 150, 30);
        add(dcCertificateIssueDate);

        JLabel labelWardNumber = new JLabel("Ward Number");
        labelWardNumber.setBounds(50, 250, 150, 30);
        labelWardNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelWardNumber);

        tfWardNumber = new JTextField();
        tfWardNumber.setBounds(220, 250, 150, 30);
        add(tfWardNumber);

        JLabel labelRegisterNumber = new JLabel("Register Number");
        labelRegisterNumber.setBounds(400, 250, 150, 30);
        labelRegisterNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelRegisterNumber);

        tfRegisterNumber = new JTextField();
        tfRegisterNumber.setBounds(600, 250, 150, 30);
        add(tfRegisterNumber);

        JLabel labelPermanentAddress = new JLabel("Permanent Address");
        labelPermanentAddress.setBounds(50, 300, 200, 30);
        labelPermanentAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPermanentAddress);

        tfPermanentAddress = new JTextField();
        tfPermanentAddress.setBounds(220, 300, 150, 30);
        add(tfPermanentAddress);

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
            String NID="NULL",RegistrationNumber="NULL",RegistrationDate="NULL",CertificateIssueDate="NULL",
                    WardNumber="NULL",RegisterNumber="NULL",PermanentAddress="NULL";
            NID = tfNID.getText();
            RegistrationNumber = tfRegistrationNumber.getText();
            RegistrationDate = ((JTextField) dcRegistrationDate.getDateEditor().getUiComponent()).getText();
            CertificateIssueDate = ((JTextField) dcCertificateIssueDate.getDateEditor().getUiComponent()).getText();
            WardNumber = tfWardNumber.getText();
            RegisterNumber = tfRegisterNumber.getText();
            PermanentAddress = tfPermanentAddress.getText();
            
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "insert into birthRegistration(NID,RegistrationNumber,RegistrationDate,CertificateIssueDate,WardNumber,RegisterNumber,PermanentAddress) values("+NID+"," + RegistrationNumber + ", '" + RegistrationDate + "', '" + CertificateIssueDate + "', " + WardNumber+ "," +RegisterNumber+",'"+PermanentAddress+"')";
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
        new AddBirthRegInfo();
    }
}
