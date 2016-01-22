package ch10;

/**
 * Created by imsungchoi on 2016. 1. 18..
 */
public class prob10_6 {
    public static void main(String[] args) {
        int[][] matrix = new int[7][9];
        for(int i = 1; i < 8; i++) {
            for(int j = 1; j < 10; j++) {
                matrix[i-1][j-1] = i * j;
            }
        }

        System.out.println(findValueWithMatrix(matrix, 56));
    }

    public static boolean findValueWithMatrix(int[][] matrix, int val) {
        int y = 0;
        int x = matrix[0].length-1;

        while(y < matrix.length && x > 0) {
            if(matrix[y][x] == val) {
                return true;
            } else if(matrix[y][x] > val) {
                x--;
            } else {
                y++;
            }
        }

        return false;
    }
}
