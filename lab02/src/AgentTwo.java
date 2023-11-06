import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class AgentTwo extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        addBehaviour(new PrintMessage());
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private static class PrintMessage extends OneShotBehaviour {
        @Override
        public void action() {
            System.out.println("Processing...");
        }
    }
}