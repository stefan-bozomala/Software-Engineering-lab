package exercises;

import java.util.Scanner;

/**
 * Creați un program care afișează un triunghi Pascal cu n rânduri.
 */
public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        triunghiPascal(n);
    }

    public static void triunghiPascal(int n) {
        int[][] v = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                v[row][0] = 1; // prima col cu 1
            }
        }
        for(int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                v[row][col] = v[row - 1][col - 1] + v[row - 1][col];
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print(v[row][col] + " ");
            }
            System.out.println();
        }
    }
}