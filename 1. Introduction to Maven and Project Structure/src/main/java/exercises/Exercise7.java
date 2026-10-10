package exercises;

import java.util.Random;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        int secret = randomGenerator.nextInt(100) + 1;
        int nr = -1;

        while (nr != secret) {
            nr = scanner.nextInt();

            if (nr < secret) System.out.println("prea mic");
            else if (nr > secret) System.out.println("prea mare");
            else System.out.println("gasit");
        }
    }
}