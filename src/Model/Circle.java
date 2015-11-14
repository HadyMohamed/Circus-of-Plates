package Model;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	
	public Circle(){}
	public Circle(Position pos, Color color) {
		super(pos, color);
	}

	public void draw(Graphics g) {	
		g.setColor(getColor());
        g.fillOval(getPos().getX(),getPos().getY(),20,20);
        g.setColor(getColor());
        g.drawOval(getPos().getX(),getPos().getY(),20,20);
	}
}
