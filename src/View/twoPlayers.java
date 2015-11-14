package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.Load;
import Controller.Save;
import Model.Player;
import Model.Position;
import Model.ReusablePool;
import Model.Score;
import Model.Shape;

public class twoPlayers extends JPanel implements KeyListener, ActionListener {
int x2=0,x1=1100;
int MaximumY1=565;
int MaximumY2=545;
int xd1,xd2;
String s1,s2;
boolean flags1=false,flags2=false,flags3=false;

ReusablePool reusablePool = ReusablePool.getInstance();

static JLabel label;
ImageIcon icon= new ImageIcon(ImageIO.read(new File("alex1.png")));
ImageIcon bg= new ImageIcon(ImageIO.read(new File("bigtop1.jpg")));
ImageIcon icon2= new ImageIcon(ImageIO.read(new File("j.png")));
Player player1=new Player(icon,new Position(x1,500));
Player player2=new Player(icon2,new Position(x2,500));

ArrayList<Shape> shapes1 = new ArrayList<Shape>();
ArrayList<Shape> shapes2 = new ArrayList<Shape>();

Score score1 = new Score(player1);
Score score2 = new Score(player2);
boolean flag=false;
int sc1 = score1.score1;
int sc2= score2.score2;

	public twoPlayers(String input1,String input2) throws IOException{
		s1=input1;
		s2=input2;
		setSize(new Dimension(1350,720));   
        setPreferredSize(new Dimension(1350,720));
		addKeyListener(this);
		setFocusable(true);
		Timer timer = new Timer(25 , this);
		timer.start();
	}
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.drawImage ( bg.getImage (), -65, -65, null );
		g.drawImage ( icon.getImage (), x1, 500, null );
		g.drawImage (icon2.getImage (), x2, 500, null);
		move();
		int fontSize = 40;

	    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));	     
	    g.setColor(Color.yellow);
	    g.drawString(s1+" "+score1.score1, 15, 35);
	    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
	    g.setColor(Color.yellow);
	    g.drawString(s2+" "+score2.score2, 1100, 35);
	    if(shapes1.size()<50)
		    shapes1.add(reusablePool.acquireReusable());
	    if(shapes2.size()<50)
		    shapes2.add(reusablePool.acquireReusable());
	    for(int i=0;i<shapes1.size();i++){
	    	if(shapes1.get(i).getPos().getY()>700){
	    		reusablePool.releaseReusable(shapes1.remove(i));
	    	}
	    	if(shapes1.get(i).getPos().getY()==MaximumY1 && shapes1.get(i).getPos().getX()<x1+40 && shapes1.get(i).getPos().getX()>x1){
	    		MaximumY1-=20;
	    		player1.collectShape(shapes1.remove(i));
	    		if(score1.score1!=sc1){
	    			MaximumY1+=60;
	    			sc1++;
	    		}
	    	}
	    	if(MaximumY1<20 && flag==false){
	    		flag=true;

	    		try {	   
					Lose l=new Lose(s1);
					l.loserss();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	    	if(MaximumY2<20 && flag==false){
	    		flag=true;

	    		try {	   
					Lose l=new Lose(s2);
					l.loserss();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	    	if(flag==true){
	    		break;
	    	}
	    }
	    if(flag==false){
	    for(int i=0;i<shapes2.size();i++){
	    	if(shapes2.get(i).getPos().getY()>700){
	    		reusablePool.releaseReusable(shapes2.remove(i));
	    	}
	    	if(shapes2.get(i).getPos().getY()==MaximumY2 && shapes2.get(i).getPos().getX()<x2+40 && shapes2.get(i).getPos().getX()>x2){
	    		MaximumY2-=20;
	    		player2.collectShape(shapes2.remove(i));
	    		if(score2.score2!=sc2){
	    			MaximumY2+=60;
	    			sc2++;
	    		}
	    	}
	    	if(MaximumY2<20){
	    		//GameOver
	    	}
	    	if(score2.score2>=30){
	    		//winner
	    	}
	    }
	    for(int i=0;i<shapes1.size();i++){
	    	
	    	shapes1.get(i).draw(g);
	    	
	    	shapes1.get(i).moveDown();
	    }
	    for(int i=0;i<shapes2.size();i++){
	    	
	    	shapes2.get(i).draw(g);
	    	
	    	shapes2.get(i).moveDown();
	    }
	    for(int i=0;i<player1.size;i++){
	    	player1.shapes[i].draw(g);
	    }
	    for(int i=0;i<player2.size;i++){
	    	player2.shapes[i].draw(g);
	    }
		repaint();
	    }
	}
	public void drawPlayers()throws IOException{
		Player player1=new Player(icon,new Position(x1,500));
		Player player2=new Player(icon2,new Position(x2,500));

		twoPlayers p=new twoPlayers(s1,s2);
		JFrame frame= new JFrame();
		frame.add(p);
		frame.setTitle("Game");
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int c= e.getKeyCode();
		if(c==KeyEvent.VK_RIGHT){
			
			x1+=5;
			xd1=1;
			if(x1>1130){
				xd1=0;
				x1-=5;
			}
			player1.setPos(new Position(x1, 500));
			for(int i=0;i<player1.size;i++){
				player1.shapes[i].setPos(new Position(x1+35, player1.shapes[i].getPos().getY()));
			}
		}
		if(c==KeyEvent.VK_LEFT){
			
			x1-=5;
			xd1=-1;
			if(x1<-20){
				xd1=0;
				x1+=5;
			}
			for(int i=0;i<player1.size;i++){
				player1.shapes[i].setPos(new Position(x1+35, player1.shapes[i].getPos().getY()));
			}
		}
		if(c==KeyEvent.VK_D){
			
			x2+=5;
			xd2=1;
			if(x2>1130){
				xd2=0;
				x2-=5;
			}
			for(int i=0;i<player2.size;i++){
				player2.shapes[i].setPos(new Position(x2+35, player2.shapes[i].getPos().getY()));
			}
		}
		if(c==KeyEvent.VK_A){
			
			x2-=5;
			xd2=-1;
			if(x2<-20){
				xd2=0;
				x2+=5;
				
			}
			for(int i=0;i<player2.size;i++){
				player2.shapes[i].setPos(new Position(x2+35, player2.shapes[i].getPos().getY()));
			}
		}
		
        if(c==KeyEvent.VK_S)
        {
          flags1 = false;
          flags2 = false;
          Save save = new Save(player1,player2);
          //System.exit(0);
          
        }
        if(c==KeyEvent.VK_L){
             // System.exit(0);
            flags1 = false;
            flags3 = false;
            Load load = new Load();
            Player temp1 = load.getPlayer1();
            Player temp2 = load.getPlayer2();
            score1.score1 = temp1.score;
            score2.score2 = temp2.score;
            sc1 = score1.score1;
            sc2= score2.score2;
            player1.size = temp1.size;
            player2.size = temp2.size;
            player1.score = temp1.score;
            player2.score = temp2.score;
            player1.setPos(temp1.getPos());
            player2.setPos(temp2.getPos());
            for(int i=0;i<temp1.size;i++){
            	player1.shapes[i] = temp1.shapes[i];
            }
            for(int i=0;i<temp2.size;i++){
            	player2.shapes[i] = temp2.shapes[i];
            }
             MaximumY1=565-20*player1.size;
             MaximumY2=545-20*player2.size;
        }
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		xd1=0;
		xd2=0;
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	private void move(){
		x1+=xd1;
		x2+=xd2;
		player1.setPos(new Position(x1, 500));
		for(int i=0;i<player1.size;i++){
			player1.shapes[i].setPos(new Position(x1+35	, player1.shapes[i].getPos().getY()));
		}
		player2.setPos(new Position(x2, 500));
		for(int i=0;i<player2.size;i++){
			player2.shapes[i].setPos(new Position(x2+35	, player2.shapes[i].getPos().getY()));
		}
	}
}
