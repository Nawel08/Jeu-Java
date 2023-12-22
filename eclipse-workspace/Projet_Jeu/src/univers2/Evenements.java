package univers2;

import representation.Event;

/**
 * Classe mère des Evenements_i (i=1,...,4)
 * @author nawel
 * Les évenements se comportant de manière assez différentes, elle ne contient donc pas beaucoup de méthode.
 */
public class Evenements implements Event {

	/**
	 * Methode pour afficher le mot a la fin de l'evenement.
	 * @param mot, mot a afficher
	 * @param e, identifiant de l'étape.
	 */
	
	public void mot_final(String mot, int e) {
		System.out.println("Félicitation vous avez fini l'étape "+e);
		System.out.println("Voici le mot: "+mot);
	}

	@Override
	public void display(String nom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Event chooseNext() {
		// TODO Auto-generated method stub
		return null;
	}
}
