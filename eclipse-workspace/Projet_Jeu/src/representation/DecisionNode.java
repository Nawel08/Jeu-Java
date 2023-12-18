package representation;
import java.util.Scanner;

import univers.Evenements_1;
import univers.Evenements_2;
import univers.Evenements_3;
import univers.Evenements_4;

public class DecisionNode extends Node {
	
	TerminalNode tn = new TerminalNode();
	public DecisionNode(){
	}
	
	
    @Override
	public void display(String description)
	{
		System.out.println(description);

	}
	
	
	@Override
	public Node chooseNext() 
	{
		
		// Il doit y zvoir un system out pour que l'utilisateur entre sa reponse
			var reponse = System.console();
			if (reponse != null) 
			{
				Scanner choice = new Scanner (reponse.reader());
				System.out.println(description);
				String choix = choice.nextLine();
				System.out.println("vous avez rentrez: " +choix);
			}
			Node choix = null;
			//Ajouter des return en comparant la decision du joueur
			return choix;
			
		
		}
	public String choix_2_string(String choix1, String choix2) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Voici les choix possibles: ");
        System.out.println("1. " + choix1);
        System.out.println("2. " + choix2);
        System.out.println("Entre le numéro de ton choix: ");

        int userChoice;

        while (true) {
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice == 1 || userChoice == 2) {
                    break; // Sortir de la boucle si le choix est valide
                } else {
                    System.out.println("Choix invalide. Veuillez choisir 1 ou 2:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide (1 ou 2):");
            }
        }

        return (userChoice == 1) ? choix1 : choix2;
    } //2 Strings
	
	public int choix_2_string(int choix1, int choix2) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Voici les choix possibles: ");
        System.out.println("Choix 1 : " + choix1);
        System.out.println("Choix 2 : " + choix2);
        System.out.println("Entre le numéro de ton choix: ");

        int userChoice;

        while (true) {
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice == 1 || userChoice == 2) {
                    break; // Sortir de la boucle si le choix est valide
                } else {
                    System.out.println("Choix invalide. Veuillez choisir 1 ou 2:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide (1 ou 2):");
            }
        }

        return (userChoice == 1) ? choix1 : choix2;
    } //2 int
	
	public boolean appel_fee() {
	System.out.print("Voulez-vous demander un conseil à Jeniwell ? (oui/non) : ");
    Scanner scanner = new Scanner(System.in);
    String choix = scanner.nextLine().toLowerCase();

    if (choix.equals("oui")) {
    	return true;    	
       
    }
    else {
    	tn.display("FIN");
    	return false;
    }
	}
	
	public boolean appel_fee2() {
		System.out.print("Acceptes-tu ? (oui/non) : ");
	    Scanner scanner = new Scanner(System.in);
	    String choix = scanner.nextLine().toLowerCase();

	    if (choix.equals("oui")) {
	    	return true;    	
	       
	    }
	    else {
	    	tn.display("FIN");
	    	return false;
	    }
		}

} //La classe


	
	

