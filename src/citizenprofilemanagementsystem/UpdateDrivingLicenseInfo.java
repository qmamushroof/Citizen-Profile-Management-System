package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateDrivingLicenseInfo extends JFrame implements ActionListener {

    JTextField tfNID, tfLicenseNumber, tfVehicleType, tfIssuingAuthority;
    JDateChooser dcExpiryDate,dcRenewalDate;
    
    JLabel lblNID;
    JButton update, back;
    String NID;
        
    UpdateDrivingLicenseInfo(String NID) {
        this.NID = NID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Driving License Information");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        lblNID = new JLabel();
        lblNID.setBounds(230, 150, 150, 30);
        add(lblNID);

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
            String query = "select * from drivingLicense where NID = " + NID;
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblNID.setText(rs.getString("NID"));
                tfLicenseNumber.setText(rs.getString("LicenseNumber"));
                tfVehicleType.setText(rs.getString("VehicleType"));
                tfIssuingAuthority.setText(rs.getString("IssuingAuthority"));
                dcExpiryDate.setDate(rs.getDate("ExpiryDate"));
                dcRenewalDate.setDate(rs.getDate("RenewalDate"));
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
            String LicenseNumber = tfLicenseNumber.getText();
            String ExpiryDate = ((JTextField) dcExpiryDate.getDateEditor().getUiComponent()).getText();
            String RenewalDate = ((JTextField) dcRenewalDate.getDateEditor().getUiComponent()).getText();
            String VehicleType = tfVehicleType.getText();
            String IssuingAuthority = tfIssuingAuthority.getText();
           
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "update drivingLicense set LicenseNumber = " + LicenseNumber + ", ExpiryDate = '" + ExpiryDate + "', RenewalDate = '" + RenewalDate + "', VehicleType = '" + VehicleType + "', IssuingAuthority =  '" + IssuingAuthority+ "' where NID = " + NID;

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new ViewProfile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewDrivingLicenseInfo();
        }
    }

    public static void main(String[] args) {
        new UpdateDrivingLicenseInfo("");
    }
}
