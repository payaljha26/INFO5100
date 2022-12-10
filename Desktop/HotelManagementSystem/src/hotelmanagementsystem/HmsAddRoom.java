package hotelmanagementsystem;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class HmsAddRoom extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField text1,text2,text3,text4;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton Button1,Button2;
    Choice selection;

    public static void main(String[] args) {
        new HmsAddRoom().setVisible(true);
    }


    public HmsAddRoom() {
    	
    setBounds(150, 200, 500, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
	        
    JLabel Label10 = new JLabel("Add Rooms");
    Label10.setFont(new Font("SANS", Font.BOLD, 18));
	Label10.setBounds(194, 10, 120, 22);
	contentPane.add(Label10);
            
	JLabel Label1 = new JLabel("Room Number");
	Label1.setForeground(new Color(25, 25, 112));
	Label1.setFont(new Font("SANS", Font.BOLD, 12));
	Label1.setBounds(64, 70, 102, 22);
	contentPane.add(Label1);
              
    text4 = new JTextField();
	text4.setBounds(174, 70, 156, 20);
	contentPane.add(text4);
        
	JLabel Label2 = new JLabel("Availability");
	Label2.setForeground(new Color(25, 25, 112));
	Label2.setFont(new Font("SANS", Font.BOLD, 12));
	Label2.setBounds(64, 110, 102, 22);
	contentPane.add(Label2);
        
    comboBox = new JComboBox(new String[] { "Room Available", "Room Occupied" });
	comboBox.setBounds(176, 110, 154, 20);
	contentPane.add(comboBox);

	JLabel Label3 = new JLabel("Cleaning Status");
	Label3.setForeground(new Color(25, 25, 112));
	Label3.setFont(new Font("SANS", Font.BOLD, 12));
	Label3.setBounds(64, 150, 102, 22);
	contentPane.add(Label3);
        
    comboBox_2 = new JComboBox(new String[] { "Room Cleaned", "Room Dirty" });
	comboBox_2.setBounds(176, 150, 154, 20);
	contentPane.add(comboBox_2);

	JLabel Label4 = new JLabel("Price");
	Label4.setForeground(new Color(25, 25, 112));
	Label4.setFont(new Font("SANS", Font.BOLD, 12));
	Label4.setBounds(64, 190, 102, 22);
	contentPane.add(Label4);
        
    text2 = new JTextField();
	text2.setBounds(174, 190, 156, 20);
	contentPane.add(text2);

    JLabel Label5 = new JLabel("Bed Type");
	Label5.setForeground(new Color(25, 25, 112));
	Label5.setFont(new Font("SANS", Font.BOLD, 12));
	Label5.setBounds(64, 230, 102, 22);
	contentPane.add(Label5);

    comboBox_3 = new JComboBox(new String[] { "Queen Bed", "King Bed"});
	comboBox_3.setBounds(176, 230, 154, 20);
	contentPane.add(comboBox_3);

	Button1 = new JButton("Add");
	Button1.addActionListener(this);
	Button1.setBounds(64, 321, 111, 33);
        Button1.setForeground(Color.BLACK);
	contentPane.add(Button1);

	Button2 = new JButton("Back");
	Button2.addActionListener(this);
	Button2.setBounds(198, 321, 111, 33);
    Button2.setForeground(Color.BLACK);
	contentPane.add(Button2);

    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == Button1){
                try{
                conn c = new conn();
                String room = text4.getText();
                String available = (String)comboBox.getSelectedItem();
                String status = (String)comboBox_2.getSelectedItem();
                String price  = text2.getText();
                String type = (String)comboBox_3.getSelectedItem();
                String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
              
                
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "New Room Added!!");
				new HmsDashboard().setVisible(true);
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == Button2){
            	new HmsDashboard().setVisible(true);

                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}
