package Model;
public class Falling implements ShapeState {
	Shape shape;
	public Falling(Shape s){	
		shape = s;	
	}
	public void moveDown() {
		shape.setPos(new Position(shape.getPos().getX(), shape.getPos().getY()+1 ));
	}
}
