package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));

        Rectangle.printRectagleArea(3.0, 5.0);
        Triangle.printTriangelArea(new Triangle(3.0, 4.0, 5.0));
        Triangle.printTriangelPerimeter(new Triangle(3.0, 4.0, 5.0));
    }

}
