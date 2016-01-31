package ch18;

/**
 * Created by imsungchoi on 2016. 1. 28..
 *
 *
 * DP 최적화, O(n^3) 최적화도 있음
 */
public class prob18_12 {
    public static void main(String[] args) {
        int n = 9;
        int[][] m = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                m[i][j] = (i+1) * (((int) (Math.random() * 2) == 0)? 1 : -1);
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(getMaxSum(m));
    }

    public static int getMaxSum(int[][] m) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                max = Math.max(max, findMax(m, j, i));
            }
        }
        return max;
    }

    public static int findMax(int[][] m, int x, int y) {
        int max = Integer.MIN_VALUE;
        for(int i = y; i < m.length; i++) {
            for(int j = x; j < m[0].length; j++) {
                max = Math.max(max, calc(m, x, y, j, i));
            }
        }
        return max;
    }

    public static int calc(int[][] m, int startX, int startY, int endX, int endY) {
        int sum = 0;

        for(int i = startY; i <= endY; i++) {
            for(int j = startX; j <= endX; j++) {
                sum += m[j][i];
            }
        }
        return sum;
    }
}
