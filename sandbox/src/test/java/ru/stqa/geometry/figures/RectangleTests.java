package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {

    @Test
    void CannotCreateRectangleWithNegativeSide() {
        try {
            new Rectangle(-5.0, 3.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ок
        }
    }

    @Test
    void testRectangleEquality(){
        var r1 =  new Rectangle(5.0, 4.0);
        var r2 =  new Rectangle(5.0,4.0);
        Assertions.assertEquals(r1,r2);
    }
    @Test
    void testRectangleEquality1(){
        var r1 =  new Rectangle(5.0, 4.0);
        var r2 =  new Rectangle(4.0,5.0);
        Assertions.assertEquals(r1,r2);
    }
}
