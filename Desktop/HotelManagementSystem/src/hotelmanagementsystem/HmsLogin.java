package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class HmsLogin extends JFrame implements ActionListener {
	
	JLabel Label1,Label2;
    JTextField Text1;
    JPasswordField Pass;
    JButton Button1,Button2;

    HmsLogin(){

        super("Login");

        setLayout(null);

        Label1 = new JLabel("Username");
        Label1.setBounds(40,20,100,30);
        add(Label1);
        
        Label2 = new JLabel("Password");
        Label2.setBounds(40,70,100,30);
        add(Label2);
 
        Text1=new JTextField();
        Text1.setBounds(150,20,150,30);
        add(Text1);

        Pass=new JPasswordField();
        Pass.setBounds(150,70,150,30);
        add(Pass);

        Button1 = new JButton("Login");
        Button1.setBounds(40,140,120,30);
        Button1.setFont(new Font("sans",Font.BOLD,10));
        Button1.addActionListener(this);
        Button1.setForeground(Color.BLACK);
        add(Button1);

        Button2=new JButton("Cancel");
        Button2.setBounds(180,140,120,30);
        Button2.setFont(new Font("sans",Font.BOLD,10));
        Button2.setForeground(Color.BLACK);
        add(Button2);

        Button2.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(400,300);
        setLocation(600,350);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Button1){
        try{
            conn c1 = new conn();
            String user = Text1.getText();
            String pwd = Pass.getText();
            
            String q = "select * from login where username='"+user+"' and password='"+pwd+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){ 
                new HmsDashboard().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login! Check your username and/or password!");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==Button2){
            System.exit(0);
        }
    }
    public static void main(String[] arg){
        new HmsLogin();
    }

}
