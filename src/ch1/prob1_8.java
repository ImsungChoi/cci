package ch1;

/**
 * Created by Creaple on 2015-12-26.
 *
 * s1, s2 2개의 문자열이 주어질 때 s2가 s1의 회전한 문자열인지 여부를 확인
 */
public class prob1_8 {
    public static void main(String[] args) {
        System.out.println(isRotatedString("abcdefg", "defgabc"));
    }

    public static boolean isRotatedString(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) {
            return true;
        }

        s2 = s2 + s2;

        return isSubstring(s2, s1);
    }

    public static boolean isSubstring(String target, String substring) {
        for(int i = 0; i < target.length(); i++) {
            for(int j = 0; j < substring.length(); j++) {
                if(target.charAt(i+j) != substring.charAt(j) || i+j >= target.length()-1) {
                    break;
                }
                if(j == substring.length()-1) {
                    return true;
                }
            }
        }
        return false;
    }
}
