package ru.stqa.geometry.figures;

public class Triangle {
    public static void printTriangelArea(double a, double b, double c ) {
        String text = String.format("площадь треугольника со сторонами %f, %f, %f = %f ", a, b, c,  Area(a,b,c));
        System.out.println(text);
    }
    public static double Area(double a, double b, double c ) {
        double pp = (a + b + c) / 2.0;  // полупериметр
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
    }

    public static void printTriangelPerimeter(double a, double b, double c ) {
        String text = String.format("Периметр треугольника со сторонами %f, %f, %f = %f ", a, b, c,  perimeter(a,b,c));
        System.out.println(text);
    }
    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }
}
