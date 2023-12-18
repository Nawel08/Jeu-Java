package univers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evenements_2 extends Evenements {


    Evenements_1 e1 = new Evenements_1();
    
    //Cette méthode contient le coeur de notre evenements_2.
    //Elle va faire deviner "cheval de troie" a l'utilisateur.
    public static boolean etape2(int score) {
        System.out.println("Ulysse se rend compte que la meilleure manière d'entrer dans Troie n'est pas de l'attaquer. Il a besoin ton aide pour trouver le bon moyen pour entrer.");
        System.out.println("Tu as trois chances pour trouver le meilleur moyen d'entrer dans Troie.");

        // Mot correct
        String motCorrect = "Cheval de Troie".toLowerCase();

        // Tableau pour stocker les lettres devinées
        char[] lettresDevinées = new char[motCorrect.length()];

        // Liste pour stocker les propositions de l'utilisateur
        List<String> propositionsUtilisateur = new ArrayList<>();

        // Scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Nombre maximal de tentatives
        int tentativesMax = 3;

        // Boucle pour les tentatives
        for (int tentativesRestantes = tentativesMax; tentativesRestantes > 0; tentativesRestantes--) {
            // Afficher les lettres devinées et les tirets pour les lettres non devinées
            afficherMot(motCorrect, lettresDevinées);

            // Afficher le message de proposition
            System.out.println("Tentatives restantes: " + tentativesRestantes);
            System.out.print("Propose une lettre ou le mot entier : ");

            // Lire la proposition de l'utilisateur
            String proposition = scanner.nextLine().toLowerCase();

            // Stocker la proposition de l'utilisateur
            propositionsUtilisateur.add(proposition);

            // Vérifier la proposition de l'utilisateur
            if (proposition.length() == 1) {
                // Proposition d'une lettre
                String lettreProposee = proposition;
                if (motCorrect.indexOf(lettreProposee) != -1) {
                    System.out.println("Bien joué ! La lettre est présente.");
                    // Mettre à jour les lettres devinées
                    mettreAJourLettresDevinées(motCorrect, lettresDevinées, lettreProposee);
                } else {
                    System.out.println("Dommage ! La lettre n'est pas dans le mot.");
                }
            } else if (proposition.length() == motCorrect.length() && proposition.equals(motCorrect)) {
                // Proposition du mot entier
                System.out.println("Félicitations ! Tu as trouvé le moyen d'entrer dans Troie !");
                return true; // Sortir de la méthode, défi réussi
            } else if (proposition.length() > 1 && motCorrect.contains(proposition)) {
                // Proposition du mot entier comme sous-mot correct
                System.out.println("Bien joué ! Le mot '" + proposition + "' est présent.");
                mettreAJourLettresDevinées(motCorrect, lettresDevinées, proposition);
                afficherMot(motCorrect, lettresDevinées);
                // J'ai enlevé le return true, pour que ca continue meme si un sous mot est correct.
            } else {
                System.out.println("Proposition incorrecte. Tu peux proposer une lettre ou le mot entier.");
            }

            // Afficher des indices en fonction du nombre de tentatives restantes
            if (tentativesRestantes == 2 && !lettreDejaTrouvee('c', lettresDevinées)) {
                System.out.println("Indice : La première lettre du mot est '" + motCorrect.charAt(0) + "'.");
            } else if (tentativesRestantes == 1 && !lettreDejaTrouvee(motCorrect.charAt(motCorrect.lastIndexOf(" ") + 1), lettresDevinées)) {
                System.out.println("Indice : La première lettre du dernier mot est '" + motCorrect.charAt(motCorrect.lastIndexOf(" ") + 1) + "'.");
            }

            // Pause avant la prochaine tentative
            System.out.println("Appuie sur Entrée pour continuer...");
            scanner.nextLine(); // Attendre l'entrée de l'utilisateur
        }

        // Comparer la proposition finale avec le mot correct
        String propositionFinale = String.join(" ", propositionsUtilisateur);
        if (propositionFinale.equals(motCorrect)) {
            System.out.println("Félicitations ! Tu as trouvé le moyen d'entrer dans Troie !");
            return true;
        } else {
            // Si toutes les tentatives sont épuisées
            System.out.println("Dommage ! Ulysse n'a pas réussi à trouver le moyen d'entrer dans Troie.");
            
        }
        return true;
    }

    
    //METHODES NECESSAIRES POUR LA METHODE PRECEDENTE.

    private static boolean verifierMotCorrect(String proposition, String motCorrect, char[] lettresDevinées) {
        if (proposition.length() > motCorrect.length() || proposition.length() < 2) {
            return false;
        }

        for (int i = 0; i <= motCorrect.length() - proposition.length(); i++) {
            if (motCorrect.substring(i, i + proposition.length()).equals(proposition)) {
                for (int j = i; j < i + proposition.length(); j++) {
                    lettresDevinées[j] = motCorrect.charAt(j);
                }
                return true;
            }
        }
        return false;
    }


    private static boolean lettreDejaTrouvee(char lettre, char[] lettresDevinées) {
        for (char lettreDevinee : lettresDevinées) {
            if (lettreDevinee == lettre) {
                return true; // La lettre a déjà été trouvée
            }
        }
        return false; // La lettre n'a pas été trouvée
    }

    private static void afficherMot(String motCorrect, char[] lettresDevinées) {
        System.out.print("Mots : ");
        for (int i = 0; i < motCorrect.length(); i++) {
            char lettre = motCorrect.charAt(i);
            if (lettresDevinées[i] != 0) {
                System.out.print(lettresDevinées[i] + " ");
            } else if (lettre == ' ') {
                System.out.print("  "); // Espaces non devinés
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
    }

    private static void mettreAJourLettresDevinées(String motCorrect, char[] lettresDevinées, String proposition) {
        if (proposition.length() == 1) {
            // Proposition d'une lettre
            char lettreProposee = proposition.charAt(0);
            for (int i = 0; i < motCorrect.length(); i++) {
                if (motCorrect.charAt(i) == lettreProposee) {
                    lettresDevinées[i] = lettreProposee;
                }
            }
        } else if (proposition.length() == motCorrect.length() && proposition.equals(motCorrect)) {
            // Proposition du mot entier
            for (int i = 0; i < motCorrect.length(); i++) {
                lettresDevinées[i] = motCorrect.charAt(i);
            }
        } else if (proposition.length() > 1 && motCorrect.contains(proposition)) {
            // Proposition du mot entier comme sous-mot correct
            for (int i = 0; i <= motCorrect.length() - proposition.length(); i++) {
                if (motCorrect.substring(i, i + proposition.length()).equals(proposition)) {
                    for (int j = i; j < i + proposition.length(); j++) {
                        lettresDevinées[j] = motCorrect.charAt(j);
                    }
                }
            }
        }
    }

}
