package ch17;

import java.util.HashMap;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_2 {
    public static void main(String[] args) {
        int[][] b = {{0, 1, 0}, {0, 1, 0}, {1, 1, 1}};
        HashMap<Integer,Integer> memo = new HashMap<>();
        getMemo(memo);
        System.out.println(memo.get(convertBoardToInt(b)));
        System.out.println(checkWin(b));
    }

    public static void getMemo(HashMap<Integer, Integer> resultMap) {
        int[][] b = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        for(int v = 0; v < 3; v++) {
            b[0][0] = v;
            find(resultMap, b, 1);
            b[0][0] = 0;
        }
    }

    public static void find(HashMap<Integer, Integer> resultMap, int[][] b, int index) {
        resultMap.put(convertBoardToInt(b), checkWin(b));

        if(index == 9) {
            return;
        }

        for(int v = 0; v < 3; v++) {
            b[index/3][index%3] = v;
            find(resultMap, b, index+1);
            b[index/3][index%3] = 0;
        }
    }

    public static int convertBoardToInt(int[][] b) {
        int ret = 0;
        int factor = 1;
        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                ret += b[y][x] * factor;
                factor *= 3;
            }
        }

        return ret;
    }

    public static int checkWin(int[][] b) {
        for(int i = 0; i < 3; i++) {
            if(same(b[0][i], b[1][i], b[2][i])) {
                return b[0][i];
            }

            if(same(b[i][0], b[i][1], b[i][2])) {
                return b[i][0];
            }
        }

        if(same(b[0][0], b[1][1], b[2][2])) {
            return b[0][0];
        }

        if(same(b[0][2], b[1][1], b[2][0])) {
            return b[0][0];
        }

        return 0;
    }

    public static boolean same(int a, int b, int c) {
        if(a != 0 && a == b && b == c) {
            return true;
        }
        return false;
    }
}
