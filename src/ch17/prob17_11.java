package ch17;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_11 {
    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++) {
            System.out.println(rand7());
        }
    }

    public static int rand5() {
        return (int) (Math.random() * 5);
    }

    public static int rand7() {
        while(true) {
            int rand = rand5()*5 + rand5();
            if(rand < 21) {
                return rand % 7;
            }
        }
    }
}
