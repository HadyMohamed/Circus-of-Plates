package Model;

public class Position {
	private int x,y;
	public Position(int newX,int newY){
		setX(newX);
		setY(newY);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
