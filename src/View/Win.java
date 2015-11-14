package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Win extends JFrame {
		ImageIcon winner= new ImageIcon(ImageIO.read(new File("winner.jpg")));

	public Win() throws IOException{ 
		setLayout(null);    
		getContentPane().setBackground(Color.white);

		setSize(new Dimension(1350,720));   
        setPreferredSize(new Dimension(1350,720));
		
	}
	public void winners(){
		JFrame f=new JFrame();
		JLabel w=new JLabel(winner);
		w.setBounds(new Rectangle(new Point(100,100 ), new Dimension(1200,500)));
   		add(w);
    	JLabel lbl=new JLabel("YOU WON!");
    	lbl.setFont(new Font("Sans Serif", Font.BOLD, 30));
    	lbl.setBackground(Color.white);
    	lbl.setBounds(new Rectangle(new Point(600, 0), new Dimension(1200,50)));
		add(lbl);
		setTitle("Game");	
		pack();
    	setResizable(false);
   		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		setLocationRelativeTo(null);
   		setVisible(true);
	}
}
