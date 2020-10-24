package by.epam.pia.learning.algorithmization.decomposition;

//12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А,
//элементами которого являются числа, сумма цифр которых равна К и которые не большее N.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) {

        int k;
        int n;
        int[] a;

        do {
            k = input("Введите первое число k(>0)=");
        } while (k < 1);

        do {
            n = input("Введите второе число n(>0)=");
        } while (n < 1);

        a=initArray(k,n);
        System.out.print("Массив "+ Arrays.toString(a));
    }

    private static int[] initArray(int k, int n) {

        Random random;
        random = new Random();
        int[] a;
        a = new int[10];

        for (int i = 0; i < a.length; i++) {
            int tmp;
            do{
                tmp = random.nextInt(n);
            } while ( sumNumberDigits(tmp)!=k);
            a[i] = tmp;
        }
        return a;
    }

    private static int sumNumberDigits(int n) {

        int result = 0;
        while (n > 0) {
            result+=n%10;
            n /= 10;
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
