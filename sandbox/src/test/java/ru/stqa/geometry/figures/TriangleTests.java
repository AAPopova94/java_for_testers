package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCanculateArea(){
        var result = Triangle.Area(3.0, 4.0, 5.0);
        Assertions.assertEquals(6.0, Triangle.Area(3.0, 4.0, 5.0));
    }

    @Test
    void canCanculatePerimeter(){
        var result = Triangle.perimeter(3.0, 4.0, 5.0);
        Assertions.assertEquals(12.0 , Triangle.perimeter(3.0, 4.0, 5.0));

    }
}
