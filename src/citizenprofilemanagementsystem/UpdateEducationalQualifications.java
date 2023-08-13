package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEducationalQualifications extends JFrame implements ActionListener {

    JTextField tfNID,tfSSCResult,tfSSCYear,tfHSCResult,tfHSCYear,tfBachelorsResult,tfBachelorsYear,
            tfMastersResult,tfMastersYear,tfDiplomaResult,tfDiplomaYear;
    
    JLabel lblNID;
    JButton update, back;
    String NID;

    UpdateEducationalQualifications(String NID) {
        this.NID = NID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Educational Qualifications");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        lblNID = new JLabel();
        lblNID.setBounds(200, 150, 150, 30);
        add(lblNID);

        JLabel labelSSCResult = new JLabel("SSC Result(GPA)");
        labelSSCResult .setBounds(400, 150, 150, 30);
        labelSSCResult.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelSSCResult);

        tfSSCResult = new JTextField();
        tfSSCResult.setBounds(600, 150, 150, 30);
        add(tfSSCResult);

        JLabel labelSSCYear = new JLabel("SSC Year");
        labelSSCYear.setBounds(50, 200, 150, 30);
        labelSSCYear.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelSSCYear);

        tfSSCYear = new JTextField();
        tfSSCYear.setBounds(200, 200, 150, 30);
        add(tfSSCYear);

        JLabel labelHSCResult = new JLabel("HSC Result(GPA)");
        labelHSCResult.setBounds(400, 200, 150, 30);
        labelHSCResult.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelHSCResult);

        tfHSCResult = new JTextField();
        tfHSCResult.setBackground(Color.WHITE);
        tfHSCResult.setBounds(600, 200, 150, 30);
        add(tfHSCResult);

        JLabel labelHSCYear = new JLabel("HSC Year");
        labelHSCYear.setBounds(50, 250, 150, 30);
        labelHSCYear.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelHSCYear);

        tfHSCYear = new JTextField();
        tfHSCYear.setBounds(200, 250, 150, 30);
        add(tfHSCYear);

        JLabel labelBachelorsResult = new JLabel("Bachelors Result(CGPA)");
        labelBachelorsResult.setBounds(400, 250, 220, 30);
        labelBachelorsResult.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelBachelorsResult);

        tfBachelorsResult = new JTextField();
        tfBachelorsResult.setBounds(600, 250, 150, 30);
        add(tfBachelorsResult);

        JLabel labelBachelorsYear = new JLabel("Bachelors Year");
        labelBachelorsYear.setBounds(50, 300, 150, 30);
        labelBachelorsYear.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelBachelorsYear);

        tfBachelorsYear = new JTextField();
        tfBachelorsYear.setBounds(200, 300, 150, 30);
        add(tfBachelorsYear);

        JLabel labelMastersResult = new JLabel("Masters Result(CGPA)");
        labelMastersResult.setBounds(400, 300, 200, 30);
        labelMastersResult.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelMastersResult);

        tfMastersResult = new JTextField();
        tfMastersResult.setBounds(600, 300, 150, 30);
        add(tfMastersResult);

        JLabel labelMastersYear = new JLabel("Masters Year");
        labelMastersYear.setBounds(50, 350, 150, 30);
        labelMastersYear.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelMastersYear);

        tfMastersYear = new JTextField();
        tfMastersYear.setBounds(200, 350, 150, 30);
        add(tfMastersYear);

        JLabel labelDiplomaResult = new JLabel("Diploma Result(CGPA)");
        labelDiplomaResult.setBounds(400, 350, 200, 30);
        labelDiplomaResult.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDiplomaResult);

        tfDiplomaResult = new JTextField();
        tfDiplomaResult.setBounds(600, 350, 150, 30);
        add(tfDiplomaResult);

        JLabel labelDiplomaYear = new JLabel("Diploma Year");
        labelDiplomaYear.setBounds(50, 400, 150, 30);
        labelDiplomaYear.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDiplomaYear);

        tfDiplomaYear = new JTextField();
        tfDiplomaYear.setBounds(200, 400, 150, 30);
        add(tfDiplomaYear);

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
            String query = "select * from EducationalQualifications where NID = " + NID;
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblNID.setText(rs.getString("NID"));
                tfSSCResult.setText(rs.getString("SSCResult"));
                tfSSCYear.setText(rs.getString("SSCYear"));
                tfHSCResult.setText(rs.getString("HSCResult"));                
                tfHSCYear.setText(rs.getString("HSCYear"));
                tfBachelorsResult.setText(rs.getString("BachelorsResult"));
                tfBachelorsYear.setText(rs.getString("BachelorsYear"));
                tfMastersResult.setText(rs.getString("MastersResult"));
                tfMastersYear.setText(rs.getString("MastersYear"));
                tfDiplomaResult.setText(rs.getString("DiplomaResult"));
                tfDiplomaYear.setText(rs.getString("DiplomaYear"));
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
            String SSCResult = tfSSCResult.getText();
            String SSCYear = tfSSCYear.getText();
            String HSCResult = tfHSCResult.getText();
            String HSCYear = tfHSCYear.getText();
            String BachelorsResult = tfBachelorsResult.getText();
            String BachelorsYear = tfBachelorsYear.getText();
            String MastersResult = tfMastersResult.getText();
            String MastersYear = tfMastersYear.getText();
            String DiplomaResult = tfDiplomaResult.getText();
            String DiplomaYear = tfDiplomaYear.getText();

            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "update EducationalQualifications set SSCResult = " + SSCResult + ", SSCYear = " + SSCYear + ", HSCResult = " + HSCResult + ", HSCYear = " + HSCYear + ", BachelorsResult =  " + BachelorsResult + ", BachelorsYear = " + BachelorsYear + ", MastersResult = " + MastersResult + ",MastersYear=" + MastersYear + ",DiplomaResult=" + DiplomaResult + ",DiplomaYear=" + DiplomaYear + "where NID = " + NID;

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new ViewProfile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewEducationalQualifications();
        }
    }

    public static void main(String[] args) {
        new UpdateEducationalQualifications("");
    }
}
