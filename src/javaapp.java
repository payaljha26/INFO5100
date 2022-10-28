
import java.awt.EventQueue;
import java.awt.* ;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class javaapp extends JFrame {
	private JPanel contentPane;
	private JTextField txttot;
	private JTextField txtearned;
	private JTextField txtasspercentage;
	private JTextField txtweightedgrade;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javaapp frame = new javaapp();
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
	public javaapp() {
		setBackground(Color.DARK_GRAY);
		setFont(new Font("Apple Chancery", Font.BOLD, 12));
		setTitle("Weighted Grade Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 554, 372);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel pointtotal = new JLabel("Enter total marks");
		pointtotal.setBounds(31, 20, 118, 16);
		contentPane.add(pointtotal);
		
		txttot = new JTextField();
		txttot.setForeground(Color.DARK_GRAY);
		txttot.setBackground(Color.WHITE);
		txttot.setBounds(176, 15, 130, 26);
		contentPane.add(txttot);
		txttot.setColumns(10);
		
		JLabel earnedpoints = new JLabel("Enter Earned marks");
		earnedpoints.setToolTipText("");
		earnedpoints.setBounds(31, 59, 142, 16);
		contentPane.add(earnedpoints);
		
		txtearned = new JTextField();
		txtearned.setBounds(176, 53, 130, 26);
		contentPane.add(txtearned);
		txtearned.setColumns(10);
		
		JLabel asspercentage = new JLabel("Enter Assignment percentage");
		asspercentage.setBounds(31, 96, 192, 16);
		contentPane.add(asspercentage);
		
		txtasspercentage = new JTextField();
		txtasspercentage.setBounds(226, 91, 130, 26);
		contentPane.add(txtasspercentage);
		txtasspercentage.setColumns(10);
		
		JButton btnNewButton = new JButton("Click to calculate the weighted score");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Kohinoor Telugu", Font.BOLD, 13));
		btnNewButton.setBackground(Color.RED);
		
		// calling out our variables from the weighted grade class in order for the calculations to be performed.
		
     	btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				

				WeightedGrades wg = new WeightedGrades();
				double pointtotal , earnedpoints , asspercentage ;
				double weightedgrade ;
				pointtotal = Double.parseDouble(txttot.getText());
				wg.setPointTotal(pointtotal);
				earnedpoints = Double.parseDouble(txtearned.getText());
				wg.setEarnedPoints(earnedpoints);
				asspercentage = Double.parseDouble(txtasspercentage.getText());
				wg.setAssignmentPercentage(asspercentage);
				weightedgrade = wg.getTotalWeightedGrade();
				
			    
			    
			    txtweightedgrade.setText(Double.toString(weightedgrade));
				
			}
		});
		btnNewButton.setBounds(115, 150, 299, 29);
		contentPane.add(btnNewButton);
		
		JLabel weightedgrade = new JLabel("Weighted Grade Marks");
		weightedgrade.setBounds(31, 212, 152, 16);
		contentPane.add(weightedgrade);
		
		txtweightedgrade = new JTextField();
		txtweightedgrade.setEditable(false);
		txtweightedgrade.setBounds(195, 207, 130, 26);
		contentPane.add(txtweightedgrade);
		txtweightedgrade.setColumns(10);
	}
}
