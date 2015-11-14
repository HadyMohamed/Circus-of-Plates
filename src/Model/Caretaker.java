package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Caretaker  {
	// Where all mementos are saved
	
		ArrayList<Memento> savedPlayers = new ArrayList<Memento>();

		// Adds memento to the ArrayList
		
		public void addMemento(Memento m) { savedPlayers.add(m); }
	   
		// Gets the memento requested from the ArrayList
		
		public Memento getMemento(int index) { return savedPlayers.get(index);
		
		}
		
}
