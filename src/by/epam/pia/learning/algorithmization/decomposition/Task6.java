package by.epam.pia.learning.algorithmization.decomposition;

//6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {

    private static int[] prime;

    public static void main(String[] args) {

        int a;
        int b;
        int c;
        int[] factorA;
        int[] factorB;
        int[] factorC;

        do {
            a = input("Введите натуральное число А(>0)=");
        } while (a < 1);

        do {
            b = input("Введите натуральное число B(>0)=");
        } while (b < 1);

        do {
            c = input("Введите натуральное число С(>0)=");
        } while (c < 1);

        prime = getPrime(Math.max(Math.max(a, b), c));

        factorA = primeFactorization(a);
        factorB = primeFactorization(b);
        factorC = primeFactorization(c);

        int nod = getNOD(factorA, factorB, factorC);
        if (nod > 1) {
            System.out.println("Числа не взаимно простые. НОД=" + nod);
        } else {
            System.out.println("Числа взаимно простые.");
        }
    }


    private static int getNOD(int[] a, int[] b, int[] c) {
        int result = 1;
        for (int i = 0; i < prime.length; i++) {
            result *= Math.pow(prime[i], Math.min(Math.min(a[i], b[i]), c[i]));
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
        //находим простые числа методом Эратосфена
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
