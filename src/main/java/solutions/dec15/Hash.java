package solutions.dec15;

public class Hash {

    public static final int MULTIPLIER = 17;
    public static final int MODULO = 256;
    private final String string;

    public Hash(String string) {
        this.string = string;
    }

    public int calculate() {
        int res = 0;
        for (char c : string.toCharArray()) {
            res += valueForChar(c);
            res *= MULTIPLIER;
            res %= MODULO;
        }
        return res;
    }

    private int valueForChar(char character) {
        return character;
    }
}
