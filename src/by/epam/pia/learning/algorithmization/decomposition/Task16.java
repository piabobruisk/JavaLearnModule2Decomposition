package by.epam.pia.learning.algorithmization.decomposition;

// 16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
// Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class Task16 {

    public static void main(String[] args) {

        int n;
        int from;
        int to;
        int sum;

        do {
            n = input("Количество разрядов числа n(>0)=");
        } while (n < 1);

        from = (int) Math.pow(10, n - 1);
        to = (int) Math.pow(10, n) - 1;
        sum = 0;

        for (int i = from; i <= to; i++) {
            if (isSequence(i, n)) {
                sum += i;
            }
        }
        System.out.println("Cумма всех чисел содержащих нечетные цифры = " + sum);
        System.out.println("Четных цифр в сумме = " + getEvenDigits(sum));
    }

    private static int getEvenDigits(int number) {

        int digit = numberDigits(number);
        int[] numbers = getDigits(number, digit);
        int sum = 0;
        for (int i = 0; i < digit; i++) {
            if (numbers[i] % 2 == 0) {
                sum++;
            }
        }
        return sum;
    }

    private static boolean isSequence(int i, int n) {

        int[] numbers = getDigits(i, n);
        for (int j = 0; j < n; j++) {
            if (numbers[j] % 2 == 0) {
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
