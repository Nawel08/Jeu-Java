package representation;

public interface Event {
	void display(String nom); //Ne pas oublier de justifier ce choix.
    Event chooseNext(); //renvoie un objet de type evenement
}
