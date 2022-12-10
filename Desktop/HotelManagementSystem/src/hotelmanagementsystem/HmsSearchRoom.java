package hotelmanagementsystem;

import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HmsSearchRoom extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table;
        Choice selection;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HmsSearchRoom frame = new HmsSearchRoom();
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

	public HmsSearchRoom() throws SQLException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel roomSearch = new JLabel("Search Room");
		roomSearch.setFont(new Font("SANS", Font.BOLD, 20));
		roomSearch.setBounds(250, 11, 186, 31);
		contentPane.add(roomSearch);
		
		JLabel roomAvl = new JLabel("Bed Type:");
		roomAvl.setBounds(50, 73, 96, 14);
		contentPane.add(roomAvl);
		
		JLabel roomType = new JLabel("Room No");
		roomType.setBounds(23, 162, 96, 14);
		contentPane.add(roomType);
		
		JLabel roomAvaliable = new JLabel("Available?");
		roomAvaliable.setBounds(175, 162, 120, 14);
		contentPane.add(roomAvaliable);
		
		JLabel roomCost = new JLabel("Cost");
		roomCost.setBounds(458, 162, 46, 14);
		contentPane.add(roomCost);
                
                JLabel roomBed = new JLabel("Bed Type");
		roomBed.setBounds(580, 162, 96, 14);
		contentPane.add(roomBed);
		
		JCheckBox checkRoom = new JCheckBox("Only display Available");
		checkRoom.setBounds(400, 69, 205, 23);
                checkRoom.setBackground(Color.BLACK);
		contentPane.add(checkRoom);
		
		
                selection = new Choice();
                selection.add("King Bed");
                selection.add("Queen Bed");
                selection.setBounds(153, 70, 120, 20);
		contentPane.add(selection);
		
		JButton Search = new JButton("Search Result");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = "select * from room where bed_type = '"+selection.getSelectedItem()+"'";
				String SQL2 = "select * from room where availability = 'Available' AND bed_type = '"+selection.getSelectedItem()+"'";
			try{			
                                conn c = new conn();
				rs = c.s.executeQuery(SQL);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				if(checkRoom.isSelected())
				{	
					rs = c.s.executeQuery(SQL2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
				
			}catch (SQLException ss)
			{
				ss.printStackTrace();
			}
			
			}
		});
		Search.setBounds(200, 400, 120, 30);
		Search.setBackground(Color.BLACK);
                Search.setForeground(Color.BLACK);
		contentPane.add(Search);
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HmsReception().setVisible(true);
                                setVisible(false);
			}
		});
		backBtn.setBounds(380, 400, 120, 30);
                backBtn.setForeground(Color.BLACK);
                backBtn.setBackground(Color.BLACK);
		contentPane.add(backBtn);
		
		table = new JTable();
		table.setBounds(0, 187, 700, 300);
		contentPane.add(table);
		
		JLabel cleanStat = new JLabel("Clean Status");
		cleanStat.setBounds(306, 162, 96, 14);
		contentPane.add(cleanStat);
	}
}
