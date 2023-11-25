package univers;


public class Personnage {
	// On met nos attributs en protected pour qu'ils soient accesible dans les classes filles et dans le meme package.
	
	protected String prenom;
	protected String sexe;
	public Personnage(String prenom, int score, String sexe) {
		this.prenom=prenom;
		this.score=score;
		this.sexe=sexe;
		
	}
	protected boolean mission;
	
	//Le degré de la mission va nous permettre d'attribuer les points en consequence.
	//Si degre_mission=1, quand on gagne score +20 et quand on perd score -10
	//Si degre_mission=2, quand on gagne score +10 et quand on perd score= score - score donc fin du jeu.
	
	protected int degre_mission;
	
	//Le score est intialisé à 0, on le redefinira dans la classe fille
	
	protected int score;
	//Constructeur 
	public Personnage(String prenom, int score) {
		
	}
	public int getScore() {
		return score;
	}
	protected int score1; //le nouveau score pour les cas ci dessous:
	public int Apprecier(boolean mission,int score) {
		//Deja il faut borner notre score
		
		if(score<0 || score>100) {
			if(score<0) {
				
				System.out.println("Votre score ne pouvant être négatif, la partie est terminé./r /n"+
				"Score: "+score1);
				return (score1=0);
				}

			else {
				
				System.out.println("Votre score ne pouvant depasser 100, la partie est terminé./r /n"+ "FELICITATION /r /n" + "Score: "+score1);
				return (score1=100);
		}
		
		
	}
		return score;
	
	
}
	protected static boolean issue_finale;
	public static boolean Issue_finale(int score) {
		if(score>=60) {
			System.out.println("Félictation votre score étant supérieur ou égal à 60, il vous permet donc de continuer vers un autre monde !");
			return issue_finale=true;
			}
		else {
			
			System.out.println("Votre score étant inférieur à 60, la partie s'arrête ici.");
			return issue_finale=false;
		}
		}
	}