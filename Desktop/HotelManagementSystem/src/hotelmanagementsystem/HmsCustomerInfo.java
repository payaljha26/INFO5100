package hotelmanagementsystem;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HmsCustomerInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	
	private JLabel custId, custName, custGender, custCountry, custRoom, custCheckIn, custDeposit;

	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HmsCustomerInfo frame = new HmsCustomerInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}

	public HmsCustomerInfo() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HmsReception().setVisible(true);
                                setVisible(false);
			}
		});
		backBtn.setBounds(450, 510, 120, 30);
                
                backBtn.setForeground(Color.BLACK);
		contentPane.add(backBtn);
		
		JButton loadBtn = new JButton("Load Data");
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
                                    conn c  = new conn();
                                    
				String displayCustomersql = "select * from Customer";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		});
		loadBtn.setBounds(300, 510, 120, 30);
          
                loadBtn.setForeground(Color.BLACK);
		contentPane.add(loadBtn);
		
		custId = new JLabel("IDType");
		custId.setBounds(31, 11, 46, 14);
		contentPane.add(custId);
                
         JLabel custNum = new JLabel("Number");
		custNum.setBounds(150, 11, 80, 14);
		contentPane.add(custNum);
		
		custName = new JLabel("CustName");
		custName.setBounds(250, 11, 65, 14);
		contentPane.add(custName);
		
		custGender = new JLabel("Gender");
		custGender.setBounds(360, 11, 46, 14);
		contentPane.add(custGender);
		
		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		contentPane.add(table);
		
		custCountry = new JLabel("Country");
		custCountry.setBounds(480, 11, 80, 14);
		contentPane.add(custCountry);
		
		custRoom = new JLabel("Room");
		custRoom.setBounds(600, 11, 46, 14);
		contentPane.add(custRoom);
		
		custCheckIn = new JLabel("Checkin");
		custCheckIn.setBounds(680, 11, 100, 14);
		contentPane.add(custCheckIn);
		
		custDeposit = new JLabel("Deposit");
		custDeposit.setBounds(800, 11, 100, 14);
		contentPane.add(custDeposit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}