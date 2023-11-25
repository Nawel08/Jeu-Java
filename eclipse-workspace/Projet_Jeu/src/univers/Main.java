package univers;
import univers.Personnage_Joueur;
import univers.Evenements_1;

public class Main {
	public static void main (String[] args) {
		
		//On utilise une méthode crée pour afficher l'introduction.
		String introduction="En se baladant dans un endroit mystérieux, votre personnage actionne sans le vouloir le Temporal Explorer, la machine permettant de voyager dans le temps.";
	    //On crée une instance de notre classe Personnage joueur pour pouvoir éxécuter les méthodes associées à cette classe.
		Personnage_Joueur pj= new Personnage_Joueur("test",0,"test"); //Erreur si on crée un constructeur vide, donc on procède ainsi.
		pj.Intro(introduction);
		
		//Création d'une instance de la classe Personnage_Non_Joueur.
		Personnage_Non_Joueur pnj= new Personnage_Non_Joueur("", 0, 0, false); //Pareil que précedement, je n'arrive pas à ajouter de constructeur sans argument.
		
		//Présentation des personnages:
		//Dans le futur, on veillera à ajouter dans l'appel de chaque méthode l'apparition d'un avatar.
		pj.Presentation_fee();
		pnj.Presentation();
		
		//On demande au joueur de choisir son personnage
		pj.Genre(); 
		
		//On affiche le contenu de l'étape 1:
		Evenements_1 e1= new Evenements_1();
		e1.afficherEtapes();
		
		//Les méthodes suivantes auront plus de sens lorsque la partie graphique sera terminée.
		e1.Combat(); //Le joueur combat
		e1.Defi(); //Le joueur relève le defi
		e1.Issue(); //La méthode nous indique s'il peut passer au niveau superieur.
		
		//Bien entendu l'affichage suivant sera conditonné en utilisant les structures conditionnelles vu en cours.
		//Toutefois, nous attendons pour cela d'avoir finalisé nos méthodes.
		
		//On affiche le contenu de l'étape 2:
		Evenements_2 e2= new Evenements_2();
		e2.afficherEtapes();
		e2.Attaque();
		e2.mission();
		
		
		Evenements_3 e3= new Evenements_3();
		e3.afficherEtapes();
		e3.ConstructionCheval();
		e3.Issue();
		
		Evenements_4 e4= new Evenements_4();
		e4.afficherEtapes();
		e4.Issue();
		
	
	}

}
