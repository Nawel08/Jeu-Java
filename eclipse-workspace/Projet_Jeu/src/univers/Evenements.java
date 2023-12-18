package univers;
import representation.TerminalNode;
public class Evenements {

	TerminalNode tn = new TerminalNode();

	
	protected int score;
    
    protected boolean mission;

 
	public boolean Passage(boolean passage) {
		if (passage) {
			System.out.println("Felicitation, tu passes à l'étape suivante :)");
			return true;
		}
		else {
			tn.display("L'aventure s'arrête ici pour toi.");
			return false;
			
		}	
	}
	
	public void display_score(int score) {
		System.out.println("Score : "+score);
	}
    
    
}
