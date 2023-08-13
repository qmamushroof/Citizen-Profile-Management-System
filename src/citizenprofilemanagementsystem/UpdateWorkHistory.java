package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateWorkHistory extends JFrame implements ActionListener {

    JTextField tfNID, tfOrganizationName, tfJobRole, tfCurrentStatus;
    JDateChooser dcStartDate,dcEndDate;
    
    JLabel lblNID;
    JButton update, back;
    String NID;     
        
    UpdateWorkHistory(String NID) {
        this.NID = NID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Work History");
        heading.setBounds(350, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        lblNID = new JLabel();
        lblNID.setBounds(230, 150, 150, 30);
        add(lblNID);

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
            String query = "select * from WorkHistory where NID = " + NID;
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblNID.setText(rs.getString("NID"));
                tfOrganizationName.setText(rs.getString("OrganizationName"));
                tfJobRole.setText(rs.getString("JobRole"));
                tfCurrentStatus.setText(rs.getString("CurrentStatus"));
                tfOrganizationName.setText(rs.getString("OrganizationName"));
                dcStartDate.setDate(rs.getDate("StartDate"));
                dcEndDate.setDate(rs.getDate("EndDate"));
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
            String OrganizationName = tfOrganizationName.getText();
            String StartDate = ((JTextField) dcStartDate.getDateEditor().getUiComponent()).getText();
            String EndDate = ((JTextField) dcEndDate.getDateEditor().getUiComponent()).getText();
            String jobRole = tfJobRole.getText();
            String CurrentStatus = tfCurrentStatus.getText();
            
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "update WorkHistory set OrganizationName = '" + OrganizationName + "', StartDate = '" + StartDate + "', EndDate = '" + EndDate + "', jobRole = '" + jobRole + "', CurrentStatus =  '" + CurrentStatus + "' where NID = " + NID;

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new ViewProfile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewWorkHistory();
        }
    }

    public static void main(String[] args) {
        new UpdateWorkHistory("");
    }
}
