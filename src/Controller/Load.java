package Controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JFileChooser;

import com.thoughtworks.xstream.XStream;

import Model.Caretaker;
import Model.Originator;
import Model.Player;

public class Load {
	private Player player1 , player2;
	Caretaker caretaker;
	Originator originator;
	XStream xstream = new XStream();

	public Load(){
		caretaker = new Caretaker();
		originator = new Originator();
		perform();
	}
	private void perform(){
		String path = fileChose();
    	path = path.replaceAll("\\\\", "\\\\\\\\");
    	 try{
    		 BufferedReader in =new BufferedReader(new FileReader(path));
				StringBuilder out = new StringBuilder();
		        String line;
		        while ((line = in.readLine()) != null) {
		            out.append(line);
		        }
		       String xml = out.toString();
		       caretaker = (Caretaker) xstream.fromXML(xml);
  		   
   
  	   }catch(Exception ex){
  		   ex.printStackTrace();
  	   } 
    	 setPlayer1(originator.restoreFromMemento( caretaker.getMemento(0) ));
    	 setPlayer2(originator.restoreFromMemento( caretaker.getMemento(1) )); 
    	
    	
	}
	public static String fileChose()
	{
	    JFileChooser fc= new JFileChooser();
	    int ret = fc.showOpenDialog(null);

	               if (ret== JFileChooser.APPROVE_OPTION) 
	               {
	             File file = fc.getSelectedFile();
	             String filename= file.getAbsolutePath();
	             return filename;
	            }

	           else
	             return null;
	 }
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
}
