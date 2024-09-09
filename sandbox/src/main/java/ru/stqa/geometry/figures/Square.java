package ru.stqa.geometry.figures;

public class Square
{
    public static void printSquareArea(double a) {
       System.out.println("площадь квадрата со стороной " + a + " = " + squareArea(a));
   }

    private static double squareArea(double a) {
        return a * a;
    }
}
