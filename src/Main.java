

public class Main {

    private static Tumbler tumbler;

    public static void main(String[] args) throws InterruptedException {
        final int PLAYERWAIT = 2500;
        final int BOXWAIT = 1500;
        final int GAMESNUMBER = 5;
        tumbler = new Tumbler(0);
        final Thread player = new Thread(null, new Player("Игрок", tumbler, PLAYERWAIT, GAMESNUMBER));
        final Thread box = new Thread(null, new Box("Коробка", tumbler, BOXWAIT));
        player.start();
        box.start();
        player.join();
        box.interrupt();
    }
}

