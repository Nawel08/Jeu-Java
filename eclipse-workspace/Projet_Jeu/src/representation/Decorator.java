package representation;

public abstract class Decorator implements Event {
    protected Event decoratedEvent;

    public Decorator(Event decoratedEvent) {
        this.decoratedEvent = decoratedEvent;
    }

    @Override
    public void display(String son) {
        decoratedEvent.display(son);
    }

    @Override
    public Event chooseNext() {
        return decoratedEvent.chooseNext();
    }

	
}