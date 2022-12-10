package hotelmanagementsystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class HmsDashboard extends JFrame{

    public static void main(String[] args) {
        new HmsDashboard().setVisible(true);
    }
    
    public HmsDashboard() {
        setLayout(null); 

        
        JLabel Label2 = new JLabel("Greetings of the day!");
	Label2.setForeground(Color.BLACK);
        Label2.setFont(new Font("Tahoma", Font.PLAIN, 46));
	Label2.setBounds(100, 160, 1000, 85);
	add(Label2);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu menuTitle = new JMenu("HOTEL MANAGEMENT");
        menuTitle.setForeground(Color.BLUE);
	menuBar.add(menuTitle);
		
        JMenuItem menuOption1 = new JMenuItem("RECEPTION OPERATIONS");
	menuTitle.add(menuOption1);
		
	JMenu menuOption2 = new JMenu("ADMIN OPERATIONS");
        menuOption2.setForeground(Color.RED);
	menuBar.add(menuOption2);
        

        JMenuItem subMenu = new JMenuItem("ADD A NEW ROOM");
	menuOption2.add(subMenu);
        
        subMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new HmsAddRoom().setVisible(true);
                    setVisible(false);
                    
                }catch(Exception e ){}
            }
	});
        

	menuOption1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new HmsReception();
                setVisible(false);
            }
	});
        
        
        
		
        setSize(600,600);
	setVisible(true);
    }
}
