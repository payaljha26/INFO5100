package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

        JLabel label1;
        JButton button1;
        
        public HotelManagementSystem() {
		
                setSize(500,500);          
                setLayout(null);
                setLocation(300,300);


                label1 = new JLabel("");
                label1.setBounds(50, 50, 1366, 390);
                JLabel title=new JLabel("HOTEL MANAGEMENT SYSTEM PROJECT");
                title.setBounds(30,50,1500,100);
                title.setFont(new Font("serif",Font.BOLD,20));
                title.setForeground(Color.BLACK);
                label1.add(title);
		        add(label1);
		        
                button1 = new JButton("Login");        

                button1.setForeground(Color.BLACK);
                button1.setBounds(100,150,150,50);
                label1.add(button1);
                button1.addActionListener(this);
                setVisible(true);
                       	

	}
        
        public void actionPerformed(ActionEvent ae){
                new HmsLogin().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                HotelManagementSystem window = new HotelManagementSystem();
                window.setVisible(true);			
	}
}