package univers2;

import representation.InnerNode;
import representation.DecisionNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public final class Evenements_3 extends Evenements{

    InnerNode in = new InnerNode();
    DecisionNode dn = new DecisionNode();

    /**
     * Affichage de l'objectif de l'étape.
     */
    public void objectif() {
        in.display("Tu vas devoir jouer à un jeu au cours duquel, le perdant MEURT");
    }

    /**
     * Permet au joueur de faire un choix entre deux chaînes de caractères grâce à une méthode de DecisionNode
     * @param s1, choix 1
     * @param s2, choix 2
     * @return, la chaîne de caractère choisie.
     */
    
    public int choix(String s1, String s2) {
        int choix = dn.choix_2_string_i(s1, s2);
        return choix;
    }

    private static final String API_BASE_URL = "https://api.chess.com/pub/player/";

    /**
     * Méthode qui permet de jouer aux echecs en ligne (une partie)
     * <i> Un compte a été crée sur chess.com pour cet effet </i>
     * @param playerName, le nom du compte de Marc Antoine.
     * @return truc si la partie est gagnée, false sinon.
     */
    public static boolean playChessOnline(String playerName) {
        try {
            String apiUrl = API_BASE_URL + playerName + "/games";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the response JSON and check if the player won
                // This is a simplified example; you may need to adapt it based on the Chess.com API response format
                boolean playerWon = parseChessApiResponse(response.toString());

                if (playerWon) {
                    System.out.println("Congratulations! You won the chess game.");
                } else {
                    System.out.println("Sorry, you lost the chess game.");
                }

                return playerWon;
            } else {
                System.out.println("Failed to connect to Chess.com API. HTTP Error Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    
    private static boolean parseChessApiResponse(String jsonResponse) {
        // Implement the logic to parse the Chess.com API response
        // and determine if the player won the game
        // This will depend on the actual response format from the API
        // For simplicity, let's assume the response is a JSON with a "result" field indicating the game result

        // Example JSON response: {"result": "win"}
        // You may need to adjust this based on the actual API response
        return jsonResponse.contains("\"result\": \"win\"");
    }

    /**
     * Affichage du mot secret correspondant à l'univers 2.
     * @param mot, mot secret.
     */
    public void mot_univers2(String mot) {
        System.out.println("Félicitation, tu as fini l'univers 2 !");
        System.out.println("Voici le mot associé : " + mot);
    }

    /**
     * Méthode qui permet de jouer à une variante du pierre,feuille,ciseau.
     * A l'issue de la partie, le perdant meurt.
     * @return vrai si le joueur à gagné, faux sinon.
     */
    public boolean jouerPierreFeuilleCiseaux() {
        System.out.println("Bienvenue dans le jeu de Pierre-Couteau-Marteau !");
        System.out.println("Rappel des règles :");
        System.out.println("1. Marteau bat couteau.");
        System.out.println("2. Couteau bat la pierre.");
        System.out.println("3. Pierre bat le marteau.");

        int manches = 4; // Nombre de manches
        int victoiresJoueur = 0;
        int victoiresOrdinateur = 0;

        for (int i = 0; i < manches; i++) {
            System.out.println("\nManche " + (i + 1));

            // Choix du joueur
            String choixJoueur = saisirChoixJoueur();

            // Choix de l'ordinateur
            String choixOrdinateur = genererChoixOrdinateur();

            // Affichage des choix
            System.out.println("Choix du joueur : " + choixJoueur);
            System.out.println("Choix de l'ordinateur : " + choixOrdinateur);

            // Détermination du gagnant de la manche
            String resultatManche = determinerResultatManche(choixJoueur, choixOrdinateur);

            // Affichage du résultat de la manche
            System.out.println(resultatManche);

            // Mise à jour des scores
            if (resultatManche.equals("Victoire du joueur")) {
                victoiresJoueur++;
            } else if (resultatManche.equals("Victoire de l'ordinateur")) {
                victoiresOrdinateur++;
            }
        }

        // Détermination du gagnant final
        String gagnantFinal = determinerGagnantFinal(victoiresJoueur, victoiresOrdinateur);

        // Affichage du gagnant final
        
        
        if(gagnantFinal=="Le joueur remporte la partie !") {
        	System.out.println("\n Tu as gagné !");
        	return true;
        }else {
        	System.out.println("Tu n'as pas gagné ..");
        	return false;
        }
    }

    /**
     * Permet à l'utilisateur d'entrer son choix.
     * @return
     */
    private String saisirChoixJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choisissez Pierre, Marteau ou Couteau : ");
        return scanner.nextLine().toLowerCase();
    }

    private String genererChoixOrdinateur() {
        String[] options = {"pierre", "marteau", "couteau"};
        Random random = new Random();
        int index = random.nextInt(options.length);
        return options[index];
    }

    /**
     * En fonction des règles détermine le gagnant d'une manche.
     * @param choixJoueur
     * @param choixOrdinateur
     * @return, qui a gagné.
     */
    private String determinerResultatManche(String choixJoueur, String choixOrdinateur) {
        if (choixJoueur.equals(choixOrdinateur)) {
            return "Égalité";
        } else if (
            (choixJoueur.equals("marteau") && choixOrdinateur.equals("couteau")) ||
            (choixJoueur.equals("pierre") && choixOrdinateur.equals("marteau")) ||
            (choixJoueur.equals("couteau") && choixOrdinateur.equals("pierre"))
        ) {
            return "Victoire du joueur";
        } else {
            return "Victoire de l'ordinateur";
        }
    }

    /**
     * Permet de déterminer le gagnant final.
     * @param victoiresJoueur
     * @param victoiresOrdinateur
     * @return le gagnant final sous forme de chaîne de caractère.
     */
    private String determinerGagnantFinal(int victoiresJoueur, int victoiresOrdinateur) {
        if (victoiresJoueur > victoiresOrdinateur) {
            return "Le joueur remporte la partie !";
        } else if (victoiresOrdinateur > victoiresJoueur) {
            return "L'ordinateur remporte la partie !";
        } else {
            return "Match nul !";
        }
    }


    
} //De la classe
