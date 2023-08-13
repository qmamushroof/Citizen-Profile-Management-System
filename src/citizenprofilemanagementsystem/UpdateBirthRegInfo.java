package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateBirthRegInfo extends JFrame implements ActionListener {

    JTextField tfNID, tfRegistrationNumber, tfRegDate, tfCertificateIssueDate, tfWardNumber, tfRegisterNumber, tfPermanentAddress;
    JDateChooser dcRegistrationDate, dcCertificateIssueDate;

    JLabel lblNID;
    JButton update, back;
    String NID;

    UpdateBirthRegInfo(String NID) {
        this.NID = NID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Birth Registration Information");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        lblNID = new JLabel();
        lblNID.setBounds(220, 150, 150, 30);
        add(lblNID);

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
            String query = "select * from birthRegistration where NID = " + NID;
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblNID.setText(rs.getString("NID"));
                tfRegistrationNumber.setText(rs.getString("RegistrationNumber"));
                tfWardNumber.setText(rs.getString("WardNumber"));
                tfRegisterNumber.setText(rs.getString("RegisterNumber"));
                tfPermanentAddress.setText(rs.getString("PermanentAddress"));
                dcRegistrationDate.setDate(rs.getDate("RegistrationDate"));
                dcCertificateIssueDate.setDate(rs.getDate("CertificateIssueDate"));
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
            String RegistrationNumber = tfRegistrationNumber.getText();
            String RegistrationDate = ((JTextField) dcRegistrationDate.getDateEditor().getUiComponent()).getText();
            String CertificateIssueDate = ((JTextField) dcCertificateIssueDate.getDateEditor().getUiComponent()).getText();
            String WardNumber = tfWardNumber.getText();
            String RegisterNumber = tfRegisterNumber.getText();
            String PermanentAddress = tfPermanentAddress.getText();

            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "update birthRegistration set RegistrationNumber = " + RegistrationNumber + ", RegistrationDate = '" + RegistrationDate + "', CertificateIssueDate = '" + CertificateIssueDate + "', WardNumber = " + WardNumber + ", RegisterNumber =  " + RegisterNumber + ",PermanentAddress='" + PermanentAddress + "'where NID = " + NID;

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new ViewProfile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewBirthRegInfo();
        }
    }

    public static void main(String[] args) {
        new UpdateBirthRegInfo("");
    }
}
