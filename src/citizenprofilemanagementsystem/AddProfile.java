package citizenprofilemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddProfile extends JFrame implements ActionListener {

    JButton back, BirthRegistration, BasicInformation, NIDCard, Passport, WorkHistory, PermanentAddress, OnlinePresence, EducationalQualifications, DrivingLicense, TradeLicense, logout;

    AddProfile() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/AddProfile.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 600);
        add(image);
        
        JLabel heading = new JLabel("Add Information");
        heading.setBounds(250, 0, 500, 50);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("tahoma", Font.BOLD, 30));
        image.add(heading);

        BasicInformation = new JButton("Basic Information");
        BasicInformation.setBounds(100, 70, 250, 50);
        BasicInformation.setFont(new Font("", Font.BOLD, 20));
        BasicInformation.setBackground(Color.BLACK);
        BasicInformation.setForeground(Color.WHITE);
        BasicInformation.addActionListener(this);
        image.add(BasicInformation);

        BirthRegistration = new JButton("Birth Registration");
        BirthRegistration.setBounds(100, 140, 250, 50);
        BirthRegistration.setFont(new Font("", Font.BOLD, 20));
        BirthRegistration.setBackground(Color.BLACK);
        BirthRegistration.setForeground(Color.WHITE);
        BirthRegistration.addActionListener(this);
        image.add(BirthRegistration);

        NIDCard = new JButton("NID Card");
        NIDCard.setBounds(100, 210, 250, 50);
        NIDCard.setFont(new Font("", Font.BOLD, 20));
        NIDCard.setBackground(Color.BLACK);
        NIDCard.setForeground(Color.WHITE);
        NIDCard.addActionListener(this);
        image.add(NIDCard);

        Passport = new JButton("Passport");
        Passport.setBounds(100, 280, 250, 50);
        Passport.setFont(new Font("", Font.BOLD, 20));
        Passport.setBackground(Color.BLACK);
        Passport.setForeground(Color.WHITE);
        Passport.addActionListener(this);
        image.add(Passport);

        WorkHistory = new JButton("Work History");
        WorkHistory.setBounds(100, 350, 250, 50);
        WorkHistory.setFont(new Font("", Font.BOLD, 20));
        WorkHistory.setBackground(Color.BLACK);
        WorkHistory.setForeground(Color.WHITE);
        WorkHistory.addActionListener(this);
        image.add(WorkHistory);
        
        back = new JButton("Back");
        back.setBounds(100, 450, 250, 50);
        back.setFont(new Font("", Font.BOLD, 20));
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        PermanentAddress = new JButton("Permanent Address");
        PermanentAddress.setBounds(400, 70, 250, 50);
        PermanentAddress.setFont(new Font("", Font.BOLD, 20));
        PermanentAddress.setBackground(Color.BLACK);
        PermanentAddress.setForeground(Color.WHITE);
        PermanentAddress.addActionListener(this);
        image.add(PermanentAddress);

        OnlinePresence = new JButton("Online Presence");
        OnlinePresence.setBounds(400, 140, 250, 50);
        OnlinePresence.setFont(new Font("", Font.BOLD, 20));
        OnlinePresence.setBackground(Color.BLACK);
        OnlinePresence.setForeground(Color.WHITE);
        OnlinePresence.addActionListener(this);
        image.add(OnlinePresence);

        EducationalQualifications = new JButton("Edu. Qualifications");
        EducationalQualifications.setBounds(400, 210, 250, 50);
        EducationalQualifications.setFont(new Font("", Font.BOLD, 20));
        EducationalQualifications.setBackground(Color.BLACK);
        EducationalQualifications.setForeground(Color.WHITE);
        EducationalQualifications.addActionListener(this);
        image.add(EducationalQualifications);

        DrivingLicense = new JButton("Driving License");
        DrivingLicense.setBounds(400, 280, 250, 50);
        DrivingLicense.setFont(new Font("", Font.BOLD, 20));
        DrivingLicense.setBackground(Color.BLACK);
        DrivingLicense.setForeground(Color.WHITE);
        DrivingLicense.addActionListener(this);
        image.add(DrivingLicense);

        TradeLicense = new JButton("Trade License");
        TradeLicense.setBounds(400, 350, 250, 50);
        TradeLicense.setFont(new Font("", Font.BOLD, 20));
        TradeLicense.setBackground(Color.BLACK);
        TradeLicense.setForeground(Color.WHITE);
        TradeLicense.addActionListener(this);
        image.add(TradeLicense);

        logout = new JButton("Logout");
        logout.setBounds(400, 450, 250, 50);
        logout.setFont(new Font("", Font.BOLD, 20));
        logout.setBackground(Color.RED);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        image.add(logout);

        setSize(750, 600);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == BasicInformation) {
            setVisible(false);
            new AddBasicInformation();
        } else if (ae.getSource() == BirthRegistration) {
            setVisible(false);
            new AddBirthRegInfo();
        } else if (ae.getSource() == NIDCard) {
            setVisible(false);
            new AddNIDInfo();
        } else if (ae.getSource() == Passport) {
            setVisible(false);
            new AddPassportInfo();
        } else if (ae.getSource() == WorkHistory) {
            setVisible(false);
            new AddWorkHistory();
        } else if (ae.getSource() == PermanentAddress) {
            setVisible(false);
            new AddPermanentAddress();
        } else if (ae.getSource() == OnlinePresence) {
            setVisible(false);
            new AddOnlinePresenceInfo();
        } else if (ae.getSource() == EducationalQualifications) {
            setVisible(false);
            new AddEducationalQualifications();
        } else if (ae.getSource() == DrivingLicense) {
            setVisible(false);
            new AddDrivingLicenseInfo();
        } else if (ae.getSource() == TradeLicense) {
            setVisible(false);
            new AddTradeLicenseInfo();
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
        else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new AddProfile();
    }
}
