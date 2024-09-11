package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {


    @Test
    void canCanculateArea(){
        var t = new Triangle(3.0,4.0,5.0);
        var result = t.Area();
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void canCanculatePerimeter(){

        Assertions.assertEquals(12.0 , new Triangle(3.0,4.0,5.0).perimeter());

    }
}
