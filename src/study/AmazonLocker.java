package study;

/**
 * Created by imsungchoi on 2016. 1. 27..
 */
public class AmazonLocker {
    public static void main(String[] args) {
        int len = 7;
        int width = 5;
        int[] x = {2, 4};
        int[] y = {3, 7};
        int[][] b = getLockerDistanceGrid(len, width, x, y);
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < width; j++) {
                System.out.print(b[i][j]);
            }
            System.out.println("");
        }
    }

    static int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        int[][] b = new int[cityLength][cityWidth];
        for(int i = 0; i < cityLength; i++) {
            for(int j  =0; j < cityWidth; j++) {
                b[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < lockerXCoordinates.length; i++) {
            calcDistance(b, lockerYCoordinates[i]-1, lockerXCoordinates[i]-1, 0);
        }

        return b;
    }

    public static void calcDistance(int[][] b, int x, int y, int distance) {
        if(x < 0 || y < 0 || x >= b.length|| y >= b[0].length) {
            return;
        }

        if(b[x][y] > distance) {
            b[x][y] = distance;
        } else {
            return;
        }

        for(int i = 0; i < direction.length; i++) {
            calcDistance(b, x + direction[i][0], y + direction[i][1], distance + 1);
        }
    }
}
