package hotelmanagementsystem;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class HmsCheckOut extends JFrame{
	
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField Text1;
        Choice selection;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HmsCheckOut frame = new HmsCheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	public HmsCheckOut() throws SQLException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 350, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
		JLabel checkout = new JLabel("CUSTOMER CHECKOUT ");
		checkout.setFont(new Font("SANS", Font.PLAIN, 15));
		checkout.setBounds(70, 11, 250,50);
		contentPane.add(checkout);
		
		JLabel Name = new JLabel("Customer ID :");
		Name.setBounds(20, 85, 90, 30);
		contentPane.add(Name);
                
                selection = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        selection.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                selection.setBounds(130, 82, 150, 20);
		        contentPane.add(selection);
                

                JButton Label2 = new JButton();
                add(Label2);
                
                Label2.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent ae){
      
                        try{
                            
                            conn c = new conn();
                            String number = selection.getSelectedItem();
                            ResultSet rs = c.s.executeQuery("select * from customer where number = "+number);
                            
                            if(rs.next()){
                                
                                Text1.setText(rs.getString("roomnumber"));    
                            }
                        }catch(Exception e){ }
                    }
                });

		
		JLabel RoomNo = new JLabel("Room Number:");
		RoomNo.setBounds(20, 132, 86, 20);
		contentPane.add(RoomNo);
		
		Text1 = new JTextField();
                Text1.setBounds(130, 132, 150, 20);
		contentPane.add(Text1);
                         
		JButton ChkOut = new JButton("CheckOut");
		ChkOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                String id = selection.getSelectedItem();
                                String s1 = Text1.getText();
				String deleteSQL = "Delete from customer where number = "+id;
                                String q2 = "update room set availability = 'Available' where roomnumber = "+s1;
                                
                                
				conn c = new conn();

	    		try{
	    			c.s.executeUpdate(deleteSQL);
	    			c.s.executeUpdate(q2);
	    			JOptionPane.showMessageDialog(null, "Customer Checked out successfully");
	    			new HmsReception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		ChkOut.setBounds(50, 200, 100, 25);
              
                ChkOut.setForeground(Color.BLACK);
		contentPane.add(ChkOut);
		
		JButton terminate = new JButton("Back");
		terminate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HmsReception().setVisible(true);
                                setVisible(false);
			}
		});
		terminate.setBounds(160, 200, 100, 25);
            
                terminate.setForeground(Color.BLACK);
		contentPane.add(terminate);
                
                
	}

}
