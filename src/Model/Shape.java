package Model;

import java.awt.Color;
import java.awt.Graphics;


public abstract class Shape {
	ShapeState Falling;
	ShapeState Collected;
	ShapeState NotCollected;
	ShapeState InPool;
	private Position pos;
	private Color color;
	ShapeState shapeState;
	public Shape(){}

	public Shape(Position pos , Color color){
		Falling  = new Falling(this);
		Collected  = new Collected(this);
		NotCollected  = new NotCollected(this);
		InPool  = new InPool(this);
		setPos( pos);
		setColor(color);
		shapeState = Falling;
	}
	public void setShapeState(ShapeState newShapeState){
		shapeState = newShapeState;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
    public abstract void draw(Graphics g);
    
	public void moveDown(){
		shapeState.moveDown();
	}

}
