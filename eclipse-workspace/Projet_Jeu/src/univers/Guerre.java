package univers;

/**
 * Enumeration permettant d'afficher les différents dialogues lors de la guerre (l'evenement 1)
 * avec associé les effectifs de l'armée d'ulysse et de troie.
 * @author nawel
 *
 */

public enum Guerre {
	

	/**
	 * Etape 1 - Ulysse a l'avantage
	 */
    ETAPE_1(1,
    		new String[] {
    				"Ulysse : Allons-y !",
                    "Soldat 1 : Oui, mon capitaine !",
                    "Soldat 2 : Nous sommes confiants dans notre force !"
                },
            new Personnage_Non_Joueur("Armée d'Ulysse", 100),
            new Personnage_Non_Joueur("Armée de Troie", 150)),

    /**
	 * Etape 2 - L'armée de Troie s'impose
	 */
    ETAPE_2(2,
    		new String[] {
    				"Ulysse : Avancez, attaquez la muraille ! Ne laissez aucun répit à l'ennemi !",
                    "Capitaine : Tenez bon, soldats ! Nous devons percer cette muraille !",
                    
                },
            new Personnage_Non_Joueur("Armée d'Ulysse", 80),
            new Personnage_Non_Joueur("Armée de Troie", 100)
            ),
	
    /**
	 * Etape 3 - L'armée d'Ulysse reprend le contrôle et gagne
	 */
	ETAPE_3(3,
    		new String[] {
    				"Ulysse : Serrez les rangs pour ne pas perdre davanatage d'effectif !",
                    "Soldat 1 : Je ne peux pas ! J'ai perdu mes deux jambes",
                    "Soldat 2: Gardez courage, ils commencent à faiblir rien n'est perdu !"
                },
            new Personnage_Non_Joueur("Armée d'Ulysse", 80),
            new Personnage_Non_Joueur("Armée de Troie", 50)
            );

    private int id;
    private String description;
    private String[] dialogues;
    private Personnage_Non_Joueur armeeUlysse;
    private Personnage_Non_Joueur armeeTroie;

    /**
     * Constructeur de l'énumeration
     * @param id: identifiant associé à l'étape de la guerre
     * @param dialogues, dialogues dans l'énumération
     * @param armeeUlysse, effectif dans l'armée d'Ulysse
     * @param armeeTroie, effectif dans l'armée de Troie.
     */
    
    private Guerre() {
    	
    }
    private Guerre(int id, String[] dialogues, Personnage_Non_Joueur armeeUlysse, Personnage_Non_Joueur armeeTroie) {
        this.id = id;
        this.dialogues = dialogues;
        this.armeeUlysse = armeeUlysse;
        this.armeeTroie = armeeTroie;
    }

	/**
	 * Méthode qui affiche l'énumération.
	 */
    public void display(String prenomJoueur) {
        System.out.println("Dialogues :");
        for (String dialogue : dialogues) {
            // Remplacez "Ulysse" par "Pénélope" si le prénom du joueur est "Pénélope"
            if ("Penelope".equalsIgnoreCase(prenomJoueur)) {
                dialogue = dialogue.replace("Ulysse", "Penelope");
            }
            System.out.println(dialogue);
        }

        System.out.println("Effectif de l'armée d'Ulysse : " + armeeUlysse.getEffectif());
        System.out.println("Effectif de l'armée de Troie : " + armeeTroie.getEffectif());
    }

}
