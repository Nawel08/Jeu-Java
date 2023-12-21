package univers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;

import representation.DecisionNode;


public class Evenements_3 extends Evenements{

	Evenements e = new Evenements();
	DecisionNode dn = new DecisionNode();
	
	private static final int POINTS_REUSSITE = 20;
    private static final int POINTS_ECHEC = -10;
    private static final int MAX_CONSEILS = 3;
    private static final int POINTS_PAR_CONSEIL = 5;

    
    private Map<String, String> conseilsUtilises;
    private List<String> materiauxChoisis;
    
    public Evenements_3() {
        
        this.conseilsUtilises = new HashMap<>();
        this.materiauxChoisis = new ArrayList<>();
    }
    
    /**
     * Exécute l'étape 0 de la construction du Cheval de Troie.
     * L'utilisateur doit choisir les 3 bons matériaux parmi une liste prédéfinie de 5 matériaux.
     *
     * @param score le score actuel du joueur.
     * @return true si l'utilisateur a choisi les 3 bons matériaux, false sinon.
     */
    public boolean executerEtape0(int score) {
    	System.out.println("Bienvenue dans l'étape de construction du Cheval de Troie !");
        System.out.println("Étape 0 : Choisis les 3 bons matériaux parmi la liste suivante pour la construction du Cheval de Troie :");
        afficherListeMateriaux();

        for (int i = 0; i < 3; i++) {
            System.out.print("Choix " + (i + 1) + " : ");
            String choixUtilisateur = saisirMateriaux();
            materiauxChoisis.add(choixUtilisateur);
        }

        // Vérifier les choix
        if (verifierChoixMateriaux()) {
            System.out.println("Tu as trouvé la bonne composition !");
            return true;
        } else {
            System.out.println("Certains choix de matériaux ne sont pas bons ... ");
            terminerEtape(false, score);
            return false;
        }
    }

    /**
     * Permet d'afficher la liste des métriaux sous forme d'énumération
     * 
     */
    private void afficherListeMateriaux() {
        String[] listeMateriaux = {"Bois", "Métal", "Paille", "Tissu", "Cuir"};
        for (int i = 0; i < listeMateriaux.length; i++) {
            System.out.println((i + 1) + ". " + listeMateriaux[i]);
        }
    }

    /**
     * Permet à l'utilisateur d'entrer les 3 matériaux qu'il pense nécessaire 
     * pour la construction du cheval de troie.
     * @return le choix de l'utilisateur
     */
    private String saisirMateriaux() {
        Scanner scanner = new Scanner(System.in);
        int choixUtilisateur;
        do {
            System.out.print("Entre le numéro du matériau : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Merci d'entrer un numéro valide : ");
                scanner.next();
            }
            choixUtilisateur = scanner.nextInt();
        } while (choixUtilisateur < 1 || choixUtilisateur > 5);

        String[] listeMateriaux = {"Bois", "Métal", "Paille", "Tissu", "Cuir"};
        return listeMateriaux[choixUtilisateur - 1]; //Toujours enlever 1 pour eviter le decalage d'indices entre la saisi et le tableau.
    }
    /**
     * Vérifie sir l'ensemble des matériaux choisis corrrespond au bon résultat
     * @return true, si c'est el cas, et false sinon.
     */
    private boolean verifierChoixMateriaux() {
        List<String> choixCorrects = Arrays.asList("Bois", "Métal", "Paille");
        //on les tries d'abbord.
        Collections.sort(materiauxChoisis);
        Collections.sort(choixCorrects);
        return materiauxChoisis.equals(choixCorrects);
    }

    /**
     * Exécute les étapes de la construction du Cheval de Troie, demandant des commandes à l'utilisateur.
     * Les étapes incluent la définition de la taille, la couleur, et l'ajout de soldats.
     *
     * @param score le score actuel du joueur.
     * @return true si la construction est réussie, false sinon.
     */
    public boolean executerEtape(int score) {
        

        Scanner scanner = new Scanner(System.in);

        // Étape 1 : Assembler les parties
        System.out.println("Étape 1 : Definir la taille.");
        System.out.println("Il doit être petit ou grand ?");
        if (!saisirCommande("grand",score)) {
            terminerEtape(false, score);
            //j'ai enlevé le return false
        }

        // Étape 2 : Peindre le cheval
        System.out.println("Étape 2 : Definir la couleur");
        System.out.println("De quelle couleur doit être le cheval de troie ?");
        if (!saisirCommande("gris",score)) {
            terminerEtape(false, score);
            //j'ai enlevé le return false
        }

        // Étape 3 : Ajouter des soldats
        System.out.println("Étape 3 : Qui ajouter dedans");
        System.out.println("Tous le monde (1) ou bien juste Ulysse (2)");
        if (!saisirCommande("1",score)) {
            terminerEtape(false, score);
            //j'ai enlevé le return false
        }

        // Fin de la construction
        System.out.println("Construction réussie ! Tu as gagné " + POINTS_REUSSITE + " points.");
        terminerEtape(true, score);
        // Annuler le timer après la fin de la construction
        
        return true;
    }

    /**
     * Demande à l'utilisateur de saisir une commande et vérifie si elle correspond à la commande attendue.
     * En cas d'erreur, il peut demander un conseil à la fée jeniwell.
     *
     * @param commandeAttendue la commande attendue.
     * @return true si la commande est réussie, false sinon.
     */
    
    private boolean saisirCommande(String commandeAttendue, int score) {
        System.out.print("Saisie la commande : ");
        Scanner scanner = new Scanner(System.in);
        String saisieUtilisateur = scanner.nextLine().toLowerCase();

        if (saisieUtilisateur.equals(commandeAttendue)) {
            System.out.println("Commande réussie !");
            return true;
        } else {
            System.out.println("Commande incorrecte.");
            demanderConseil(score);
            return false;
        }
    }

    /**
     * Permet au joueur de demander un conseil à jeniwell, elle fourni un conseil si disponible, et pénalise le score (grâce à une méthode).
     */
    private void demanderConseil(int score) {
        if (conseilsUtilises.size() < MAX_CONSEILS) {
            String conseil = obtenirConseil();
            if (conseil != null) {
                System.out.println(conseil);
                penaliserPourConseil(score);
            } else {
                System.out.println("Désolé, aucun conseil disponible pour le moment.");
            }
        } else {
            System.out.println("Tu as atteint le nombre maximal de conseils.");
        }
    }

    /**
     * Permet d'obtenir un conseil en fonction de l'étape actuelle de la construction.
     *
     * @return le conseil obtenu.
     */
    private String obtenirConseil() {
        String etapeActuelle = obtenirEtapeActuelle();
        switch (etapeActuelle) {
            case "etape_1":
                return "Conseil pour l'étape 1 : Ce n'est pas petit...";
            case "etape_2":
                return "Conseil pour l'étape 2 : Ca commence par la lettre 'g'.";
            case "etape_3":
                return "Conseil pour l'étape 3 : Ulysse s'enuirait seul ...";
            default:
                return null;
        }
    }

    /**
     * Obtient l'étape actuelle de la construction en demandant à l'utilisateur.
     *
     * @return etape + le numero de l'étape.
     */
    private String obtenirEtapeActuelle() {
        System.out.print("À quelle étape êtes-vous actuellement ? (1/2/3) : ");
        Scanner scanner = new Scanner(System.in);
        return "etape_" + scanner.nextLine().toLowerCase();
    }

    /**
     * Pénalise le score du joueur pour l'utilisation d'un conseil.
     *
     * @param score le score actuel du joueur.
     */
    
    private void penaliserPourConseil(int score) {
        score -= POINTS_PAR_CONSEIL;
        conseilsUtilises.put(obtenirEtapeActuelle(), "utilise");
    }

    /**
     * Termine une étape en ajustant le score du joueur et affiche le résultat.
     *
     * @param reussite true si l'étape précédente est réussie, false sinon.
     * @param score: le score actuel du joueur.
     * @return true si l'étape est réussie, false sinon.
     */
    
    private boolean terminerEtape(boolean reussite, int score) {
        if (reussite) {
            score += POINTS_REUSSITE;
            System.out.println("Félicitations ! Tu as gagné " + POINTS_REUSSITE + " points.");
            e.display_score(score);
        } else {
            score += POINTS_ECHEC;
            System.out.println("Tu perds " + Math.abs(POINTS_ECHEC) + " points.");
            e.display_score(score);
        }
        return reussite;
    }

    /**
     * Obtient le score actuel du joueur.
     *
     * @return le score actuel du joueur.
     */
    public int getScore() {
        return score;
    }

    
  
	
}
