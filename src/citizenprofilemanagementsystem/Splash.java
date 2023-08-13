package citizenprofilemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    Splash() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Citizen Profile Management System");
        heading.setBounds(60, 30, 1200, 80);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        //Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 801, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 801);
        add(image);
        
        JButton clickhere = new JButton("Continue");
        clickhere.setBounds(400, 650, 200, 50);
        clickhere.setFont(new Font("serif", Font.PLAIN, 40));
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);

        setSize(1000, 801);
        setLocation(200, 50);
        setVisible(true);
        
        while(true) {
            heading.setVisible(true);
            try {
                Thread.sleep(700);
            } catch (Exception e){
                
            }
            
            heading.setVisible(false);
            try {
                Thread.sleep(200);
            } catch (Exception e){
                
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]) {
        new Splash();
    }
}
