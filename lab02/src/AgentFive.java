import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import java.util.Scanner;

public class AgentFive extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        addBehaviour(new NumberInputBehaviour());
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private static class NumberInputBehaviour extends Behaviour {
        private boolean done = false;

        @Override
        public void action() {
            System.out.println("Enter an integer (or negative to finish): ");
            Scanner scanner = new Scanner(System.in);

            int input = scanner.nextInt();

            if (input < 0) {
                System.out.println("Scanning complete.");
                done = true;
            } else {
                System.out.println("Entered number : " + input);
            }
        }

        @Override
        public boolean done() {
            return done;
        }
    }
}
