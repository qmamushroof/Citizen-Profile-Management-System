package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddWorkHistory extends JFrame implements ActionListener {

    JTextField tfNID, tfOrganizationName, tfJobRole, tfCurrentStatus;
    JDateChooser dcStartDate,dcEndDate;
    JButton add, back;

    AddWorkHistory() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Work History");
        heading.setBounds(350, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        tfNID = new JTextField();
        tfNID.setBounds(230, 150, 150, 30);
        add(tfNID);

        JLabel labelOrganizationName = new JLabel("Organization Name");
        labelOrganizationName.setBounds(450, 150, 200, 30);
        labelOrganizationName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelOrganizationName);

        tfOrganizationName = new JTextField();
        tfOrganizationName.setBounds(650, 150, 150, 30);
        add(tfOrganizationName);

        JLabel labelStartDate = new JLabel("Start Date");
        labelStartDate.setBounds(50, 200, 150, 30);
        labelStartDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelStartDate);

        dcStartDate = new JDateChooser();
        dcStartDate.setBounds(230, 200, 150, 30);
        add(dcStartDate);

        JLabel labelEndDate = new JLabel("End Date");
        labelEndDate.setBounds(450, 200, 200, 30);
        labelEndDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEndDate);

        dcEndDate = new JDateChooser();
        dcEndDate.setBounds(650, 200, 150, 30);
        add(dcEndDate);

        JLabel labelJobRole = new JLabel("Job Role");
        labelJobRole.setBounds(50, 250, 150, 30);
        labelJobRole.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelJobRole);

        tfJobRole = new JTextField();
        tfJobRole.setBounds(230, 250, 150, 30);
        add(tfJobRole);

        JLabel labelCurrentStatus = new JLabel("Current Status");
        labelCurrentStatus.setBounds(450, 250, 150, 30);
        labelCurrentStatus.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelCurrentStatus);

        tfCurrentStatus = new JTextField();
        tfCurrentStatus.setBounds(650, 250, 150, 30);
        add(tfCurrentStatus);

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
            String NID="NULL",OrganizationName="NULL",StartDate="NULL",EndDate="NULL",jobRole="NULL",CurrentStatus="NULL";
            NID = tfNID.getText();
            OrganizationName = tfOrganizationName.getText();
            StartDate = ((JTextField) dcStartDate.getDateEditor().getUiComponent()).getText();
            EndDate = ((JTextField) dcEndDate.getDateEditor().getUiComponent()).getText();
            jobRole = tfJobRole.getText();
            CurrentStatus = tfCurrentStatus.getText();
            
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "insert into WorkHistory(NID,OrganizationName,StartDate,EndDate,jobRole,CurrentStatus) values("+NID+"," + OrganizationName + ", '" + StartDate + "', '" + EndDate + "', '" + jobRole+ "','" +CurrentStatus+"')";
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
        new AddWorkHistory();
    }
}
