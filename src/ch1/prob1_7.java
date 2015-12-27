package ch1;

import java.util.HashMap;

/**
 * Created by Creaple on 2015-12-26.
 *
 * 행렬의 원소가 0인 모든 행과 열의 원소를 0으로 바꿈
 */
public class prob1_7 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5,0,2}, {1,2,3,4,5,3,2}, {1,2,0,4,5,3,2}, {1,2,3,4,5,3,2} };

        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(i);
            }
            System.out.println();
        }

        convertMatrix(matrix);

        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void convertMatrix(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
