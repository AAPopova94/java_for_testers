package ru.stqa.geometry.figures;

import java.util.Objects;

public record Rectangle(
        double a, double b) // если ставить record вместо class, можно сократить свойство
{
    public Rectangle{
        if(a() < 0 || b() < 0){
            throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(this.a, rectangle.a) == 0 && Double.compare(this.b, rectangle.b) == 0)
                ||(Double.compare(this.b, rectangle.a) == 0 && Double.compare(this.a, rectangle.b) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public static void printRectagleArea(double a, double b) {
        var text = String.format("Площадь прямоугольника со сторонами %f + %f = %f", a, b, rectagleArea(a, b));
        System.out.println(text);
    }

    private static double rectagleArea(double a, double b) {
        return  a * b;
    }
}
