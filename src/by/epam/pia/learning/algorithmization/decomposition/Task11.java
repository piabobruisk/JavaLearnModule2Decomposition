package by.epam.pia.learning.algorithmization.decomposition;

//11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.

import java.util.Scanner;

public class Task11 {

    public static void main(String[] args) {

        int a;
        int b;
        int digitsA;
        int digitsB;

        do {
            a = input("Введите первое число a(>0)=");
        } while (a < 1);

        do {
            b = input("Введите второе число b(>0)=");
        } while (b < 1);

        digitsA = digitsQuantity(a);
        digitsB = digitsQuantity(b);

        System.out.print("Цифр в первом числе (" + digitsA + ")");
        if (digitsA > digitsB) {
            System.out.print(" больше ");
        } else {
            System.out.print(" меньше ");
        }
        System.out.println("чем во втором (" + digitsB + ").");
    }

    private static int digitsQuantity(int n) {

        int result = 0;
        while (n > 0) {
            n /= 10;
            result++;
        }
        return result;
    }

    private static int input(String prompt) {

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
