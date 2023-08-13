package citizenprofilemanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddPermanentAddress extends JFrame implements ActionListener {

    JTextField tfNID, tfHouseAddress, tfLocalityName, tfUpazila, tfDistrict,tfDivision;
    JButton add, back;

    AddPermanentAddress() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Permanent Address");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelNID = new JLabel("NID");
        labelNID.setBounds(50, 150, 150, 30);
        labelNID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelNID);

        tfNID = new JTextField();
        tfNID.setBounds(230, 150, 150, 30);
        add(tfNID);

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
            String HouseAddress = tfHouseAddress.getText();
            String LocalityName = tfLocalityName.getText();
            String Upazila = tfUpazila.getText();
            String District = tfDistrict.getText();
            String Division = tfDivision.getText();
            
            try {
                ConnectMSSQL c = new ConnectMSSQL();
                String query = "insert into PermanentAddress(NID,HouseAddress,LocalityName,Upazila,District,Division) values("+NID+",'" + HouseAddress + "', '" + LocalityName + "', '" + Upazila + "', '" + District+ "','" +Division+"')";
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
        new AddPermanentAddress();
    }
}
