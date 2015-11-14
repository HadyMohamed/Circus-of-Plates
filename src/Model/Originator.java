package Model;

public class Originator {
	private Player player;

	// Sets the value for the article
	
	public void set(Player newplayer) { 
	    this.player = newplayer; 
	}

	// Creates a new Memento with a new article
	
	public Memento storeInMemento() { 
	    return new Memento(player); 
	}
	   
	// Gets the article currently stored in memento
	
	public Player restoreFromMemento(Memento memento) {
		player = memento.getSavedArticle(); 		
		return player;
	   
	}
	
}
