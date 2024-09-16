package ru.stqa.geometry.figures;

public record Square(double side) {

    public Square{
        if(side < 0){
            throw new IllegalArgumentException("Square side should be non-negative");
        }

    }

    public static void printSquareArea(Square s) {
        String text = String.format("площадь квадрата со стороной %f = %f ", s.side, s.Area());
        System.out.println(text);
   }


    public double Area() {
        return this.side * this.side;
    };

    public double perimeter() {
        return  4 * this.side;
    }
}
