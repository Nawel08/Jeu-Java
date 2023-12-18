package univers;


public class Personnage {
	// On met nos attributs en protected pour qu'ils soient accesible dans les classes filles et dans le meme package.
	public Personnage() {
		
	}
	protected String prenom;
	protected String sexe;

	

	public Personnage(String prenom, int score) {
		
	}

	protected int score1; //le nouveau score pour les cas ci dessous:
	public int Apprecier(boolean mission,int score) {
		//Deja il faut borner notre score
		
		if(score<0 || score>100) {
			if(score<0) {
				
				System.out.println("Ton score ne pouvant être négatif, la partie est terminé./r /n"+
				"Score: "+score1);
				return (score1=0);
				}

			else {
				
				System.out.println("Ton score ne pouvant depasser 100, la partie est terminé./r /n"+ "FELICITATION /r /n" + "Score: "+score1);
				return (score1=100);
		}
		
		
	}
		return score;
	
	
	}

}