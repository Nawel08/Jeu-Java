package univers;

import java.util.Scanner;
import java.util.Random;

import representation.DecisionNode;

public class Evenements_4 extends Evenements {
	
	/*__________________________________________
	  				PIEGE 1
	 ___________________________________________*/
	
	public static boolean labyrintheTemporel(int score) {
        System.out.println("Pars où décides-tu de passer ?");
        System.out.println("1. A droite");
        System.out.println("2. A gauche");
        
        Scanner scanner = new Scanner(System.in);
        int choixUtilisateur;

        do {
            System.out.print("Entre le numéro de ton choix : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Entre un numéro valide : ");
                scanner.next();
            }
            choixUtilisateur = scanner.nextInt();
        } while (choixUtilisateur < 1 || choixUtilisateur > 2);

        return choixUtilisateur == 1; // Le bon choix mène vers le passé lointain, le mauvais mene aux gardes
    }
	
	
	/*__________________________________________
					PIEGE 2
	___________________________________________*/
	
	public static boolean miroirsDuTemps(int score) {
        System.out.println("Tu te trouve devant deux miroirs temporels mystérieux.");
        System.out.println("L'un d'eux te ramènera d'où tu viens, tandis que l'autre te permettra de rester dans le présent.");
        System.out.println("Choisissez le bon miroir pour poursuivre votre quête.");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Sélection aléatoire du bon miroir
        boolean miroirCorrect = random.nextBoolean();

        System.out.print("Choisis le miroir de votre destinée (Gauche/Droite) : ");
        String choixUtilisateur = scanner.nextLine().toLowerCase();

        if ((choixUtilisateur.equals("gauche") && miroirCorrect) || (choixUtilisateur.equals("droite") && !miroirCorrect)) {
            System.out.println("Bien joué ! Tu as choisi le bon miroir et pouvez avancer dans la salle du temps.");
            return true;
        } else {
            System.out.println("Oh non ! Tu as choisi le miroir qui te ramène à votre point de départ.");
            System.out.println("La quête est compromise. Ulysse perd 10 points.");


            return false;
        }
	}
        
        /*__________________________________________
  						PIEGE 3
 		___________________________________________*/
        
        public static boolean portesTemporelles(int score) {
            System.out.println("Devant toi se trouvent trois salles où il est ecrit 'salle du temps', mais seule une est réellement la salle du temps.");
            System.out.println("Choisis une porte (1, 2 ou 3) :");

            Scanner scanner = new Scanner(System.in);
            int choixUtilisateur;

            do {
                System.out.print("Entre le numéro de la porte choisie : ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Entre un numéro valide : ");
                    scanner.next();
                }
                choixUtilisateur = scanner.nextInt();
            } while (choixUtilisateur < 1 || choixUtilisateur > 3);

            // La porte correcte est choisie aléatoirement
            int porteCorrecte = new Random().nextInt(3) + 1;
            return choixUtilisateur == porteCorrecte;
        }
        
        /*___________________________________________________________
						Reussite des trois pieges
		____________________________________________________________*/
        
        DecisionNode dn= new DecisionNode();
        Evenements e = new Evenements();
        
        public boolean Pieges(boolean piege3, int score) {
            // Si tu n'es tombé dans aucun piège
            if (piege3) {
                score += 20;
                System.out.println("Félicitations, tu as réussi à arriver devant la salle sans tomber dans les trois pièges.");
                e.display_score(score);
                return true;
            } else {
                // Si tu es tombé dans un piège mais que ton score est > 50
                if (score > 10) {
                    System.out.println("Jeniwell peut te sauver si tu lui donnes 10 points");
                    boolean appel_fee = dn.appel_fee2();
                    if (appel_fee) {
                        score -= 10;
                        e.display_score(score);
                        return true;
                    } else {
                        tn.display("FIN");
                        return false;
                    }
                } else {
                    // Si tu as un score < 50.
                    tn.display("Ton score ne te permet pas de continuer la partie.");
                    return false;
                }
            }
        }

   
        
        /*___________________________________________________________
  				Dechiffrement du code pour entrer dans la salle
 		____________________________________________________________*/
        
        
        private String reponseJoueur(String question) {
        	System.out.println(question);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entre ta réponse : ");
            return scanner.nextLine().toLowerCase(); // Assurez-vous que la réponse est en minuscules pour une comparaison insensible à la casse
        }

        private boolean verifierReponse(String reponseAttendue, String reponseUtilisateur) {
            return reponseAttendue.equals(reponseUtilisateur);
        }
        
        
		public boolean Enigme(int score, boolean pieges) {
		
			//Vous n'êtes tombé dans aucun des trois pièges, donc vous pouvez résoudre l'enigme.
			if(pieges) {
				
				System.out.println("Toutefois, il te reste à entrer dans la pièce. Pour cela, tu dois répondre à une énigme pour déverouiller les portes.");
				String reponseAttendue = "le temps";
				String question="Qu'est ce qu'on attend et qui ne ment ?";
		        String reponseUtilisateur = reponseJoueur(question);

		        if (verifierReponse(reponseAttendue, reponseUtilisateur)) {
		            System.out.println("Bravo, la réponse est correcte ! Tu peux donc entrer donc dans la salle du Temps.");
		            System.out.println("Tu réussis à trouver le chronomètre et tu arretes le temps.");
		            //Va afficher si le joueur peut aller dans le prochain univers
		            return true;
		            
		        } else {
		            tn.display("Dommage, la réponse est incorrecte. La partie est terminée");
		            return false;
		        }
		    }
			else {
				tn.display("Se voyage s'arrête ici pour toi..");
				return false;
			}
			
		}
	
}
