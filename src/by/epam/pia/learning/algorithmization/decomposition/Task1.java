package by.epam.pia.learning.algorithmization.decomposition;

//1. Написать метод(методы) для нахождения наибольшего общего делителя
// и наименьшего общего кратного двух натуральных чисел:
// НОК(A,B) = A*B / НОД (A,B)

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

    private static int[] prime;

    public static void main(String[] args) {


        int a;
        int b;
        int[] factorA;
        int[] factorB;
        do {
            a = input("Введите натуральное число А(>0)=");
        } while (a < 1);

        do {
            b = input("Введите натуральное число B(>0)=");
        } while (b < 1);

        prime = getPrime(Math.max(a, b));

        factorA = primeFactorization(a);
        factorB = primeFactorization(b);

        int nod = getNOD(factorA, factorB);
        int nok = a * b / nod;
        System.out.println("НОК=" + nok);
    }


    private static int getNOD(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < prime.length; i++) {
            result *= Math.pow(prime[i], Math.min(a[i], b[i]));
        }
        return result;
    }

    /*private static int getNOK(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < prime.length; i++) {
            result *= Math.pow(prime[i], Math.max(a[i], b[i]));
        }
        return result;
    }*/

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

        //Тут лучше бы использовать ArrayList, но предполагается что во втором модуле мы еще не знакомы с коллекциями,
        // по этому только хардкор и олдскул :-)
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
