package ch18;

/**
 * Created by imsungchoi on 2016. 1. 28..
 */
public class prob18_11 {
    public static int[][] start = {{1, 0}, {0, 1}};
    public static int[][] end = {{-1, 0}, {0, -1}};
    public static void main(String[] args) {
        int n = 20;
        int[][] m = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                m[i][j] = (int) (Math.random() * 2);
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(getMaxSubSquare(m));
    }

    public static int getMaxSubSquare(int[][] m) {
        int max = 0;
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                max = Math.max(max, find(m, j, i));
            }
        }
        return max;
    }

    public static int find(int[][] m, int x, int y) {
        int max = 0;
        for(int i = y; i < m.length; i++) {
            for(int j = x;  j < m[0].length; j++) {
                max = Math.max(max, calcSquare(m, x, y, j, i));
            }
        }

        return max;
    }

    public static int calcSquare(int[][] m, int startX, int startY, int endX, int endY) {
        for(int i = 0; i <= endX - startX; i++) {
            if(m[startY][startX + i] != 1 || m[endY][startX + i] != 1) {
                return 0;
            }
        }
        for(int i = 0; i <= endY - startY; i++) {
            if(m[startY + i][startX] != 1 || m[startY + i][endX] != 1) {
                return 0;
            }
        }
        return (endX-startX+1) * (endY-startY+1);
    }
}
