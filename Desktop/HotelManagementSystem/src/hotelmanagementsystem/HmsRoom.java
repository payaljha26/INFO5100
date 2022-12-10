package hotelmanagementsystem;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HmsRoom extends JFrame {
	Connection conn = null;
	
	private JTable table;
	private JLabel RoomAvailablity;
	private JLabel CleaningStat;
	private JLabel label2;
	private JLabel lbl1;
	private JLabel RoomNo;
	private JLabel RId;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HmsRoom frame = new HmsRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

        
	public HmsRoom() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 600, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
               
		
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		contentPane.add(table);
		
		JButton Load = new JButton("Display Data");
		Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    conn c = new conn();
					String displayCustomersql = "select * from room";
					
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		Load.setBounds(100, 470, 120, 30);
               
                Load.setForeground(Color.BLACK);
		contentPane.add(Load);
		
		JButton GoBack = new JButton("Back");
		GoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HmsReception().setVisible(true);
                                setVisible(false);
			}
		});
		GoBack.setBounds(290, 470, 120, 30);
               
                GoBack.setForeground(Color.BLACK);
		contentPane.add(GoBack);
		
		RoomAvailablity = new JLabel("Available Status");
		RoomAvailablity.setBounds(119, 15, 69, 14);
		contentPane.add(RoomAvailablity);
		
		CleaningStat = new JLabel("Clean?");
		CleaningStat.setBounds(216, 15, 50, 14);
		contentPane.add(CleaningStat);
		
		label2 = new JLabel("Cost");
		label2.setBounds(330, 15, 46, 14);
		contentPane.add(label2);
		
		lbl1 = new JLabel("Bed Type");
		lbl1.setBounds(417, 15, 76, 14);
		contentPane.add(lbl1);

		
		RId = new JLabel("Room No");
		RId.setBounds(12, 15, 90, 14);
		contentPane.add(RId);
                
                getContentPane().setBackground(Color.WHITE);
	}

}
