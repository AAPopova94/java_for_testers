package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCanculateArea() {
        var s = new Square(5.0);// чтобы это работало - описали две строки в файле Square
        var result = s.Area(); // чтобы создать функцию, чтоб это заработало: option+enter => create method
        Assertions.assertEquals(25.0, result);
    }

    @Test
    void canCanculatePerimeter(){

        Assertions.assertEquals(20.0,new Square(5.0).perimeter());
    }
}
