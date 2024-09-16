package ru.stqa.geometry.figures;

import java.util.Objects;

public record Triangle (double sideA, double sideB, double sideC) {

    public Triangle{
     if(sideA <0 || sideB < 0 || sideC <0){
         throw new IllegalArgumentException("Triangle side should be non-negative");
     }
        if(sideA + sideB == sideC|| sideC + sideB == sideA ||sideA + sideC == sideB){
            throw new IllegalArgumentException("The sum of two sides of a triangle cannot be equal to the third side");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(this.sideA, triangle.sideA) == 0 && Double.compare(this.sideB, triangle.sideB) == 0 && Double.compare(this.sideC, triangle.sideC) == 0)
                || (Double.compare(this.sideB, triangle.sideA) == 0 && Double.compare(this.sideC, triangle.sideB) == 0 && Double.compare(this.sideA, triangle.sideC) == 0)
                || (Double.compare(this.sideC, triangle.sideA) == 0 && Double.compare(this.sideA, triangle.sideB) == 0 && Double.compare(this.sideB, triangle.sideC) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, sideC);
    }
}

