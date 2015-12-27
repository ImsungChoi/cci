package ch1;

/**
 * Created by Creaple on 2015-12-26.
 *
 * 문자열 2개를 입력받아 하나가 다른 하나의 순열인지 확인
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class prob1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while(c-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();
            System.out.println(isPermutation2(str1, str2));
        }
    }

    /**
     * O(nlogn) Solution
     * 2개의 string을 sorting해서 같은지 확인
     *
     */
    public static boolean isPermutation(String str1, String str2) {
        if (str1.length() !=  str2.length()) {
            return false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    /**
     * O(n) solution
     * Hash Table을 활용해서 문자 숫자 체크
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isPermutation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < chars1.length; i++) {
            updateMap(map, chars1[i], 1);
            updateMap(map, chars2[i], -1);
        }

        for(Character c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void updateMap(HashMap<Character, Integer> map, char c, int updateNumber) {
        if(map.get(c) == null) {
            map.put(c, updateNumber);
        } else {
            map.put(c, map.get(c) + updateNumber);
        }
    }
}
