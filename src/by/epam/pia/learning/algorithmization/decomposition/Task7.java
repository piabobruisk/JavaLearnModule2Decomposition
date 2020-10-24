package by.epam.pia.learning.algorithmization.decomposition;

//7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.

public class Task7 {

    public static void main(String[] args) {

        int sum=0;

        for (int i = 1; i <= 9 ; i++) {
            if (i%2!=0){
                sum += factorial(i);
            }
        }

        System.out.println("Сумма факториалов нечетных чисел от 1 до 9 равна "+ sum );
    }

    private static int factorial(int i){

        int factorial=i;

        for (int j = i-1; j >1 ; j--) {
            factorial*=j;
        }

        return factorial;
    }
}
