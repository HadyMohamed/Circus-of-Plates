package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.control;




public class game extends JPanel implements ActionListener{
	JButton Button1;
	JButton Button2;
	JButton exit;
	JFrame frame;
	public game() throws IOException{
        JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File("mad1.png"))));

		 frame= new JFrame();
		frame.setTitle("Game");
		frame.setSize(new Dimension(1350,720));
        frame.setContentPane(label);

		frame.setPreferredSize(new Dimension(1350,720));
		frame.setBackground(Color.black);
		frame.setLayout(null);
		 exit=new JButton("Exit");
		 exit.setLocation(1250, 0);

		 Button1 = new JButton("One Player");
		 Button2 = new JButton("Two Players");
		Button1.setFont(new Font("Sans Serif", Font.BOLD, 30));
		exit.setFont(new Font("Sans Serif", Font.BOLD, 10));

		Button2.setFont(new Font("Sans Serif", Font.BOLD, 30));
		Button1.setSize(new Dimension (220,80));
		Button2.setSize(new Dimension (220,80));
		exit.setSize(new Dimension (100,50));

		Button1.setLocation(30, 100);
		Button2.setLocation(1100, 100);
		Button1.setBackground(Color.white);

		Button2.setBackground(Color.white);
		
		
		 
		
		 frame.add(exit);

	    frame.add(Button1);
	    frame.add(Button2);
	    
	    Button1.setActionCommand("Test");
	    Button1.setEnabled(true);

		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
		
	}	
	public void add(){
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		 exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					}
		 });
		 
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 if (arg0.getSource()==Button1){
			 try {
				 
				 control c=new control(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
		 else if(arg0.getSource()==Button2){
			 
			 try {
					control c=new control(2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
	}
}
