package Model;

import java.awt.Color;
import java.util.Random;

public class ShapeFactory {
	Color[] colors = {Color.RED , Color.BLUE , Color.yellow};
	public Shape MakeShape(int choice , Position pos){
		Random rand = new Random();
		int randomNum = rand.nextInt((2 - 0) + 1) + 0;
	     if (choice==0){
	    	 String path = "bin\\Model\\Circle.class";
	    	 DynamicLinkage dl = new DynamicLinkage();
	    	 Class clas = dl.classLoader(path, "Circle");
	    	 Circle n = null ;
	    	 try {
				 n = (Circle) clas.newInstance();
				 n.setPos(pos);
				 n.setColor(colors[randomNum]);
				 n.Falling  = new Falling(n);
				n.Collected  = new Collected(n);
				n.NotCollected  = new NotCollected(n);
				n.InPool  = new InPool(n);
				n.shapeState = n.Falling;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	 return n;
	     } else if (choice==1){ 
	    	 String path = "bin\\Model\\Square.class";
	    	 DynamicLinkage dl = new DynamicLinkage();
	    	 Class clas = dl.classLoader(path, "Square");
	    	 Square n = null ;
	    	 try {
				 n = (Square) clas.newInstance();
				 n.setPos(pos);
				 n.setColor(colors[randomNum]);
				 n.Falling  = new Falling(n);
				n.Collected  = new Collected(n);
				n.NotCollected  = new NotCollected(n);
				n.InPool  = new InPool(n);
				n.shapeState = n.Falling;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	 return n;
	     } else return null;
		
	 }
//	public static void main(String[] args) {
//		Shape s = MakeShape(0, new Position(0, 0));
//		System.out.println(s.getPos().getX());
//	}
}
