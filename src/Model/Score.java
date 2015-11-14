package Model;

public class Score implements Observer {
    private Subject player;
    public static int score1=0 , score2=0;
	public Score(Subject player){
		// Store the reference to the stockGrabber object so
		// I can make calls to its methods
		this.player = player;
		// Add the observer to the Subjects ArrayList
		player.register(this);
		
	}

	@Override
	public void update(int ID) {
		if(ID==1)
			score1++;
		else if(ID==2)
			score2++;
		if(ID==4)
			score1++;
		else if(ID==5)
			score2++;
		
	}

}
