package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import View.game;
import View.onePlayer;
import View.twoPlayers;

public class control extends JFrame{
	
	JTextField txt=new JTextField(30);
	JTextField txt2=new JTextField(30);
	JLabel label=new JLabel("Player Name:");
	JLabel label2=new JLabel("Second Player Name:");
	JLabel ll=new JLabel();

	String input;
	String input2;
	

	JPanel jp=new JPanel();
	public control(int i) throws IOException{
		if(i==1){		
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(500,100);		
			setLocationRelativeTo(null);
			jp.add(label);
			jp.add(txt);
			txt.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {	
					 input=txt.getText();
						setVisible(false);

					 try{
							onePlayer one=new onePlayer(input);
							one.drawPlayer();
							}
							catch(Exception t){
								
							}
					
				}
			});					
			jp.add(ll);
			
			add(jp);

		}
		if(i==2){		
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(500,150);
			setLocationRelativeTo(null);
			jp.add(label);
			jp.add(txt);
			jp.add(label2);
			jp.add(txt2);
			txt.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					 input=txt.getText();
				}	
			});
			txt2.addActionListener(new ActionListener(){

				

				@Override
				public void actionPerformed(ActionEvent e) {
					 input2=txt2.getText();
					 try{
							twoPlayers two=new twoPlayers(input,input2);
							setVisible(false);
							two.drawPlayers();
							}
							catch(Exception t){
								
							}
				}	
			});
			
			add(jp);

		}
		
	}

public static void main(String[] args) throws IOException {
		game ga=new game();		
		ga.add();
	}


	
}


