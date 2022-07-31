public class Tumbler {

    public static volatile Integer volatileVal;

    public int getVolatileVal() {
        return this.volatileVal;
    }

    public static void setVolatileVal(Integer volatileVal) {
        Tumbler.volatileVal = volatileVal;
    }

    public Tumbler(Integer i) {
        volatileVal = i;
    }
}
