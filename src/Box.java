public class Box extends Thread {

    private Tumbler tumbler;
    private int boxWait;

    public Box(String name, Tumbler tumbler, int boxWait) {
        super();
        this.setName(name);
        this.tumbler = tumbler;
        this.boxWait = boxWait;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(500);
                if (tumbler.getVolatileVal() > 0) {
                    tumbler.setVolatileVal(0);
                    System.out.println("Я " + getName() + " выключила тумблер!");
                }
            }
        } catch (InterruptedException err) {
        } finally {
            if (tumbler.getVolatileVal() > 0) {
                tumbler.setVolatileVal(0);
                System.out.println("Я " + getName() + " выключила тумблер!");
            }
            System.out.printf("%s завершен\n", getName());
        }
    }

}
