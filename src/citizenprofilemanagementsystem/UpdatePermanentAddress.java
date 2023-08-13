package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class UpdatePermanentAddress extends JFrame implements ActionListener {

    JTextField tfNID, tfHouseAddress, tfLocalityName, tfUpazila, tfDistrict, tfDivision;

    JLabel lblNID;
    JButton update, back;
    String NID;

    UpdatePermanentAddress(String NID) {
        this.NID = NID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Permanent Address");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        lblNID = new JLabel();
        lblNID.setBounds(230, 150, 150, 30);
        add(lblNID);

        JLabel labelHouseAddress = new JLabel("House Address");
        labelHouseAddress.setBounds(450, 150, 200, 30);
        labelHouseAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelHouseAddress);

        tfHouseAddress = new JTextField();
        tfHouseAddress.setBounds(650, 150, 150, 30);
        add(tfHouseAddress);

        JLabel labelDistrict = new JLabel("District");
        labelDistrict.setBounds(50, 200, 150, 30);
        labelDistrict.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDistrict);

        tfDistrict = new JTextField();
        tfDistrict.setBounds(230, 200, 150, 30);
        add(tfDistrict);

        JLabel labelDivision = new JLabel("Division");
        labelDivision.setBounds(450, 200, 200, 30);
        labelDivision.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDivision);

        tfDivision = new JTextField();
        tfDivision.setBounds(650, 200, 150, 30);
        add(tfDivision);

        JLabel labelLocalityName = new JLabel("Locality Name");
        labelLocalityName.setBounds(50, 250, 150, 30);
        labelLocalityName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelLocalityName);

        tfLocalityName = new JTextField();
        tfLocalityName.setBounds(230, 250, 150, 30);
        add(tfLocalityName);

        JLabel labelUpazila = new JLabel("Upazila");
        labelUpazila.setBounds(450, 250, 150, 30);
        labelUpazila.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelUpazila);

        tfUpazila = new JTextField();
        tfUpazila.setBounds(650, 250, 150, 30);
        add(tfUpazila);

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
            String query = "select * from PermanentAddress where NID = " + NID;
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblNID.setText(rs.getString("NID"));
                tfHouseAddress.setText(rs.getString("HouseAddress"));
                tfLocalityName.setText(rs.getString("LocalityName"));
                tfUpazila.setText(rs.getString("Upazila"));
                tfDistrict.setText(rs.getString("District"));
                tfDivision.setText(rs.getString("Division"));
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
            String HouseAddress = tfHouseAddress.getText();
            String LocalityName = tfLocalityName.getText();
            String Upazila = tfUpazila.getText();
            String District = tfDistrict.getText();
            String Division = tfDivision.getText();

            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "update PermanentAddress set HouseAddress = '" + HouseAddress + "', LocalityName = '" + LocalityName + "', Upazila = '" + Upazila + "', District = '" + District + "', Division = '" + Division + "'where NID = " + NID;

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new ViewProfile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewPermanentAddress();
        }
    }

    public static void main(String[] args) {
        new UpdatePermanentAddress("");
    }
}
