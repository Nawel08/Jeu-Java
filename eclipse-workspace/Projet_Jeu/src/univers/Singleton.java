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
	
	//On met le constructeur en privé comme ça personne ne pourra étendre cette classe.
	//Et le code exterieur a cette classe ne peut pas construire cette classe.
	//Les constructeurs de la classe Singleton sont private.
	
	
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
	
}
