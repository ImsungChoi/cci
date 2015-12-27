package ch1;

/**
 * Created by Creaple on 2015-12-26.
 *
 * Description : 문자열에 포함된 문자들이 Unique한지 확인 (별도의 자료구조 없이)
 */

import java.util.Arrays;
import java.util.Scanner;

public class prob1_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while (c-- > 0) {
            String str = sc.next();
            System.out.println("string " + str + " is " + isUniqueCharSet2(str));
        }
    }

    /**
     * O(n) solution : String의 구성요소가 특정지어진 경우에 사용할 수 있는 방법 (e.g, a-z까지의 소문자 문자열)
     * a-z 문자셋의 존재 여부를 int (32bit number)에 저장한다.
     *
     * @param str
     * @return
     */
    public static boolean isUniqueCharSet(String str) {
        if (str.length() > 28) {
            return false;
        }

        int check = 0;
        for(char c : str.toCharArray()) {
            int cValue = c - 'a';

            if((check & (1 << cValue)) > 0) {
                return false;
            }

            check |= cValue;
        }

        return true;
    }

    /**
     * O(nlogn) Solution : 어떤 경우에도 쓸 수 있는 방법
     * Sorting 후에 같은 연속되는 값이 있는지 확인
     *
     * @param str
     * @return
     */
    public static boolean isUniqueCharSet2(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        char last = chars[0];
        for(int i = 1; i < chars.length; i++) {
            if (last == chars[i]) {
                return false;
            }
            last = chars[i];
        }

        return true;
    }
}
