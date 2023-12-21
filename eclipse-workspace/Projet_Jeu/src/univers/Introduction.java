package univers;

public class Introduction {
	
	/*
	 * Méthode qui affiche l'introduction
	 */
	public void display_intro() {
		System.out.println("En se baladant dans un endroit mystérieux, votre personnage actionne sans le vouloir le Temporal Explorer, la machine permettant de voyager dans le temps.");
	}
	
	/*
	 * Méthode qui affiche le but de cet univers
	 */
	public void display_but() {
		System.out.println("Le joueur devra à chaque époque prendre les décisions qui lui permettront de mener à bien ses décisions.");
	}

	
	Singleton fee= new Singleton();
	
	/*
	 * Méthode de présentation de la fée.
	 */
	public void Presentation_fee() {
		String desc_fee = fee.description;
		System.out.println(desc_fee);
	}

}
