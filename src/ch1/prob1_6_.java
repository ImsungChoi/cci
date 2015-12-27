package ch1;

import java.util.Scanner;

/**
 * Created by Creaple on 2015-12-26.
 *
 * NxN 행렬을 90도 만큼 회전 (추가적인 행렬없이)
 */
public class prob1_6_ {
    public static void main(String[] args) {
        int[][] image = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        for (int[] ints : image) {
            for (int i : ints) {
                System.out.print(i);
            }
            System.out.println();
        }
        rotateMatrix(image);
        for (int[] ints : image) {
            for (int i : ints) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void rotateMatrix(int[][] image) {
        for (int i = 0; i < image.length/2; i++) {
            int first = i;
            int last = image.length - i - 1;

            for (int j = i; j < last; j++) {
                int temp = image[first][j];
                image[first][j] = image[last-j][first];
                image[last-j][first] = image[last][last-j];
                image[last][last-j] = image[j][last];
                image[j][last] = temp;
            }
        }
    }
}
