package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;

import javax.swing.JFileChooser;

import com.thoughtworks.xstream.XStream;

import Model.*;

public class Save {
	Player player1 , player2;
	Caretaker caretaker;
	Originator originator;
	XStream xstream = new XStream();

	public Save(Player newplayer1,Player newplayer2){
		player1 = newplayer1;
		player2 = newplayer2;
		caretaker = new Caretaker();
		originator = new Originator();
		perform();
	}
	private void perform() {
		originator.set(player1);
		caretaker.addMemento( originator.storeInMemento() );
		originator.set(player2);
		caretaker.addMemento( originator.storeInMemento() );
		String path = fileChose();
		if(path!=null){
	    	path = path.replaceAll("\\\\", "\\\\\\\\");
	    	FileOutputStream fout;
			
	    	try{
	    		String xml = xstream.toXML(caretaker);
    	        Writer output = null;
    	        File file = new File(path);
    	        output = new BufferedWriter(new FileWriter(file));

    	        output.write(xml);

    	        output.close();
    	       // System.out.println("File has been written");

    	    }catch(Exception e){
    	        //System.out.println("Could not create file");
    	    }
		}
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
	
	

}
