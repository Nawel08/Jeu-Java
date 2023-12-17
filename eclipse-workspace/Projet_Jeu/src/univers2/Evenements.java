package univers2;

public class Evenements {

	//Methode pour afficher le mot a la fin de l'evenement.
	//NB: chaque classe a donc un string mot initialisé.
	//int e correspond au numero de l'evenement
	public void mot_final(String mot, int e) {
		System.out.println("Félicitation vous avez fini l'étape "+e);
		System.out.println("Voici le mot: "+mot);
	}
}
