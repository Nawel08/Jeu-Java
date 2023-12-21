package univers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evenements_2 extends Evenements {


    Evenements_1 e1 = new Evenements_1();
    
    /**
     * Cette méthode est le coeur de notre classe, Ulysse doit deviner quel est le meilleur moyen d'entrer dans Troie.
     * @param score, qui correspond au score d'Ulysse.
     * @return un boolean qui vaut vrai si Ulysse a trouvé le bon mot, et false sinon.
     */
    public static boolean etape2(int score) {
        System.out.println("Ulysse se rend compte que la meilleure manière d'entrer dans Troie n'est pas de l'attaquer. Il a besoin ton aide pour trouver le bon moyen pour entrer.");
        System.out.println("Tu as trois chances pour trouver le meilleur moyen d'entrer dans Troie.");

        // Mot correct
        final String motCorrect = "Cheval de Troie".toLowerCase();

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

    
    /**
     * Méthode qui va comparer si l'ensemble des lettres devinées correspond bien au mot.
     * 
     * @param proposition, proposition faites par l'utilisateur.
     * @param motCorrect, fait référence à: final String motCorrect = "Cheval de Troie".toLowerCase();
     * @param lettresDevinées, tableau où on a stocké les lettres devinées
     * @return elle retourne un booleen vaut true si la réponse est correcte, et false sinon.
     * 
     */

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

    /**
     * Vérifie si une lettre a déjà été trouvée parmi les lettres devinées.
     *
     * @param lettre la lettre à rechercher.
     * @param lettresDevinées tableau des lettres devinées.
     * @return true si la lettre a déjà été trouvée, false sinon.
     * 
     */
    private static boolean lettreDejaTrouvee(char lettre, char[] lettresDevinées) {
        for (char lettreDevinee : lettresDevinées) {
            if (lettreDevinee == lettre) {
                return true; // La lettre a déjà été trouvée
            }
        }
        return false; // La lettre n'a pas été trouvée
    }

    /**
     * Affiche le mot en remplaçant les lettres non devinées par des tirets.
     *
     * @param motCorrect:  le mot correct à afficher.
     * @param lettresDevinées: tableau des lettres devinées.
     */
    
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

    /**
     * Met à jour les lettres devinées en fonction de la proposition de l'utilisateur.
     *
     * @param motCorrect le mot correct à comparer.
     * @param lettresDevinées tableau des lettres devinées.
     * @param proposition la proposition de l'utilisateur.
     * 
     */
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
