import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class BasicAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        doDelete();
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }
}