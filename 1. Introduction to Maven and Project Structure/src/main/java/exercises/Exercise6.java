package exercises;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.print(palindrom(n));
    }

    public static int oglindit(int n){
        int ogl = 0;
        while(n > 0){
            ogl = ogl * 10 + n % 10;
            n = n / 10;
        }
        return ogl;
    }

    public static boolean palindrom(int n){
        if (oglindit(n) == n) return true;
        else return false;
    }
}