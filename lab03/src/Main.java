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
            // Agent 1
            AgentController agentController = container.createNewAgent("First Agent", "AgentOneLabTwo", null);

            agentController.start();
            Thread.sleep(5000);
            jade.core.Runtime.instance().shutDown();
        } catch (StaleProxyException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}