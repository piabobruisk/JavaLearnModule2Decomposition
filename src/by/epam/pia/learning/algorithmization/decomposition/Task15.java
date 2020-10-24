package by.epam.pia.learning.algorithmization.decomposition;

//15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность
// (например, 1234, 5789). Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class Task15 {

    public static void main(String[] args) {

        int n;
        int from;
        int to;

        do {
            n = input("Количество разрядов числа n(>1)=");
        } while (n < 2);

        from = (int) Math.pow(10, n - 1);
        to = (int) Math.pow(10, n) - 1;

        for (int i = from; i <= to; i++) {

            if (isSequence(i, n)) {
                System.out.println("Последовательность:" + i);
            }
        }
    }

    private static boolean isSequence(int i, int n) {

        int[] numbers = getDigits(i, n);
        for (int j = 0; j < n - 1; j++) {
            if (numbers[j] + 1 != numbers[j + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getDigits(int k, int digit) {

        int[] numbers = new int[digit];
        for (int i = digit - 1; i >= 0; i--) {
            numbers[i] = k % 10;
            k /= 10;
        }
        return numbers;
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
