import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.introspection.AddedBehaviour;

import java.util.Random;

public class AgentOneLabTwo extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        addBehaviour(new aBehaviour(true));
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private class aBehaviour extends OneShotBehaviour {
        private boolean state;

        public aBehaviour(boolean input) {
            state = input;
        }

        @Override
        public void action() {
            System.out.println("The current state is: " + state);

            addBehaviour(new bBehaviour());
        }
    }

    private class bBehaviour extends OneShotBehaviour {
        private boolean state;

        public bBehaviour(boolean input) {
            state = input;
        }

        public bBehaviour() {
            state = randomBool();
        }

        @Override
        public void action() {
            System.out.println("The current state is: " + state);

            state = randomBool();

            if (state) {
                addBehaviour(new cBehaviour(state));
            } else {
                addBehaviour(new dBehaviour(state));
            }
        }
    }

    private class cBehaviour extends OneShotBehaviour {
        private boolean state;

        public cBehaviour(boolean input) {
            state = input;
        }

        @Override
        public void action() {
            System.out.println("The current state is: " + state);

            addBehaviour(new dBehaviour(state));
        }
    }

    private class dBehaviour extends OneShotBehaviour {
        private boolean state;

        public dBehaviour(boolean input) {
            state = input;
        }

        public dBehaviour() {
            state = randomBool();
        }

        @Override
        public void action() {
            System.out.println("The current state is: " + state);

            state = randomBool();

            if (state) {
                addBehaviour(new aBehaviour(state));
            } else {
                addBehaviour(new eBehaviour(state));
            }
        }
    }

    private class eBehaviour extends OneShotBehaviour {
        private boolean state;

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
