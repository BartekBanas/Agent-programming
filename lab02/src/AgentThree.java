import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class AgentThree extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        addBehaviour(new printMessage());
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private static class printMessage extends CyclicBehaviour {
        @Override
        public void action() {
            System.out.println("Processing...");
        }
    }
}
