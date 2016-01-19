package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class AndroidPattern {
    static int[][] p = new int[3][3];
    static int[][] d = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};
    static int num = 0;

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                p[i][j] = 0;
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                p[i][j] = 1;
                calc(i, j, 1);
                p[i][j] = 0;
            }
        }

        System.out.println(num);
    }

    public static void calc(int x, int y, int picked) {
        for(int i = 0; i < 8; i++) {
            int mX = x + d[i][0];
            int mY = y + d[i][1];
            if (isValid(mX, mY)) {
                p[mX][mY] = 1;
                calc(mX, mY, picked + 1);
                p[mX][mY] = 0;
            }
        }

        if (picked >= 4) {
            num++;
        }
    }

    public static boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return false;
        }

        if (p[x][y] == 1) {
            return false;
        }

        return true;
    }
}