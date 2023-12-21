package univers;
import representation.TerminalNode;
public class Evenements {

	TerminalNode tn = new TerminalNode();

	
	protected int score;
    
    protected boolean mission;

    /**
     * Indique à l'utilisateur s'il passe à l'étape suivant ou non.
     * @param passage: fait référence à la derniere méthode
     * @return: si la derniere méthode a été réussie on renvoie true, sinon on renvoie false.
     */
 
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
	
	/**
	 * Méthode pour afficher le score
	 * @param score: score du joueur
	 */
	public void display_score(int score) {
		System.out.println("Score : "+score);
	}
    
    
}
