import java.util.*;
public class Dice {
    private final static Random random = new Random();

    public static int roll(int max) {
        return 1 + random.nextInt(max);
    }
}
