package exercises;
//Scrieți un program care calculează suma cifrelor unui număr întreg pozitiv.
public class Exercise3 {
    public static void main(String[] args) {
        System.out.println(suma(23));
    }

    public static int suma(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

}