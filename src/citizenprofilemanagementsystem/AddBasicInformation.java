package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddBasicInformation extends JFrame implements ActionListener {

    JTextField tfName, tfMaritalStatus, tfLocation, tfMobileNumber, tfNID, tfEmailId, tfBloodGroup, tfProfession, tfCriminalRecord;
    JDateChooser dcDateOfBirth;
    JComboBox cbSex;
    JButton add, back;

    AddBasicInformation() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Basic Information");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        tfNID = new JTextField();
        tfNID.setBounds(200, 150, 150, 30);
        add(tfNID);

        JLabel labelName = new JLabel("Name");
        labelName .setBounds(400, 150, 150, 30);
        labelName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelName);

        tfName = new JTextField();
        tfName.setBounds(600, 150, 150, 30);
        add(tfName);

        JLabel labelDateOfBirth = new JLabel("Date of Birth");
        labelDateOfBirth.setBounds(50, 200, 150, 30);
        labelDateOfBirth.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDateOfBirth);

        dcDateOfBirth = new JDateChooser();
        dcDateOfBirth.setBounds(200, 200, 150, 30);
        add(dcDateOfBirth);

        JLabel labelSex = new JLabel("Sex");
        labelSex.setBounds(400, 200, 150, 30);
        labelSex.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelSex);

        String Sex[] = {"Male", "Female", "Other"};
        cbSex = new JComboBox(Sex);
        cbSex.setBackground(Color.WHITE);
        cbSex.setBounds(600, 200, 150, 30);
        add(cbSex);

        JLabel labelLocation = new JLabel("Location");
        labelLocation.setBounds(50, 250, 150, 30);
        labelLocation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelLocation);

        tfLocation = new JTextField();
        tfLocation.setBounds(200, 250, 150, 30);
        add(tfLocation);

        JLabel labelMobileNumber = new JLabel("Mobile Number");
        labelMobileNumber.setBounds(400, 250, 150, 30);
        labelMobileNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelMobileNumber);

        tfMobileNumber = new JTextField();
        tfMobileNumber.setBounds(600, 250, 150, 30);
        add(tfMobileNumber);

        JLabel labelEmailId = new JLabel("Email ID");
        labelEmailId.setBounds(50, 300, 150, 30);
        labelEmailId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmailId);

        tfEmailId = new JTextField();
        tfEmailId.setBounds(200, 300, 150, 30);
        add(tfEmailId);

        JLabel labelProfession = new JLabel("Profession");
        labelProfession.setBounds(400, 300, 150, 30);
        labelProfession.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelProfession);

        tfProfession = new JTextField();
        tfProfession.setBounds(600, 300, 150, 30);
        add(tfProfession);

        JLabel labelBloodGroup = new JLabel("Blood Group");
        labelBloodGroup.setBounds(50, 350, 150, 30);
        labelBloodGroup.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelBloodGroup);

        tfBloodGroup = new JTextField();
        tfBloodGroup.setBounds(200, 350, 150, 30);
        add(tfBloodGroup);

        JLabel labelMaritalStatus = new JLabel("Marital Status");
        labelMaritalStatus.setBounds(400, 350, 150, 30);
        labelMaritalStatus.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelMaritalStatus);

        tfMaritalStatus = new JTextField();
        tfMaritalStatus.setBounds(600, 350, 150, 30);
        add(tfMaritalStatus);

        JLabel labelCriminalRecord = new JLabel("Criminal Record");
        labelCriminalRecord.setBounds(50, 400, 150, 30);
        labelCriminalRecord.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelCriminalRecord);

        tfCriminalRecord = new JTextField();
        tfCriminalRecord.setBounds(200, 400, 150, 30);
        add(tfCriminalRecord);

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
            String NID="NULL",Name="NULL",DateOfBirth="NULL",Sex="NULL",Location="NULL",MobileNumber="NULL",EmailId="NULL",
                    Profession="NULL",BloodGroup="NULL",MaritalStatus="NULL",CriminalRecord="NULL";
            NID = tfNID.getText();
            Name = tfName.getText();
            DateOfBirth = ((JTextField) dcDateOfBirth.getDateEditor().getUiComponent()).getText();
            Sex = (String) cbSex.getSelectedItem();
            Location = tfLocation.getText();
            MobileNumber = tfMobileNumber.getText();
            EmailId = tfEmailId.getText();
            Profession = tfProfession.getText();
            BloodGroup = tfBloodGroup.getText();
            MaritalStatus = tfMaritalStatus.getText();
            CriminalRecord = tfCriminalRecord.getText();

            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "insert into person values(" + NID + ",'" + Name + "', '" + DateOfBirth + "', '" + Sex + "', '" + Location + "','" + MobileNumber + "', '" + EmailId + "', '" + Profession + "', '" + BloodGroup + "', '" + MaritalStatus + "', '" + CriminalRecord + "')";

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
        new AddBasicInformation();
    }
}
