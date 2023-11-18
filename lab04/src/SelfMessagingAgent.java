import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SelfMessagingAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        selfSendMessage();

        addBehaviour(new MessageReceiverBehaviour());
    }

    private class MessageReceiverBehaviour extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage message = receive();

            if (message != null) {
                switch (message.getPerformative()) {
                    case ACLMessage.REQUEST:
                        System.out.println("Received REQUEST message: " + message.getContent());
                        ACLMessage informReply = message.createReply();
                        informReply.setPerformative(ACLMessage.INFORM);
                        informReply.setContent("Request complete");
                        send(informReply);
                        break;

                    case ACLMessage.CFP:
                        System.out.println("Received CFP message: " + message.getContent());
                        ACLMessage requestReply = message.createReply();
                        requestReply.setPerformative(ACLMessage.REQUEST);
                        requestReply.setContent("Try again");
                        send(requestReply);
                        break;

                    default:
                        System.out.println("Received message of unknown type: " + message.getContent());
                        ACLMessage notUnderstoodReply = message.createReply();
                        notUnderstoodReply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                        notUnderstoodReply.setContent("Instructions unclear");
                        send(notUnderstoodReply);
                        break;
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

        send(message);
    }
}