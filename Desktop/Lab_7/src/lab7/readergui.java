package lab7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class readergui extends JFrame {

	private JPanel contentPane;
	private JTextField newfilename;
	private JTextField newfilelines;
	private JTable table;
	private JTextField temp;
	private String[] dataPrivate;
	private boolean buttonClicked = false ;
	private JButton readbutton;
	
	public void fillText( JTextArea printfive) {
		printfive.append("FROM new function fillText");
		
		
}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					readergui frame = new readergui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public readergui() {
		//
		System.out.println("Reached Constructor");
		
		CSVReader printfiveobj = new CSVReader();
		 String datafive[] = new String[6];
		 dataPrivate = printfiveobj.printfive();
		

		//
		setFont(new Font("Galvji", Font.PLAIN, 12));
		setTitle("CSV Reader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		 getContentPane().setLayout(null);
		 
		 JLabel lblNewLabel_1 = new JLabel("Reading File name");
		 lblNewLabel_1.setBounds(28, 28, 121, 16);
		 contentPane.add(lblNewLabel_1);
		 
		 JLabel lblNewLabel = new JLabel("Annual.csv");
		 lblNewLabel.setBounds(28, 56, 76, 16);
		 contentPane.add(lblNewLabel);
		 
		 JButton readbutton = new JButton("Click to read from file");
		 readbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					System.out.println("Reached here");
					
					
//					CSVReader printfiveobj = new CSVReader();
//					 String datafive[] = new String[6];
//					 dataPrivate = printfiveobj.printfive();
//					 buttonClicked = true;
//					 
// 
//					 for (int i = 0 ; i < 6; i ++) {
//						 System.out.println((datafive[i]));
//						 
//						
//					 }
					 
					 
					
							
				}
			});
		 readbutton.setBounds(16, 84, 188, 29);
		 contentPane.add(readbutton);
		 
		 JLabel lblNewLabel_2 = new JLabel("First five lines of the file");
		 lblNewLabel_2.setBounds(28, 125, 154, 16);
		 contentPane.add(lblNewLabel_2);
		 
		 JLabel lblNewLabel_3 = new JLabel("Enter new file name");
		 lblNewLabel_3.setBounds(297, 28, 143, 16);
		 contentPane.add(lblNewLabel_3);
		 
		 newfilename = new JTextField();
		 newfilename.setBounds(294, 51, 130, 26);
		 contentPane.add(newfilename);
		 newfilename.setColumns(10);
		 
		 JButton newfilebutton = new JButton("Click to write to new file");
		 newfilebutton.setBounds(277, 84, 188, 29);
		 contentPane.add(newfilebutton);
		 
		 JLabel lblNewLabel_4 = new JLabel("first five lines of the new file");
		 lblNewLabel_4.setBounds(277, 125, 204, 16);
		 contentPane.add(lblNewLabel_4);
		 
		 // print5 lines
		 
//		 CSVReader printfiveobj = new CSVReader();
//		 String datafive[] = new String[6];
//		 datafive = printfiveobj.printfive();
		 
		 JTextArea printfive = new JTextArea();
		 //printfive.append("OUT!");
			 System.out.println("Inside the button");
			 printfive.append(dataPrivate[0]);

		 //printfive.append(dataPrivate[0]);
		 
		 printfive.setEditable(false);
		 printfive.setBounds(28, 153, 188, 183);
		 contentPane.add(printfive);
		 
		 
		 
		 
//		 for (int i = 0 ; i < 5; i ++) {
//			 System.out.print("Reached for loop");
//			 printfive.append("Testing Insert");
//			 printfive.append(dataPrivate[i]);
//		 }
		 
		 
		 //
		 JTextArea printnewfive = new JTextArea();
		 printnewfive.setBounds(297, 153, 188, 175);
		 contentPane.add(printnewfive);
		 
		 temp = new JTextField();
		 temp.setBounds(19, 354, 130, 26);
		 contentPane.add(temp);
		 temp.setColumns(10);
		 
		 
		
	}
	


}


