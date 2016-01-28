package problems;

/**
 * Created by imsungchoi on 2016. 1. 28..
 */
public class FairRandomGenerator {
    public static void main(String[] args) {
        int ones = 0;
        for(int i = 0; i < 10000; i++) {
            int bit = getFairBit();
            if(bit == 1) {
                ones++;
            }
        }

        System.out.println(ones);
    }

    public static int getFairBit() {
        int first = getUnfairBit();
        int second = getUnfairBit();

        while((first ^ second) != 1) {
            first = getUnfairBit();
            second = getUnfairBit();
        }

        if(first == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int getUnfairBit() {
        int unfairBit = (int) (Math.random() * 3);

        if(unfairBit == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
