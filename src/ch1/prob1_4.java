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

        char[] ret = new char[str.length() * 3];
        int index = 0;
        for(int i = 0; i < length; i++) {
            if(chars[i] == ' ') {
                ret[index++] = '%';
                ret[index++] = '2';
                ret[index++] = '0';
            } else {
                ret[index++] = chars[i];
            }
        }
        return new String(ret);
    }
}
