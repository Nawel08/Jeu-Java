package univers;

public class Introduction {
	
	public void display_intro() {
		System.out.println("En se baladant dans un endroit mystérieux, votre personnage actionne sans le vouloir le Temporal Explorer, la machine permettant de voyager dans le temps.");
	}
	
	public void display_but() {
		System.out.println("Le joueur devra à chaque époque prendre les décisions qui lui permettront de mener à bien ses décisions.");
	}

	//On va afficher la presentation de la fée.
	Singleton fee= new Singleton();
	public void Presentation_fee() {
		String desc_fee = fee.description;
		System.out.println(desc_fee);
	}
	// On affichera un avatar représentant la fée
}
