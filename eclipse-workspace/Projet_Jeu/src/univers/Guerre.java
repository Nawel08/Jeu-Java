package univers;

public enum Guerre {
	
    ETAPE_1(1,
    		new String[] {
    				"Ulysse : Allons-y !",
                    "Soldat 1 : Oui, mon capitaine !",
                    "Soldat 2 : Nous sommes confiants dans notre force !"
                },
            new Personnage_Non_Joueur("Armée d'Ulysse", 100),
            new Personnage_Non_Joueur("Armée de Troie", 150)),

    ETAPE_2(2,
    		new String[] {
    				"Ulysse : Avancez, attaquez la muraille ! Ne laissez aucun répit à l'ennemi !",
                    "Capitaine : Tenez bon, soldats ! Nous devons percer cette muraille !",
                    
                },
            new Personnage_Non_Joueur("Armée d'Ulysse", 80),
            new Personnage_Non_Joueur("Armée de Troie", 100)
            ),
	
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

    Guerre(int id, String[] dialogues, Personnage_Non_Joueur armeeUlysse, Personnage_Non_Joueur armeeTroie) {
        this.id = id;
        this.dialogues = dialogues;
        this.armeeUlysse = armeeUlysse;
        this.armeeTroie = armeeTroie;
    }


    public void display() {
        System.out.println("Dialogues :");
        for (String dialogue : dialogues) {
            System.out.println(dialogue);
        }
        System.out.println("Effectif de l'armée d'Ulysse : " + armeeUlysse.getEffectif());
        System.out.println("Effectif de l'armée de Troie : " + armeeTroie.getEffectif());
    }
}
