import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Main {
    public static void main(String[] args) {
        Profile profile = new ProfileImpl();
        ContainerController container = jade.core.Runtime.instance().createMainContainer(profile);

        try {
            AgentController agentController = container.createNewAgent("Agent", "SelfMessagingAgent", null);
            agentController.start();

            jade.core.Runtime.instance().shutDown();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}