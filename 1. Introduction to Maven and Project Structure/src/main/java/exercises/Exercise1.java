package exercises;

import java.util.Scanner;

/**
 * Scrieți un program care verifică dacă un an este bisect. Un an este bisect dacă este divizibil cu 4 dar nu cu 100, sau dacă este divizibil cu 400.
 */
public class Exercise1 {
    public static void main(String[] args) {
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        boolean isLeap = isLeapYear(2020);
        System.out.println(year + " is a leap year? - " + isLeap);
    }

    private static boolean isLeapYear(int year){
        if ( ( (year % 4 == 0) && (year % 100 != 0) ) || (year % 400 == 0) ) return true;
        else return false;
    }
}