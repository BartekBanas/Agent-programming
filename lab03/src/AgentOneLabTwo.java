import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import java.util.Random;

public class AgentOneLabTwo extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private static class aBehaviour extends OneShotBehaviour {
        private final boolean state;

        public aBehaviour(boolean input) {
            state = input;
        }

        @Override
        public void action() {
            System.out.println("The current state is: " + state);


        }
    }

    private static class bBehaviour extends OneShotBehaviour {
        private final boolean state;

        public bBehaviour() {
            state = randomBool();
        }

        @Override
        public void action() {
            System.out.println("The current state is: " + state);
        }
    }

    private static class cBehaviour extends OneShotBehaviour {
        private final boolean state;

        public cBehaviour(boolean input) {
            state = input;
        }

        @Override
        public void action() {
            System.out.println("The current state is: " + state);
        }
    }

    private static class dBehaviour extends OneShotBehaviour {
        private final boolean state;

        public dBehaviour() {
            state = randomBool();
        }

        @Override
        public void action() {
            System.out.println("The current state is: " + state);


        }
    }

    private static class eBehaviour extends OneShotBehaviour {
        private final boolean state;

        public eBehaviour(boolean input) {
            state = input;
        }

        @Override
        public void action() {
            System.out.println("The current state is: " + state);
        }
    }

    private static boolean randomBool() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
