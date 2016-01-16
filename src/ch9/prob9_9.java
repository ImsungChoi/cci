package ch9;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_9 {
    public static void main(String[] args) {
        System.out.println(getNQueens(8));
    }

    public static int getNQueens(int n) {
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        return calc(board, n, 0);
    }

    public static int calc(int[][] board, int n, int current) {
        if(current == n) {
            return 1;
        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            if(isValid(board, n, i, current)) {
                board[current][i] = 1;
                ret += calc(board, n, current + 1);
                board[current][i] = 0;
            }
        }
        return ret;
    }

    public static boolean isValid(int[][] board, int n, int x, int y) {
        boolean ret = true;
        for(int i = 0; i <= y; i++) {
            if (!ret) {
                return false;
            }

            ret &= check(board, n, x, i);
            ret &= check(board, n, x - i, y - i);
            ret &= check(board, n, x + i, y - i);
        }
        return ret;
    }

    public static boolean check(int[][] board, int n, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return true;
        }

        if (board[y][x] == 1) {
            return false;
        }

        return true;
    }
}
