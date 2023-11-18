import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class BoringAgent extends Agent {
    private static int step = 0;

    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        SequentialBehaviourManager behaviourManager = new SequentialBehaviourManager();

        addBehaviour(behaviourManager);
    }

    private class SequentialBehaviourManager extends OneShotBehaviour {
        @Override
        public void action() {
            addBehaviour(new GenericBehaviour());
            addBehaviour(new GenericBehaviour());
            addBehaviour(new GenericBehaviour());
        }
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private static class GenericBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
            switch (step) {
                case 0:
                    System.out.println("First step");
                    step++;
                    break;
                case 1:
                    System.out.println("Second step");
                    step++;
                    break;
                case 2:
                    System.out.println("Third step");
                    step++;
                    break;
                case 3:
                    myAgent.removeBehaviour(this);
                    break;
            }
        }
    }
}