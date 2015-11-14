package Model;

public class Memento {
	
	// The article stored in memento Object
	
	private Player player;

	// Save a new article String to the memento Object
	
	public Memento(Player playerSave) { player = playerSave; }
	
	// Return the value stored in article 
	
	public Player getSavedArticle() { return player; }
	
}