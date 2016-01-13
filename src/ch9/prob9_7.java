package ch9;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_7 {
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] isVisited = new boolean[100][100];
    static int[][] image = new int[100][100];
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                image[i][j] = 0;
                isVisited[i][j] = false;
            }
        }

        image[3][3] = 2;
        paintFill(44, 34, 1);
        System.out.println(image[3][3]);
        System.out.println(image[1][1]);
    }

    public static void paintFill(int x, int y, int color) {
        for(int i = 0; i < 4; i++) {
            int mX = x + d[i][0];
            int mY = y + d[i][1];

            if(!isValid(mX, mY) || isVisited[mX][mY]) {
                continue;
            }

            isVisited[mX][mY] = true;
            if(image[y][x] == image[mY][mX]) {
                paintFill(mX, mY, color);
            }
        }
        image[y][x] = color;
    }

    public static boolean isValid(int x, int y) {
        return !(x < 0 || x > 99 || y < 0 || y > 99);
    }
}
