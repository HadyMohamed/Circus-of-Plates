package Model;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {
	public Square(){}
	public Square(Position pos, Color color) {
		super(pos, color);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {	
		g.setColor(getColor());
		g.fillRect(getPos().getX(),getPos().getY(),20,20);
        g.setColor(getColor());
        g.drawRect(getPos().getX(),getPos().getY(),20,20);
	}
}
