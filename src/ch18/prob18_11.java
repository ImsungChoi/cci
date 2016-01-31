package ch18;

/**
 * Created by imsungchoi on 2016. 1. 28..
 */
public class prob18_11 {
    public static int[][] start = {{1, 0}, {0, 1}};
    public static int[][] end = {{-1, 0}, {0, -1}};
    public static void main(String[] args) {
        int n = 8;
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
        for(int i = m.length; i >= 1; i--) {
            int ret = find(m, i);
            if(ret != 0) {
                return ret;
            }
        }
        return 0;
    }

    public static int find(int[][] m, int size) {
        for(int i = 0; i <= m.length-size; i++) {
            for(int j = 0;  j <= m.length-size; j++) {
                int ret = calcSquare(m, i, j, i+size-1, j+size-1);
                if(ret != 0) {
                    return ret;
                }
            }
        }

        return 0;
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
