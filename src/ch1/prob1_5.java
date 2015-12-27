package ch1;

import java.util.Scanner;

/**
 * Created by Creaple on 2015-12-26.
 *
 * 문자열을 압축하는 메소드 (같은 문자열이 반복될 경우 숫자로 대체함)
 *
 */
public class prob1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while(c-- > 0) {
            String str = sc.next();
            System.out.println(encodingString(str));
        }
    }

    public static String encodingString(String str) {
        StringBuffer sb = new StringBuffer();
        int count = 1;
        char last = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                count++;
            } else {
                sb.append(last);
                sb.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        sb.append(last);
        sb.append(count);

        if (str.length() <= sb.length()) {
            return str;
        } else {
            return sb.toString();
        }
    }
}
