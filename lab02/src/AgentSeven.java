import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class AgentSeven extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        addBehaviour(new FirstOneShotBehaviour());

        addBehaviour(new printingSteps());
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private class printingSteps extends CyclicBehaviour {
        private int step = 0;

        @Override
        public void action() {
            switch (step) {
                case 0:
                    System.out.println("First step");

                    addBehaviour(new SecondOneShotBehaviour());
                    block(500);

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
    }

    private static class FirstOneShotBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
            System.out.println("First Behaviour");
        }
    }

    private static class SecondOneShotBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
            System.out.println("Second Behaviour");
        }
    }
}
