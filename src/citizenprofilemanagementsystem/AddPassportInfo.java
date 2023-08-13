
package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddPassportInfo extends JFrame implements ActionListener {

    JTextField tfNID, tfPassportNumber, tfPassportType, tfCountryCode,tfPreviousPassportNumber;
    JDateChooser dcExpiryDate,dcIssueDate;
    JButton add, back;

    AddPassportInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Passport Information");
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

        JLabel labelPassportNumber = new JLabel("Passport Number");
        labelPassportNumber.setBounds(450, 150, 200, 30);
        labelPassportNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPassportNumber);

        tfPassportNumber = new JTextField();
        tfPassportNumber.setBounds(600, 150, 150, 30);
        add(tfPassportNumber);

        JLabel labelExpiryDate = new JLabel("Expiry Date");
        labelExpiryDate.setBounds(50, 200, 150, 30);
        labelExpiryDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelExpiryDate);

        dcExpiryDate = new JDateChooser();
        dcExpiryDate.setBounds(230, 200, 150, 30);
        add(dcExpiryDate);

        JLabel labelIssueDate = new JLabel("Issue Date");
        labelIssueDate.setBounds(450, 200, 200, 30);
        labelIssueDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelIssueDate);

        dcIssueDate = new JDateChooser();
        dcIssueDate.setBounds(600, 200, 150, 30);
        add(dcIssueDate);

        JLabel PassportType = new JLabel("Passport Type");
        PassportType.setBounds(50, 250, 150, 30);
        PassportType.setFont(new Font("serif", Font.PLAIN, 20));
        add(PassportType);

        tfPassportType = new JTextField();
        tfPassportType.setBounds(230, 250, 150, 30);
        add(tfPassportType);

        JLabel labelCountryCode = new JLabel("Country Code");
        labelCountryCode.setBounds(450, 250, 150, 30);
        labelCountryCode.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelCountryCode);

        tfCountryCode = new JTextField();
        tfCountryCode.setBounds(600, 250, 150, 30);
        add(tfCountryCode);

        JLabel labelPreviousPassportNumber = new JLabel("Previous Passport No.");
        labelPreviousPassportNumber.setBounds(50, 300, 200, 30);
        labelPreviousPassportNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPreviousPassportNumber);

        tfPreviousPassportNumber = new JTextField();
        tfPreviousPassportNumber.setBounds(230, 300, 150, 30);
        add(tfPreviousPassportNumber);

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
            String NID="NULL",PassportNumber="NULL",ExpiryDate="NULL",IssueDate="NULL",PassportType="NULL",CountryCode="NULL",
                    PreviousPassportNumber="NULL";
            NID = tfNID.getText();
            PassportNumber = tfPassportNumber.getText();
            ExpiryDate = ((JTextField) dcExpiryDate.getDateEditor().getUiComponent()).getText();
            IssueDate = ((JTextField) dcIssueDate.getDateEditor().getUiComponent()).getText();
            PassportType = tfPassportType.getText();
            CountryCode = tfCountryCode.getText();
            PreviousPassportNumber = tfPreviousPassportNumber.getText();
            
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "insert into passport(NID,PassportNumber,ExpiryDate,IssueDate,PassportType,CountryCode,PreviousPassportNumber) values("+NID+"," + PassportNumber + ", '" + ExpiryDate + "', '" + IssueDate + "', '" + PassportType+ "','" +CountryCode+"',"+PreviousPassportNumber+")";
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
        new AddPassportInfo();
    }
}
