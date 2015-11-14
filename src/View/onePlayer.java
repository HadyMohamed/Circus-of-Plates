package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.Timer;

import Controller.control;
import Model.*;


public class onePlayer extends JPanel implements KeyListener, ActionListener {
	JFrame frame;
	boolean flags1=false,flags2=false,flags3=false;
int x=0;
int MaximumY=565;
private int xd,yd;
static JLabel label;
ImageIcon icon= new ImageIcon(ImageIO.read(new File("alex1.png")));

ImageIcon bg= new ImageIcon(ImageIO.read(new File("bigtop1.jpg")));
ImageIcon cannon=new ImageIcon(ImageIO.read(new File("zebra.png")));
String s;
ReusablePool reusablePool = ReusablePool.getInstance();
Player player=new Player(icon,new Position(x,500));
ArrayList<Shape> shapes = new ArrayList<Shape>();
Score score = new Score(player);
int s1 = score.score1;
boolean flag=false;
	public onePlayer(String input) throws IOException{
		s=input;

		 
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
		move();
		g.drawImage ( icon.getImage (), x, 500, null );
		int fontSize = 40;
	    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
	    g.setColor(Color.yellow);
	    g.drawString(s+" "+score.score1, 15, 35);
	    if(shapes.size()<50)
	    shapes.add(reusablePool.acquireReusable());
	    for(int i=0;i<shapes.size();i++){
	    	if(shapes.get(i).getPos().getY()>700){
	    		reusablePool.releaseReusable(shapes.remove(i));
	    	}
	    	if(shapes.get(i).getPos().getY()==MaximumY && shapes.get(i).getPos().getX()<x+40 && shapes.get(i).getPos().getX()>x){
	    		MaximumY-=20;
	    		player.collectShape(shapes.remove(i));
	    		if(score.score1!=s1){
	    			MaximumY+=60;
	    			s1++;
	    		}
	    	}
	    	if(MaximumY<20 && flag==false){
	    		flag=true;

	    		try {	   
					Lose l=new Lose(null);
					l.loserss();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    		
	    	}
	    	if(score.score1>=10 && flag==false){	    			
					flag=true;

	    		try {
					Win w=new Win();
					w.winners();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	}
	    	if(flag==true){
	    		break;
	    	}
	    }
	    if(flag==false){
	    for(int i=0;i<shapes.size();i++){
	    	
	    	shapes.get(i).draw(g);
	    	
	    	shapes.get(i).moveDown();
	    }
	    for(int i=0;i<player.size;i++){
	    	player.shapes[i].draw(g);
	    }
		repaint();
	    }
	   
	}
	public void drawPlayer()throws IOException{
		
		onePlayer p=new onePlayer(s);
		 frame= new JFrame();
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
			
			x+=5;
			xd=1;
			if(x>1130){
				xd=0;
				x-=5;
			}
			player.setPos(new Position(x, 500));
			for(int i=0;i<player.size;i++){
				player.shapes[i].setPos(new Position(x+35, player.shapes[i].getPos().getY()));
			}
		}
		if(c==KeyEvent.VK_LEFT){
			xd=-1;
			x-=5;
			if(x<-20){
				xd=0;
				x+=5;
			}
			player.setPos(new Position(x, 500));
			for(int i=0;i<player.size;i++){
				player.shapes[i].setPos(new Position(x+35, player.shapes[i].getPos().getY()));
			}
		}
		
		if(17==c)
        {
            flags1=true;
        }
		
        if(83==c)
        {
            flags2=true;
        }
        if(76==c){
        	flags3=true;
        }
        if(flags1==true && flags2==true)
        {
         System.out.println("saved"); 
        }
        if(flags1==true && flags3==true){
        	System.out.println("Load");
              System.exit(0);

        }
		
//		try {
//			onePlayer p=new onePlayer(s);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		xd=0;
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	private void move(){
		x+=xd;
		player.setPos(new Position(x, 500));
		for(int i=0;i<player.size;i++){
			player.shapes[i].setPos(new Position(x+35	, player.shapes[i].getPos().getY()));
		}
	}
	
}
