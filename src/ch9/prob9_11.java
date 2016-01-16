package ch9;

import java.util.HashMap;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_11 {
    public static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        String exp = "1^0|0|1&1&0&0|1|1|0^1|0";
        System.out.println(f(exp, 0, exp.length(), 0));
    }

    public static int f(String str, int s, int e, int r) {
        if(s + 1 == e) {
            if (r == Integer.parseInt(str.substring(s, e))) {
                return 1;
            } else {
                return 0;
            }
        }
        String key = s + "." + e + "." + r;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int c = 0;
        for(int i = s + 1; i < e; i = i+2) {
            String op = str.substring(i, i+1);

            if (r == 1) {
                if(op.equals("|")) {
                    c += f(str, s, i, 1) * f(str, i + 1, e, 1);
                    c += f(str, s, i, 1) * f(str, i + 1, e, 0);
                    c += f(str, s, i, 0) * f(str, i + 1, e, 1);
                } else if(op.equals("&")) {
                    c += f(str, s, i, 1) * f(str, i + 1, e, 1);
                } else if(op.equals("^")) {
                    c += f(str, s, i, 1) * f(str, i + 1, e, 0);
                    c += f(str, s, i, 0) * f(str, i + 1, e, 1);
                }
            } else {
                if(op.equals("|")) {
                    c += f(str, s, i, 0) * f(str, i + 1, e, 0);
                } else if(op.equals("&")) {
                    c += f(str, s, i, 0) * f(str, i + 1, e, 0);
                    c += f(str, s, i, 1) * f(str, i + 1, e, 0);
                    c += f(str, s, i, 0) * f(str, i + 1, e, 1);
                } else if(op.equals("^")) {
                    c += f(str, s, i, 1) * f(str, i + 1, e, 1);
                    c += f(str, s, i, 0) * f(str, i + 1, e, 0);
                }
            }
        }
        memo.put(key, c);
        return c;
    }
}
