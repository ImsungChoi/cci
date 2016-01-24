package Solutions;

import java.io.*;
import java.util.*;

public class BinaryNumber {
    public static int[] memo = new int[31];

    public static void main(String[] args) {
        memo[0] = 1;
        for(int i = 1; i < 31; i++) {
            memo[i] = memo[i-1] * 2;
        }
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while (c-- > 0) {
            int input = sc.nextInt();
            System.out.println(getBinaryInteger(input));
        }
    }

    public static String getBinaryInteger(int input) {
        String ret = "";

        for(int i = 30; i >= 0; i--) {
            if (input >= memo[i]) {
                ret += "1";
                input = input - memo[i];
            } else {
                if (!ret.equals("")) {
                    ret += "0";
                }
            }
        }
        return ret;
    }
}