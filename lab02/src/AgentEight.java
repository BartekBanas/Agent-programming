import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class AgentEight extends Agent {
    private TickerBehaviour smallTickBehaviour;
    private TickerBehaviour bigTickBehaviour;

    @Override
    protected void setup() {
        System.out.println(getLocalName() + " started");

        smallTickBehaviour = new SmallTickTickerBehaviour();
        addBehaviour(smallTickBehaviour);

        bigTickBehaviour = new BigTickTickerBehaviour();
        addBehaviour(bigTickBehaviour);

        addBehaviour(new RemoveBigTickBehaviour());

        addBehaviour(new RemoveAgentBehaviour());
    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + " is shutting down");
    }

    private static class SmallTickTickerBehaviour extends TickerBehaviour {
        public SmallTickTickerBehaviour() {
            super(null, 2000);
        }

        @Override
        protected void onTick() {
            System.out.println("Small tick");
        }
    }

    private static class BigTickTickerBehaviour extends TickerBehaviour {
        public BigTickTickerBehaviour() {
            super(null, 5000);
        }

        @Override
        protected void onTick() {
            System.out.println("Big tick");
        }
    }

    private class RemoveBigTickBehaviour extends TickerBehaviour {
        public RemoveBigTickBehaviour() {
            super(null, 50000);
        }

        @Override
        public void onTick() {
            myAgent.removeBehaviour(bigTickBehaviour);
        }
    }

    private class RemoveAgentBehaviour extends TickerBehaviour {
        public RemoveAgentBehaviour() {
            super(null, 100000);
        }

        @Override
        public void onTick() {
            doDelete();
        }
    }
}
