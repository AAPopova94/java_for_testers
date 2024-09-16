package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCanculateArea() {
        var s = new Square(5.0);// чтобы это работало - описали две строки в файле Square
        var result = s.Area(); // чтобы создать функцию, чтоб это заработало: option+enter => create method
        //Assertions.assertEquals(25.0, result);
        if (result != 25.0){
            throw new AssertionError(String.format("Фактический результат %f не равен ожидаемому результату %f", result, 25.0));
        }
    }

    @Test
    void canCanculatePerimeter(){

        Assertions.assertEquals(20.0,new Square(5.0).perimeter());
    }

    @Test
    void  CannotCreateSquereWithNegativeSide (){
        try {
            new  Square(-5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ок
        }

    }
    @Test
    void testEquality(){
        var s1 =  new Square(5.0);
        var s2 =  new Square(5.0);
        Assertions.assertEquals(s1,s2);
    }

    @Test
    void testNonEquality(){
        var s1 =  new Square(5.0);
        var s2 =  new Square(6.0);
        Assertions.assertNotEquals(s1,s2);
    }

    @Test
    void testTrue(){
        var s1 =  new Square(5.0);
        var s2 =  new Square(5.0);
        Assertions.assertTrue(s1.equals(s2));
    }
}
