package by.epam.pia.learning.algorithmization.decomposition;

//9. Даны числа X, Y, Z, Т — длины сторон четырехугольника.
//Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y— прямой.

import java.util.Scanner;

public class Task9 {

    public static void main(String[] args) {

        int x;
        int y;
        int z;
        int t;
        double hypotenuse;

        do {
            x = input("Введите длину стороны x(>0)=");
        } while (x < 1);

        do {
            y = input("Введите длину стороны y(>0)=");
        } while (y < 1);

        do {
            z = input("Введите длину стороны z(>0)=");
        } while (z < 1);

        do {
            t = input("Введите длину стороны t(>0)=");
        } while (t < 1);

        hypotenuse = Math.sqrt(x * x + y * y);
        double quadrangle = triangleArea(x, y, hypotenuse) + triangleArea(z, t, hypotenuse);

        System.out.println("Площадь четырехугольника равна " + quadrangle);
    }

    private static double triangleArea(double a, double b, double c) {

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
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

