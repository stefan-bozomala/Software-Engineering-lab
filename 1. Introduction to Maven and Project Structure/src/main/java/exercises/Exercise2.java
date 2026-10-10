package exercises;

import static java.lang.Math.sqrt;

public class Exercise2 {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++)
            if (prim(i) == true) System.out.println(i + " ");
    }

    private static boolean prim(int n){
        if (n<=1) return false;
        for (int i = 2; i <= sqrt(n); i++)
        {
            if (n % i == 0) return false;
        }
        return true;
    }
}