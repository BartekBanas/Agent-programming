import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import java.util.Scanner;

public class AgentSix extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        addBehaviour(new extendedNumberInputBehaviour());
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private static class extendedNumberInputBehaviour extends Behaviour {
        private boolean started = false;
        private boolean done = false;

        @Override
        public void action() {
            if (!started) {
                System.out.println("Behaviour started");
                started = true;
            }

            System.out.println("Enter an integer (or negative to finish): ");
            Scanner scanner = new Scanner(System.in);

            int input = scanner.nextInt();

            if (input < 0) {
                System.out.println("Scanning complete.");
                done = true;
                System.out.println("Behaviour ended");
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
