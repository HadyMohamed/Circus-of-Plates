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

public class Lose extends JFrame{
String s;
ImageIcon losers= new ImageIcon(ImageIO.read(new File("gameover.png")));
		ImageIcon winner= new ImageIcon(ImageIO.read(new File("winner.jpg")));
	public Lose(String i) throws IOException{
		s=i;
		if(i==null){
			s="Game Over!";
		}
		else{
			s=i+" Won!";
		}
		setLayout(null);    
		getContentPane().setBackground(Color.white);

		setSize(new Dimension(1350,720));   
        setPreferredSize(new Dimension(1350,720));
		
		
	}
	public void loserss(){
		JFrame f=new JFrame();
		JLabel lo;
		if(s=="Game Over!"){
			lo=new JLabel(losers);

		}
		else{
			 lo=new JLabel(winner);

		}
		
		lo.setBounds(new Rectangle(new Point(100,100 ), new Dimension(1200,500)));
   		add(lo);
    	JLabel lbl=new JLabel(s);
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
