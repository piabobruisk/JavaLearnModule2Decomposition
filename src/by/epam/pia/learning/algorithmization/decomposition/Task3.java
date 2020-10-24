package by.epam.pia.learning.algorithmization.decomposition;

//3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        int a;

        do {
            a = input("Введите длину стороны правильного шестиугольника а(>0)=");
        } while (a < 1);

        System.out.println("Площадь шестиугольника = " + 6*triangleArea(a));
    }


    private static double triangleArea (int a){
        return Math.pow(a,2)*Math.sqrt(3)/4;
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
