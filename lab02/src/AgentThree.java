import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class AgentThree extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        addBehaviour(new printingSteps());
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private class printingSteps extends Behaviour {
        private int step = 0;

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
                    removeBehaviour(this);
                    break;
            }
        }

        @Override
        public boolean done() {
            return step >= 3;
        }
    }
}
