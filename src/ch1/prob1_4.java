package ch1;

import java.util.Scanner;

/**
 * Created by Creaple on 2015-12-26.
 *
 * 모든 공백을 %20으로 바꾸는 메소드를 작성
 */
public class prob1_4 {
    public static void main(String[] args) {
        String str = "aaaaa aaa aaa      ";
        System.out.println(convertEmpty(str, 13));

    }

    public static String convertEmpty(String str, int length) {
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < length; i++) {
            if(chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
