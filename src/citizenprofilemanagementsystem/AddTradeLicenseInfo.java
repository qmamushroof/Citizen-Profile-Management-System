
package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddTradeLicenseInfo extends JFrame implements ActionListener {

    JTextField tfNID, tfLicenseNumber, tfBusinessType, tfIssuingAuthority,tfOrganizationName,tfOrganizationAddress;
    JDateChooser dcExpiryDate,dcRenewalDate;
    JButton add, back;

    AddTradeLicenseInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Trade License Information");
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
        tfLicenseNumber.setBounds(650, 150, 150, 30);
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
        dcRenewalDate.setBounds(650, 200, 150, 30);
        add(dcRenewalDate);

        JLabel labelBusinessType = new JLabel("Business Type");
        labelBusinessType.setBounds(50, 250, 150, 30);
        labelBusinessType.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelBusinessType);

        tfBusinessType = new JTextField();
        tfBusinessType.setBounds(230, 250, 150, 30);
        add(tfBusinessType);

        JLabel labelIssuingAuthority = new JLabel("Issuing Authority");
        labelIssuingAuthority.setBounds(450, 250, 150, 30);
        labelIssuingAuthority.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelIssuingAuthority);

        tfIssuingAuthority = new JTextField();
        tfIssuingAuthority.setBounds(650, 250, 150, 30);
        add(tfIssuingAuthority);
        
        JLabel labelOrganizationName = new JLabel("Organization Name");
        labelOrganizationName.setBounds(50, 300, 200, 30);
        labelOrganizationName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelOrganizationName);

        tfOrganizationName = new JTextField();
        tfOrganizationName.setBounds(230, 300, 150, 30);
        add(tfOrganizationName);

        JLabel labelOrganizationAddress = new JLabel("Organization Address");
        labelOrganizationAddress.setBounds(450, 300, 200, 30);
        labelOrganizationAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelOrganizationAddress);

        tfOrganizationAddress = new JTextField();
        tfOrganizationAddress.setBounds(650, 300, 150, 30);
        add(tfOrganizationAddress);

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
            String BusinessType = tfBusinessType.getText();
            String IssuingAuthority = tfIssuingAuthority.getText();
            String OrganizationName = tfOrganizationName.getText();
            String OrganizationAddress = tfOrganizationAddress.getText();
           
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "insert into tradeLicense(NID,LicenseNumber,ExpiryDate,RenewalDate,BusinessType,IssuingAuthority,OrganizationName,OrganizationAddress) values("+NID+"," + LicenseNumber + ", '" + ExpiryDate + "', '" + RenewalDate + "', '" + BusinessType+ "','" +IssuingAuthority+"','"+OrganizationName+"','"+OrganizationAddress+"')";
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
        new AddTradeLicenseInfo();
    }
}
