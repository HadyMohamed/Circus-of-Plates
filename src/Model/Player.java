package Model;

import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Player implements Subject {
	private ArrayList<Observer> observers= new ArrayList<Observer>();
	public Shape[] shapes = new Shape[100];
	public int size;
	int playerID;
	static int counter = 0;
	private Position pos;
	private ImageIcon img;
	public int score;
	public Player(ImageIcon image, Position newPosition) {
		pos = newPosition;
		img = image;
		size=0;
		playerID = counter++;
		score=0;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public ImageIcon getImg() {
		return img;
	}
	public void setImg(ImageIcon img) {
		this.img = img;
	}
	public void notifyObserver() {
		// 	Cycle through all observers and notifies them of changes
		for(Observer observer : observers){
			observer.update(playerID);
		}
	}
	public void register(Observer newObserver) {
		// Adds a new observer to the ArrayList
		observers.add(newObserver);
	}
	
	public void unregister(Observer deleteObserver) {
		// Get the index of the observer to delete
		int observerIndex = observers.indexOf(deleteObserver);
		// Removes observer from the ArrayList
		observers.remove(observerIndex);
		
	}
	public void collectShape(Shape s){
		shapes[size] = s;
		size++;
		if(size>=3&&shapes[size-1].getColor()==shapes[size-2].getColor()&&
				shapes[size-3].getColor()==shapes[size-2].getColor()){
			notifyObserver();
			size = size-3;
			score++;
		}
		
	}
	
}
