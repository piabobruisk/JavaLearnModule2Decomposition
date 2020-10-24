package by.epam.pia.learning.algorithmization.decomposition;

//5. Составить программу, которая в массиве A[N] находит второе по величине число
//(вывести на печать число, которое меньше максимального элемента массива,
// но больше всех других элементов).

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {

        int n;
        int beforeMax;
        int[] a;

        do {
            n = input("Введите количество элементов массива N(>2)=");
        } while (n < 3);

        a = initArray(n);
        System.out.println("Массив " + Arrays.toString(a));

        beforeMax = getBeforeMax(a);

        System.out.print("Индекс(ы) второго по величине числа в массиве (" + beforeMax + ") :");
        for (int i = 0; i < a.length; i++) {
            if (a[i] == beforeMax) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("\b\b");
    }

    private static int getBeforeMax(int[] a) {
        int[] tmp = sortArray(a.clone());
        return tmp[tmp.length - 2];
    }

    private static int[] initArray(int n) {
        Random random;
        random = new Random();
        int[] a;
        a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100) - 50;
        }
        return a;
    }

    private static int[] sortArray(int[] a) {

        for (int step = a.length / 2; step > 0; step /= 2) {
            for (int i = step; i < a.length; i++) {
                for (int j = i - step; j >= 0 && a[j] > a[j + step]; j -= step) {
                    swap(a, j, j + step);
                }
            }
        }
        return a;
    }

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
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
