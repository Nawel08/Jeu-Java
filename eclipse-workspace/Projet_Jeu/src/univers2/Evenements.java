package univers2;

/**
 * Classe mère des Evenements_i (i=1,...,4)
 * @author nawel
 * Les évenements se comportant de manière assez différentes, elle ne contient donc pas beaucoup de méthode.
 */
public class Evenements {

	/**
	 * Methode pour afficher le mot a la fin de l'evenement.
	 * @param mot, mot a afficher
	 * @param e, identifiant de l'étape.
	 */
	
	public void mot_final(String mot, int e) {
		System.out.println("Félicitation vous avez fini l'étape "+e);
		System.out.println("Voici le mot: "+mot);
	}
}
