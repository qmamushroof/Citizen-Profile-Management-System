package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddEducationalQualifications extends JFrame implements ActionListener {

    JTextField tfNID,tfSSCResult,tfSSCYear,tfHSCResult,tfHSCYear,tfBachelorsResult,tfBachelorsYear,tfMastersResult,tfMastersYear,tfDiplomaResult,tfDiplomaYear;
    
    JButton update, back;

    AddEducationalQualifications() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Educational Qualifications");
        heading.setBounds(280, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        tfNID = new JTextField();
        tfNID.setBounds(200, 150, 150, 30);
        add(tfNID);

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

        update = new JButton("Add Details");
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

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String NID="NULL",SSCResult="NULL",SSCYear="NULL",HSCResult="NULL",HSCYear="NULL",BachelorsResult="NULL",
                    BachelorsYear="NULL",MastersResult="NULL",MastersYear="NULL",DiplomaResult="NULL",DiplomaYear="NULL";
            NID = tfNID.getText();
            SSCResult = tfSSCResult.getText();
            SSCYear = tfSSCYear.getText();
            HSCResult = tfHSCResult.getText();
            HSCYear = tfHSCYear.getText();
            BachelorsResult = tfBachelorsResult.getText();
            BachelorsYear = tfBachelorsYear.getText();
            MastersResult = tfMastersResult.getText();
            MastersYear = tfMastersYear.getText();
            DiplomaResult = tfDiplomaResult.getText();
            DiplomaYear = tfDiplomaYear.getText();

            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "insert into EducationalQualifications(NID,SSCResult,SSCYear,HSCResult,HSCYear,BachelorsResult,BachelorsYear,MastersResult,MastersYear,DiplomaResult,DiplomaYear) values(" + NID + "," + SSCResult + "," + SSCYear + "," + HSCResult + "," + HSCYear +","+ BachelorsResult +"," + BachelorsYear +","+ MastersResult +","+ MastersYear +","+ DiplomaResult +","+ DiplomaYear + ")";

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
        new AddEducationalQualifications();
    }
}
