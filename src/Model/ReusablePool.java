package Model;

import java.util.Random;
import java.util.Stack;

public class ReusablePool {
    private static ReusablePool firstInstance = null;
    private static Stack<Shape> reusables;
    private ReusablePool() { }
    public static ReusablePool getInstance() {
    	if(firstInstance == null) {
    		firstInstance = new ReusablePool();
    		reusables = new Stack<Shape>();
    	}
    	return firstInstance;
    }
    public Shape acquireReusable (){
    	if(reusables.isEmpty()){
    		Random rand = new Random();
    		int choice = rand.nextInt((1 - 0) + 1) + 0;
    		int x= rand.nextInt((1300 - 50) + 1300) + 50;
    		ShapeFactory shapeFactory = new ShapeFactory();
    		return shapeFactory.MakeShape(choice, new Position(x,0));
    	}
    	Shape s = reusables.pop();
    	s.setShapeState(s.Falling);
    	Random rand = new Random();
    	int x= rand.nextInt((1300 - 50) + 1300) + 50;
    	s.setPos(new Position(x, 0));
    	return s;
    }
    public void releaseReusable(Shape s){
    	reusables.push(s);
    }
}
