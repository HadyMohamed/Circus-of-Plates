package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.channels.FileChannel;
import java.nio.file.Files;


public class DynamicLinkage implements Serializable {
	
	private URLClassLoader loader1;

	public DynamicLinkage ()
	{}
		
	@SuppressWarnings("deprecation")

	
   public Class classLoader (String path,String className) { 
         	URL[] classPath = null;
        	File file = new File(path);
        	String l = file.toURI().toString();
        	
        	try {
				URL u = new URL(l);
				classPath = new URL[]{u};
                URLClassLoader classLoader= new URLClassLoader(classPath);;
                Class Cl;
                String temp="Model."+className;
				Cl = classLoader.loadClass(temp);              
                return Cl;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        	return null;
    }  

 

}
