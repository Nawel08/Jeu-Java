package representation;

import java.util.Scanner;

public abstract class Decorator implements Event {
    protected Event decoratedEvent;

    public Decorator(Event decoratedEvent) {
        this.decoratedEvent = decoratedEvent;
    }

    
    public void display(String son,Scanner userInputScanner) {
        decoratedEvent.display(son);
    }

    @Override
    public Event chooseNext() {
        return decoratedEvent.chooseNext();
    }
    public Decorator(){
    	
    }

	
}