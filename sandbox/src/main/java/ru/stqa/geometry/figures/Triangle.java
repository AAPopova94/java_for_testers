package ru.stqa.geometry.figures;

public class Triangle {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public static void printTriangelArea(Triangle tr) {
        String text = String.format("площадь треугольника со сторонами %f, %f, %f = %f ", tr.sideA, tr.sideB, tr.sideC, tr.Area());
        System.out.println(text);
    }


    public static void printTriangelPerimeter(Triangle tr) {
        String text = String.format("Периметр треугольника со сторонами %f, %f, %f = %f ", tr.sideA, tr.sideB, tr.sideC, tr.perimeter());
        System.out.println(text);
    }

    public double Area() {
        double pp = (this.sideA + this.sideB + this.sideC) / 2.0;
        return Math.sqrt(pp * (pp - this.sideA) * (pp - this.sideB) * (pp - this.sideC));
    }

    public double perimeter() {
        return this.sideA + this.sideB + this.sideC;
    }
}

