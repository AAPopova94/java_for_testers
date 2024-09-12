package ru.stqa.geometry.figures;

public record Rectangle (double a, double b) // если ставить record вместо class, можно сократить свойство
{
    public static void printRectagleArea(double a, double b) {
        var text = String.format("Площадь прямоугольника со сторонами %f + %f = %f", a, b, rectagleArea(a, b));
        System.out.println(text);
    }

    private static double rectagleArea(double a, double b) {
        return  a * b;
    }
}
