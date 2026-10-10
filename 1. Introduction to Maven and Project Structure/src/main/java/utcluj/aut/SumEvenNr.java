package utcluj.aut;

import java.util.Scanner;

public class SumEvenNr
{
    public static void main(String[] args)
    {
        //citesc n
        System.out.println("n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //afisez suma nr pare
        System.out.println("Suma nr pare este: ");
        System.out.println(suma_pare(n));

    }

    public static int suma_pare(int n)
    {
        int suma_pare = 0;
        int numar_par_curent = 2; // Începem cu primul număr par: 2

        while (n > 0)
        {
            suma_pare = suma_pare + numar_par_curent;
            numar_par_curent = numar_par_curent + 2;
            n--;
        }
        return suma_pare;
    }
}