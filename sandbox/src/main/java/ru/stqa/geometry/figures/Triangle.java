package ru.stqa.geometry.figures;

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
}

