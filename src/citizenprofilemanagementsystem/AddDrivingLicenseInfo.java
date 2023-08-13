package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddDrivingLicenseInfo extends JFrame implements ActionListener {

    JTextField tfNID, tfLicenseNumber, tfVehicleType, tfIssuingAuthority;
    JDateChooser dcExpiryDate,dcRenewalDate;
    JButton add, back;

    AddDrivingLicenseInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Driving License Information");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        tfNID = new JTextField();
        tfNID.setBounds(230, 150, 150, 30);
        add(tfNID);

        JLabel labelLicenseNumber = new JLabel("License Number");
        labelLicenseNumber.setBounds(450, 150, 200, 30);
        labelLicenseNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelLicenseNumber);

        tfLicenseNumber = new JTextField();
        tfLicenseNumber.setBounds(600, 150, 150, 30);
        add(tfLicenseNumber);

        JLabel labelExpiryDate = new JLabel("Expiry Date");
        labelExpiryDate.setBounds(50, 200, 150, 30);
        labelExpiryDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelExpiryDate);

        dcExpiryDate = new JDateChooser();
        dcExpiryDate.setBounds(230, 200, 150, 30);
        add(dcExpiryDate);

        JLabel labelRenewalDate = new JLabel("Renewal Date");
        labelRenewalDate.setBounds(450, 200, 200, 30);
        labelRenewalDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelRenewalDate);

        dcRenewalDate = new JDateChooser();
        dcRenewalDate.setBounds(600, 200, 150, 30);
        add(dcRenewalDate);

        JLabel labelVehicleType = new JLabel("Vehicle Type");
        labelVehicleType.setBounds(50, 250, 150, 30);
        labelVehicleType.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelVehicleType);

        tfVehicleType = new JTextField();
        tfVehicleType.setBounds(230, 250, 150, 30);
        add(tfVehicleType);

        JLabel labelIssuingAuthority = new JLabel("Issuing Authority");
        labelIssuingAuthority.setBounds(450, 250, 150, 30);
        labelIssuingAuthority.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelIssuingAuthority);

        tfIssuingAuthority = new JTextField();
        tfIssuingAuthority.setBounds(600, 250, 150, 30);
        add(tfIssuingAuthority);

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
            String LicenseNumber = tfLicenseNumber.getText();
            String ExpiryDate = ((JTextField) dcExpiryDate.getDateEditor().getUiComponent()).getText();
            String RenewalDate = ((JTextField) dcRenewalDate.getDateEditor().getUiComponent()).getText();
            String VehicleType = tfVehicleType.getText();
            String IssuingAuthority = tfIssuingAuthority.getText();
           
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "insert into drivingLicense(NID,LicenseNumber,ExpiryDate,RenewalDate,VehicleType,IssuingAuthority) values("+NID+"," + LicenseNumber + ", '" + ExpiryDate + "', '" + RenewalDate + "', '" + VehicleType+ "','" +IssuingAuthority+"')";
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
        new AddDrivingLicenseInfo();
    }
}
