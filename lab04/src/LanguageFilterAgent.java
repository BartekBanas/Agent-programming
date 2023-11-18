import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class LanguageFilterAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        addBehaviour(new LanguageFilterBehaviour());

        selfSendMessage();
    }

    private class LanguageFilterBehaviour extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage message = receive();

            if (message != null) {
                if ("polish".equalsIgnoreCase(message.getLanguage())) {
                    System.out.println("Received message in Polish: " + message.getContent());
                } else {
                    System.out.println("Message in a language other than Polish. Discarding...");
                }
            } else {
                block();
            }
        }
    }

    private void selfSendMessage() {
        ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
        message.addReceiver(new AID("Agent", AID.ISLOCALNAME));
        message.setContent("Test message content");
        message.setLanguage("polish");

        send(message);
    }
}