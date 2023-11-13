import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;

public class ParallelAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        ParallelBehaviour parallelBehaviour = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);

        parallelBehaviour.addSubBehaviour(new GenericBehaviour());
        parallelBehaviour.addSubBehaviour(new GenericBehaviour());
        parallelBehaviour.addSubBehaviour(new GenericBehaviour());

        addBehaviour(parallelBehaviour);
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private static class GenericBehaviour extends OneShotBehaviour {
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
                     myAgent.removeBehaviour(this);
                    break;
            }
        }
    }
}
