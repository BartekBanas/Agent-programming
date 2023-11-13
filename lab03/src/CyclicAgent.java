import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class CyclicAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                System.out.println("Cycle 1");
            }
        });

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                addBehaviour(new CyclicBehaviour() {
                    @Override
                    public void action() {
                        System.out.println("Cycle 2");
                    }
                });
            }
        });

        secondThread.start();
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }
}