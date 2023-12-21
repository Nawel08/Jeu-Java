package univers;


public class Personnage {
	// On met nos attributs en protected pour qu'ils soient accesible dans les classes filles et dans le meme package.
	public Personnage() {
		
	}
	protected String prenom;
	protected String sexe;

	

	public Personnage(String prenom, int score) {
		
	}

	
	
	/**
	 * Méthode qui nous permet de vérifier que notre score est toujours compris dans l'intervalle [0,100]
	 * @param score: le score actuel du joueur
	 * @return elle retourne le score du joueur non modifié (si dans l'intervalle) sinon retourne 0 ou 100 (selon le cas).
	 */
	public int Apprecier(int score) {
		//Deja il faut borner notre score
		
		if(score<0 || score>100) {
			if(score<0) {
				
				System.out.println("Ton score ne pouvant être négatif, la partie est terminé./r /n"+
				"Score: "+score);
				return (score=0);
				}

			else {
				
				System.out.println("Ton score ne pouvant depasser 100, la partie est terminé./r /n"+ "FELICITATION /r /n" + "Score: "+score);
				return (score=100);
				
		}
		
		
	}
		return score;
	
	
	}

}