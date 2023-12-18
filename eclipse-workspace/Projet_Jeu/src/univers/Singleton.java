package univers;
import java.util.*;
/*
Comme il n'y aura qu'une fée, on aura besoin de créer qu'une instance.
On utilise donc pour cela le design pattern singleton. 
*/
public class Singleton {
	
	public static final String description = 
	"Je m'appelle Jeniwell, je  t'accompagne dans ce fabuleux voyage dans le temps. "+
	"Lorsque tu échoueras les missions, je serais à tes côtés pour te redonner une chance. Mais attention a toujours maintenir un score >0, sinon je ne pourrais plus t'aider :(";
	

	private static Singleton instance = null;
	//retourne l'unique instance de la classe.
	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
			return instance;
	}
	
	public String display(String description) {
		return description;
	}
	
	public static boolean defi1(String question, String reponseCorrecte) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String reponseUtilisateur = scanner.nextLine();
        return reponseUtilisateur.equalsIgnoreCase(reponseCorrecte);
    }
	public static boolean defi_e1() {
        System.out.println("Ulysse a été blessé! La fée magique, Jeniwell, propose de relever un défi pour le guérir.");
        System.out.println("Défi de la fée magique : Retrouvez les paires de cartes identiques pour obtenir la guérison.");

        // Ajoutez ici le code pour le défi de la fée (similaire au jeu de mémoire)
        boolean reussi = jeuDeMemoire();

        return reussi;
    }

    private static boolean jeuDeMemoire() {
        // Cartes du jeu de mémoire
        
        String[] cartes = {"A", "F", "F", "C", "C", "A"};



        // Tableau pour suivre les cartes déjà retournées
        boolean[] cartesRetournees = new boolean[cartes.length];

        // Nombre de tentatives restantes
        int tentativesRestantes = 6;

        // Scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Boucle principale du jeu
        while (tentativesRestantes > 0) {
            afficherCartes(cartes, cartesRetournees);

            // Lire l'entrée de l'utilisateur
            System.out.println("Tentatives restantes : " + tentativesRestantes);
            System.out.print("Entre le numéro de la première carte : ");
            int choix1 = scanner.nextInt()-1; //Comme on est dans un tableau l'element correspond au 0, donc on enleve à chaque fois 1.
            System.out.print("Entre le numéro de la deuxième carte : ");
            int choix2 = scanner.nextInt()-1;

            // Vérifier si les cartes sont identiques mais les indices différents !! sinon on peut entrer 1 1 ca va renvoyer true.
            if (cartes[choix1].equals(cartes[choix2]) && choix1!=choix2) {

                System.out.println("Bravo ! Tu as trouvé une paire !");
                cartesRetournees[choix1] = true;
                cartesRetournees[choix2] = true;
                tentativesRestantes--; //on décremente de 1 le nombre de tentatives restantes.
            } else {
                System.out.println("Dommage ! Les cartes ne sont pas identiques.");
                tentativesRestantes--;
            }

            // Vérifier si toutes les paires ont été trouvées
            if (toutesPairesTrouvees(cartesRetournees)) {
                System.out.println("Félicitations ! Tu as trouvé toutes les paires !");
                return true;
            }

            // Pause avant de continuer
            System.out.println("Appuie sur Entrée pour continuer...");
            scanner.nextLine(); // Attendre l'entrée de l'utilisateur
            scanner.nextLine(); // Attendre l'entrée de l'utilisateur pour la pause
        }

        System.out.println("Dommage, tu n'as pas réussi à trouver toutes les paires. Le défi est échoué.");
        return false;
    }
    


    private static void afficherCartes(String[] cartes, boolean[] cartesRetournees) {
        System.out.println("Cartes :");
        for (int i = 0; i < cartes.length; i++) {
            if (cartesRetournees[i]) {
                System.out.print("[" + cartes[i] + "] ");
            } else {
                System.out.print("[?] ");
            }
        }
        System.out.println();
    }

    private static boolean toutesPairesTrouvees(boolean[] cartesRetournees) {
        for (boolean retournee : cartesRetournees) {
            if (!retournee) {
                return false;
            }
        }
        return true;
    }
	
}
