package Model;
public class NotCollected implements ShapeState {
	Shape shape;
	public NotCollected(Shape s){	
		shape = s;	
	}
	public void moveDown() {
		shape.setShapeState(shape.InPool);
		ReusablePool rp = ReusablePool.getInstance();
		rp.releaseReusable(shape);
	}
}
