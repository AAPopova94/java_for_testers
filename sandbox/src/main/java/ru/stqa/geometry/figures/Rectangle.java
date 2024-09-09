package ru.stqa.geometry.figures;

public class Rectangle {
    public static void printRectagleArea(double a, double b) {
        System.out.println("площадь прямоугольника со сторонами " + a + " и " + b +" = " + rectagleArea(a, b));
    }

    private static double rectagleArea(double a, double b) {
        return  a * b;
    }
}
