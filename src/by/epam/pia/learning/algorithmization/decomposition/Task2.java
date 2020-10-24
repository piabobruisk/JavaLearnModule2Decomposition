package by.epam.pia.learning.algorithmization.decomposition;

//2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    private static int[] prime;

    public static void main(String[] args) {


        int a;
        int b;
        int c;
        int d;

        int[] factorA;
        int[] factorB;
        int[] factorC;
        int[] factorD;

        do {
            a = input("Введите натуральное число А(>0)=");
        } while (a < 1);

        do {
            b = input("Введите натуральное число B(>0)=");
        } while (b < 1);

        do {
            c = input("Введите натуральное число C(>0)=");
        } while (c < 1);

        do {
            d = input("Введите натуральное число D(>0)=");
        } while (d < 1);

        prime = getPrime(Math.max(Math.max(a, b), Math.max(c, d)));

        factorA = primeFactorization(a);
        factorB = primeFactorization(b);
        factorC = primeFactorization(c);
        factorD = primeFactorization(d);

        int nod = getNOD(factorA, factorB, factorC, factorD);

        System.out.println("НОД=" + nod);
    }


    private static int getNOD(int[] a, int[] b, int[] c, int[] d) {
        int result = 1;
        for (int i = 0; i < prime.length; i++) {
            result *= Math.pow(prime[i], Math.min(Math.min(a[i], b[i]), Math.min(c[i], d[i])));
        }
        return result;
    }

    private static int[] primeFactorization(int a) {
        int primeIndex = 0;
        int[] result = new int[prime.length];
        while (a != 1) {
            if (a % prime[primeIndex] == 0) {
                a = a / prime[primeIndex];
                result[primeIndex]++;
            } else {
                primeIndex++;
            }
        }
        return result;

    }

    private static int[] getPrime(int n) {
        boolean[] array = new boolean[n + 1];
        Arrays.fill(array, true);
        for (int i = 2; i * i <= n; i++) {
            if (array[i]) {
                for (int j = i * i; j <= n; j += i) {
                    array[j] = false;
                }
            }
        }

        int k = 0;
        for (int i = 2; i < array.length; i++) {
            if (array[i]) k++;
        }

        int j = 0;
        int[] result = new int[k];
        for (int i = 2; i < array.length; i++) {
            if (array[i]) {
                result[j] = i;
                j++;
            }
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
