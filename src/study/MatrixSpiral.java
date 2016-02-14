package study;

/**
 * Created by imsungchoi on 2016. 2. 14..
 */
public class MatrixSpiral {
    public static void main(String[] args) {
        int[][] m = {   {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10,11,12},
                        {13,14,15,16}
                    };
        print(m);
    }

    public static void print(int[][] m) {
        int r = m[0].length;
        int c = m.length;

        for(int i = 0; i < c/2; i++) {
            for(int j = i; j < r - i; j++) {
                System.out.println(m[i][j]);
            }

            for(int j = i+1; j < c-1-i; j++) {
                System.out.println(m[j][r-1-i]);
            }

            for(int j = r-1-i; j >= i; j--) {
                System.out.println(m[c-1-i][j]);
            }

            for(int j = c-2-i; j > i; j--) {
                System.out.println(m[j][i]);
            }
        }

        if(c % 2 == 1) {
            for(int i = c/2; i < r - (c/2); i++) {
                System.out.println(m[c/2][i]);
            }
        }
    }
}
