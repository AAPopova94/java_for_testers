package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCanculateArea() {
        var result = Square.Area(5.0);
        Assertions.assertEquals(25.0, result);
    }

    @Test
    void canCanculatePerimeter(){
        Assertions.assertEquals(20.0, Square.perimeter(5.0));
    }
}