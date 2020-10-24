package by.epam.pia.learning.algorithmization.decomposition;

//8. Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3];
//                                               D[3] + D[4] + D[5];
//                                               D[4] + D[5] + D[6].
//Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов массива с номерами от k до m.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task8 {

    public static void main(String[] args) {

        int n;
        int k;
        int m;
        int[] d;

        do {
            n = input("Введите количество элементов массива N(>2)=");
        } while (n < 3);

        do {
            k = input("Введите первый индекс k(0..." + (n - 3) + ")=");
        } while (k < 0 || k > n - 3);

        do {
            m = input("Введите второй индекс m(" + (k + 2) + "..." + (n - 1) + ")=");
        } while (m < k + 2 || m > n - 1);

        d = initArray(n);
        System.out.println("Массив " + Arrays.toString(d));

        for (int i = k; i <= m-2; i++) {
            System.out.println("Сумма элементов ["+i+"..."+(i+2)+"] равна "+getSumElements(d, i, 3));
        }
    }

    private static int getSumElements(int[] a, int ind, int quantity) {
        int sum = 0;
        for (int i = 0; i < quantity; i++) {
            sum += a[ind + i];
        }
        return sum;
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
