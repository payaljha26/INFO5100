package hotelmanagementsystem;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HmsNewCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField Text1,Text2,Text3,Text4,Text5,Text6;
        JComboBox comboBox;
        JRadioButton rdbtn1,rdbtn2;
        Choice selection;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HmsNewCustomer frame = new HmsNewCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HmsNewCustomer() throws SQLException {
		
                setBounds(530, 200, 650, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                

		JLabel lblName = new JLabel("NEW CUSTOMER CHECKIN");
		lblName.setFont(new Font("SANS", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
                
                JLabel CustIDType = new JLabel("ID :");
		CustIDType.setBounds(35, 76, 200, 14);
		contentPane.add(CustIDType);
                
                comboBox = new JComboBox(new String[] {"PASSPORT", "Driving License"});
		comboBox.setBounds(271, 73, 150, 20);
		contentPane.add(comboBox);
                
                JLabel CustID = new JLabel("Number :");
		CustID.setBounds(35, 111, 200, 14);
		contentPane.add(CustID);
		
		JLabel CustName = new JLabel("Name :");
		CustName.setBounds(35, 151, 200, 14);
		contentPane.add(CustName);
                
        Text1 = new JTextField();
		Text1.setBounds(271, 111, 150, 20);
		contentPane.add(Text1);
		Text1.setColumns(10);
		
		
		
		Text2 = new JTextField();
		Text2.setBounds(271, 151, 150, 20);
		contentPane.add(Text2);
		Text2.setColumns(10);

		Text3 = new JTextField();
		Text3.setBounds(271, 231, 150, 20);
		contentPane.add(Text3);
		Text3.setColumns(10);
		
		
		Text5 = new JTextField();
		Text5.setBounds(271, 316, 150, 20);
		contentPane.add(Text5);
		Text5.setColumns(10);
		
		Text6 = new JTextField();
		Text6.setBounds(271, 359, 150, 20);
		contentPane.add(Text6);
		Text6.setColumns(10);
                
		JLabel CustGender = new JLabel("Gender :");
		CustGender.setBounds(35, 191, 200, 14);
		contentPane.add(CustGender);
                
                rdbtn1 = new JRadioButton("Male");
                rdbtn1.setFont(new Font("SANS", Font.PLAIN, 14));
                rdbtn1.setBackground(Color.WHITE);
                rdbtn1.setBounds(271, 191, 80, 12);
                add(rdbtn1);
                
                rdbtn2 = new JRadioButton("Female");
                rdbtn2.setFont(new Font("SANS", Font.PLAIN, 14));
                rdbtn2.setBackground(Color.WHITE);
                rdbtn2.setBounds(350, 191, 100, 12);
		add(rdbtn2);
                
		JLabel CustCountry = new JLabel("Country :");
		CustCountry.setBounds(35, 231, 200, 14);
		contentPane.add(CustCountry);
		
		JLabel CustRoomNo = new JLabel("Allocated Room Number :");
		CustRoomNo.setBounds(35, 274, 200, 14);
		contentPane.add(CustRoomNo);
                
                selection = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from room");
                    while(rs.next()){
                        selection.add(rs.getString("roomnumber"));    
                    }
                }catch(Exception e){ }
                selection.setBounds(271, 274, 150, 20);
		contentPane.add(selection);
		
		JLabel checkinCust = new JLabel("Check In Date :");
		checkinCust.setBounds(35, 316, 200, 14);
		contentPane.add(checkinCust);
		
		JLabel custDep = new JLabel("Deposit :");
		custDep.setBounds(35, 359, 200, 14);
		contentPane.add(custDep);

		JButton custAddBtn = new JButton("Add");
		custAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            conn c = new conn();
                            String radio = null;
                            
                            if(rdbtn1.isSelected()){ 
                                radio = "Male";
                            }
                            else if(rdbtn2.isSelected()){ 
                                radio = "Female";
                            }
                            
                            String s6 = selection.getSelectedItem();
                          
                            try{
					    			
				                            String s1 = (String)comboBox.getSelectedItem(); 
					    			String s2 =  Text1.getText();
					    			String s3 =  Text2.getText();
				                                String s4 =  radio;
					    			String s5 =  Text3.getText();
					    			String s7 =  Text5.getText();
				                                String s8 =  Text6.getText();
				                                
				                                String q1 = "insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
				                                String q2 = "update room set availability = 'Occupied' where roomnumber = "+s6;
                                c.s.executeUpdate(q1);
                                c.s.executeUpdate(q2);
	    			
	    			
	    			JOptionPane.showMessageDialog(null, "New Customer Checked In");
                                new HmsReception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});
		custAddBtn.setBounds(100, 430, 120, 30);
              
                custAddBtn.setForeground(Color.BLACK);
		contentPane.add(custAddBtn);
		
		JButton exitbtn = new JButton(" Go Back");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new HmsReception().setVisible(true);
                            setVisible(false);
			}
		}); 
		exitbtn.setBounds(260, 430, 120, 30);
               
                exitbtn.setForeground(Color.BLACK);
		contentPane.add(exitbtn);
                
              
	}
}
