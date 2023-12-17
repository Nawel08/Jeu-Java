package univers;
import univers.Personnage_Joueur;
import representation.SoundNode;
import univers.Evenements_1;
import representation.Event;
import representation.Node;

public class Main {
	public static void main (String[] args) {

/*__________________________________________________________
			INTRODUCTION
____________________________________________________________*/	
		
		Introduction intro=new Introduction();
		
		intro.display_intro();
		intro.display_but();

		
		
/*__________________________________________________________
        		ETAPE 1
____________________________________________________________*/
		
		Etapes etape1 = Etapes.etape_1;
        etape1.display();
        
        Evenements_1 e1= new Evenements_1();
        
		
        Personnage_Joueur pj = new Personnage_Joueur();
		pj.Genre(); 
		
		e1.Combat(); //Le joueur combat
		e1.Defi(); //Le joueur relève le defi
		e1.Issue();
		        
		
/*__________________________________________________________
        		ETAPE 2
____________________________________________________________*/
        
        Etapes etape2 = Etapes.etape_2;
        etape2.display();
        
        Evenements_2 e2= new Evenements_2();
        
        e2.afficherEtapes();
		e2.Attaque();
		e2.mission();
		
/*__________________________________________________________
        		ETAPE 3 
____________________________________________________________*/
        
        Etapes etape3 = Etapes.etape_3;
        etape3.display();
		
        Evenements_3 e3= new Evenements_3();
        
        e3.afficherEtapes();
		e3.ConstructionCheval();
		e3.Issue();
		
/*__________________________________________________________
        		ETAPE 4 
____________________________________________________________*/
        
        Etapes etape4 = Etapes.etape_4;
        etape4.display();
        
        Evenements_4 e4= new Evenements_4();
		
        e4.afficherEtapes();
		e4.Issue();
		
		 
		//POUR LE SON
		Event baseNode = new Node(introduction, 0);

        // Ajoutez la fonctionnalité de lecture de son au nœud de base
        Event soundNode = new SoundNode(baseNode);

        // Affichez le nœud avec la fonctionnalité de son
        soundNode.display("Data/son.wav");
        
	}

}
