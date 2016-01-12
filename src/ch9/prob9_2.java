package ch9;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_2 {
    static int[][] memo = new int[100][100];

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++)
            for(int j = 0; j <100; j++)
                memo[i][j] = 0;

        System.out.println(calcRobotWay(10, 10));
    }

    public static int calcRobotWay(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (x < 0 || y < 0) {
            return 0;
        }

        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        memo[x][y] = calcRobotWay(x-1, y) + calcRobotWay(x, y-1);
        return memo[x][y];
    }
}
