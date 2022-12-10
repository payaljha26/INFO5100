package hotelmanagementsystem;


import javax.swing.*;
import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class HmsReception extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		new HmsReception();
	}
	
	public HmsReception(){
		
    	setBounds(530, 200, 350, 470);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
		
		JButton NewCustCheckIn = new JButton("Check in NEW CUSTOMER");
		NewCustCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				HmsNewCustomer custom = new HmsNewCustomer();
				custom.setVisible(true);
                                setVisible(false);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		NewCustCheckIn.setBounds(10, 30, 200, 30);
                
                NewCustCheckIn.setForeground(Color.BLACK);
		contentPane.add(NewCustCheckIn);
		
		JButton AddNewRoom = new JButton("Room Database");
		AddNewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				HmsRoom room = new HmsRoom();
				room.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
		AddNewRoom.setBounds(10, 70, 200, 30);
               
                AddNewRoom.setForeground(Color.BLACK);

		contentPane.add(AddNewRoom);
		
		
		JButton CustInfo = new JButton("Customer Database");
		CustInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					HmsCustomerInfo customer = new HmsCustomerInfo();
					customer.setVisible(true);				
					setVisible(false);
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		CustInfo.setBounds(10, 110, 200, 30);
               
                CustInfo.setForeground(Color.BLACK);

		contentPane.add(CustInfo);
		
		
		JButton CustChkOut = new JButton("Check Out Customer");
		CustChkOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HmsCheckOut check;
				try {
					 check = new HmsCheckOut();
					check.setVisible(true);
                                        setVisible(false);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		CustChkOut.setBounds(10, 150, 200, 30);
              
                CustChkOut.setForeground(Color.BLACK);

		contentPane.add(CustChkOut);
		
		
		JButton SearchBtn = new JButton("Search Room");
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				HmsSearchRoom search = new HmsSearchRoom();
				search.setVisible(true);
                                setVisible(false);
				}
				catch (Exception ss){
					ss.printStackTrace();
				}
			}
		});
		SearchBtn.setBounds(10, 190, 200, 30);
              
                SearchBtn.setForeground(Color.BLACK);

		contentPane.add(SearchBtn);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
                                    new HmsLogin().setVisible(true);
                                    setVisible(false);
                                    
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnLogOut.setBounds(10, 370, 200, 30);
               
                btnLogOut.setForeground(Color.BLACK);
                

		contentPane.add(btnLogOut);
                
                
                setVisible(true);
	}
}
