package by.epam.pia.learning.algorithmization.decomposition;

//4. На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие,
//между какими из пар точек самое большое расстояние.
//Указание. Координаты точек занести в массив.

import java.util.Random;
import java.util.Scanner;

public class Task4 {

    private static int[] x;
    private static int[] y;

    public static void main(String[] args) {

        int n;
        int point1Index;
        int point2Index;

        do {
            n = input("Введите количество точек n(>2)=");
        } while (n < 3);

        x = new int[n];
        y = new int[n];

        initPoints();

        point1Index=0;
        point2Index=0;
        double maxDistance = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = getDistance(x[i], y[i], x[j], y[j]);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    point1Index = i;
                    point2Index = j;
                }
            }

        }
        System.out.println("Максимальное расстояние "+maxDistance+ " между точками с координатами "+x[point1Index]+"," +y[point1Index] + " и " +x[point2Index]+"," +y[point2Index]);
    }


    private static double getDistance(int x0, int y0, int x1, int y1) {
        return Math.sqrt(Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2));
    }

    private  static void initPoints(){
        for (int i = 0; i < x.length; i++) {
            int[] point = createPoint();
            x[i] = point[0];
            y[i] = point[1];
            System.out.println("Координаты точки "+i+" ("+x[i]+","+y[i]+")");
        }
    }

    private static int[] createPoint() {
        Random random;
        random = new Random();
        int[] a;
        a = new int[2];
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
