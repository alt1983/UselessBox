public class Player extends Thread {

    private Tumbler tumbler;
    private int gamesNumber;
    private int playerWait;

    public Player(String name, Tumbler tumbler, int playerWait, int gamesNumber) {
        super();
        this.setName(name);
        this.tumbler = tumbler;
        this.playerWait = playerWait;
        this.gamesNumber = gamesNumber;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < gamesNumber; i++) {
                Thread.sleep(playerWait);
                if (tumbler.getVolatileVal() < 1) {
                    tumbler.setVolatileVal(1);
                    System.out.println("Я " + getName() + " установил тумблер!");
                }
            }
        } catch (InterruptedException err) {
        } finally {
            System.out.printf("%s завершен\n", getName());
        }
    }

}
