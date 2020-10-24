package by.epam.pia.learning.algorithmization.decomposition;

// 13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2
// (например, 41 и 43). Найти и напечатать все пары «близнецов» из отрезка [n,2n],
// где n - заданное натуральное число больше 2. Для решения задачи использовать декомпозицию.

import java.util.Arrays;
import java.util.Scanner;

public class Task13 {

    private static int[] prime;

    public static void main(String[] args) {

        int n;

        do {
            n = input("Введите число n(>2)=");
        } while (n < 1);

        prime = getPrime(2*n);

        for (int i =0; i<prime.length-1; i++ ){
            if (prime[i]>=n){
                if (isTwin(i)) {
                    System.out.println("Близнецы "+prime[i]+" и "+ prime[i+1]);
                }
            }
        }
    }

    private static boolean isTwin(int i) {

        return  (prime[i+1]-prime[i]==2);
    }


    private static int getNOD(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < prime.length; i++) {
            result *= Math.pow(prime[i], Math.min(a[i], b[i]));
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
