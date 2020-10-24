package by.epam.pia.learning.algorithmization.decomposition;

// 17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
// Сколько таких действий надо произвести, чтобы получился нуль?
// Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class Task17 {

    public static void main(String[] args) {

        int n;
        int quantity;

        do {
            n = input("Введите число n(>0)=");
        } while (n < 1);

        quantity = 0;

        while (n > 0) {
            System.out.print(n+" - ");
            int sumDigits = getSumDigits(n);
            n -= getSumDigits(n);
            quantity++;
            System.out.println(sumDigits +" = "+ n);
        }
        System.out.println("Понадобилось операций вычитания:"+ quantity);
    }

    private static int getSumDigits(int n) {

        int digit = numberDigits(n);
        int[] numbers = getDigits(n, digit);
        int sum = 0;
        for (int i = 0; i < digit; i++) {
            sum+= numbers[i];
        }
        return sum;
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
