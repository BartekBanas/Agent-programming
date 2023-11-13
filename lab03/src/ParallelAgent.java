import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;

public class ParallelAgent extends Agent {
    private static int step = 0;

    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        TaskManagerBehaviour parallelBehaviour = new TaskManagerBehaviour();

        addBehaviour(parallelBehaviour);
    }

    private static class TaskManagerBehaviour extends ParallelBehaviour {
        public TaskManagerBehaviour() {
            this.addSubBehaviour(new GenericBehaviour());
            this.addSubBehaviour(new GenericBehaviour());
            this.addSubBehaviour(new GenericBehaviour());
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