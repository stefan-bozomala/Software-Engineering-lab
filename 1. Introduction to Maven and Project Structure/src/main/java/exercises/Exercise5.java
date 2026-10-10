package exercises;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int baza = scanner.nextInt();
        System.out.print(convert(n,baza));
    }

public static String convert(int n, int b) {
    String rezultat = "";

    while (n > 0) {
        int rest = n % b;
        char cifra;

        switch (rest) {
            case 10: cifra = 'A'; break;
            case 11: cifra = 'B'; break;
            case 12: cifra = 'C'; break;
            case 13: cifra = 'D'; break;
            case 14: cifra = 'E'; break;
            case 15: cifra = 'F'; break;
            default: cifra = (char) (rest + '0'); break;
        }

        rezultat = cifra + rezultat;
        n = n / b;
    }

    return rezultat;
    }
}