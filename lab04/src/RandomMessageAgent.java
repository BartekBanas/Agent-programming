import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Random;

public class RandomMessageAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        addBehaviour(new RandomMessageBehaviour());
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private class RandomMessageBehaviour extends CyclicBehaviour {
        @Override
        public void action() {
            sendRandomMessage();

            ACLMessage receivedMessage = receive();
            if (receivedMessage != null) {
                System.out.println("Received message: " + receivedMessage.getContent());

                if (receivedMessage.getPerformative() == ACLMessage.INFORM) {
                    doDelete();
                }
            } else {
                block();
            }
        }
    }

    private void sendRandomMessage() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        ACLMessage message;
        if (randomNumber == 0) {
            message = new ACLMessage(ACLMessage.CFP);
            message.setContent("CFP message content");
            message.addReceiver(new AID("Agent", AID.ISLOCALNAME));
        } else if (randomNumber == 1) {
            message = new ACLMessage(ACLMessage.REQUEST);
            message.setContent("REQUEST message content");
            message.addReceiver(new AID("Agent", AID.ISLOCALNAME));
        } else {
            message = new ACLMessage(ACLMessage.INFORM);
            message.setContent("Kill Yourself");
            message.addReceiver(new AID("Agent", AID.ISLOCALNAME));
        }

        send(message);
    }
}