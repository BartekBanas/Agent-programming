import jade.core.Agent;

public class BasicAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }
}