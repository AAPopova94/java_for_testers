package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {


    @Test
    void canCanculateArea() {
        var t = new Triangle(3.0, 4.0, 5.0);
        var result = t.Area();
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void canCanculatePerimeter() {

        Assertions.assertEquals(12.0, new Triangle(3.0, 4.0, 5.0).perimeter());

    }

    @Test
    void CannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 4.0, 3.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ок
        }
    }

    @Test
    void CannotCreateTriangleWithUnfaithfulSide() {
        try {
            new Triangle(6.0, 3.0, 3.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ок
        }
    }
}
