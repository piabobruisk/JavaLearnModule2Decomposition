package by.epam.pia.learning.algorithmization.decomposition;

//10. Дано натуральное число N. Написать метод(методы) для формирования массива,
//элементами которого являются цифры числа N.

import java.util.Arrays;
import java.util.Scanner;

public class Task10 {

    public static void main(String[] args) {

        int n;
        int[] result;

        do {
            n = input("Введите число N(>0)=");
        } while (n < 1);

        result = getArray(n);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getArray(int n) {

        int[] result;
        String number = Integer.toString(n);
        result = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            result[i] = Integer.parseInt(number.substring(i, i + 1));
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
