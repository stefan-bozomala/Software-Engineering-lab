package utcluj.aut;

import java.util.Scanner;

/**
 * MyFirstExample class is a simple class that demonstrates the usage of Java.
 */

//run wwith coverage se refera la cat din cod e acoperit de teste // main extrem de important - nu putem rula fara - publica, statica, return de tip void, argument de tip string array

public class MyFirstExample {
    public static void main(String[] args) {
        //print in console
        System.out.println("Hello, World!");
        System.out.println("Enter two numbers: ");
        //read from console
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Sum is: " + add(a, b));
        System.out.println("Difference is: " + subtract(a, b));

        //feature-ul adaugat - compararea celor 2 numere
        if (compare(a,b) == 1) System.out.println("Compare: " + a + " este mai mic decat " + b);
        else if (compare(a,b) == -1) System.out.println("Compare: " + a + " este mai mare decat " + b);
        else System.out.println("Compare: " + a + " este egal cu " + b);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int compare(int a, int b)
    {
        if (a<b) return 1;
        else if (a>b) return -1;
        else return 0;
    }
}