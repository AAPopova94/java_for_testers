package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class geometry {
    public static void main(String[] args) {
        Square.printSquareArea(7.7);
        Square.printSquareArea(5.0);
        Square.printSquareArea(3.2);

        Rectangle.printRectagleArea(3.0, 5.0);
        Triangle.printTriangelArea(3.0, 4.0, 5.0);
        Triangle.printTriangelPerimeter(3.0, 4.0, 5.0);
    }

}
