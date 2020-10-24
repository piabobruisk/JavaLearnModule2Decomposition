package by.epam.pia.learning.algorithmization.decomposition;

// 14. Натуральное число, в записи которого n цифр, называется числом Армстронга,
// если сумма его цифр, возведенная в степень n, равна самому числу.
// Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class Task14 {

    public static void main(String[] args) {

        int k;
        int[] digits;

        do {
            k = input("Введите граничное число число к(>1)=");
        } while (k < 2);

        for (int i = 1; i < k; i++) {
            digits = getDigits(i);
            int degree = digits.length;
            int sum = 0;
            for (int j = 0; j < degree; j++) {
                sum += Math.pow(digits[j], degree);
            }
            if (i == sum) System.out.println("Число армстронга:" + i);
        }
    }

    private static int[] getDigits(int n) {

        int number = numberDigits(n);
        int[] digits = new int[number];
        for (int i = number - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }


    private static int numberDigits(int n) {

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
