import jade.core.Agent;

public class BasicAgent extends Agent {
    public BasicAgent() {
        System.out.println("constructor");
    }

    protected void setup() {
        System.out.println("setup");

        System.out.println(getLocalName() + " starting up");
    }

    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }
}