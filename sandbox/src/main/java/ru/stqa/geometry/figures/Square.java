package ru.stqa.geometry.figures;

public class Square
{
    public static void printSquareArea(double a) {
        String text = String.format("площадь квадрата со стороной %f = %f ", a, Area(a));
        System.out.println(text);
   }

    public static double Area(double a) {
        return a * a;
    }


    public static double perimeter(double a) {
        return 4 * a;
    }
}
