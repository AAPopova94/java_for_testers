import java.io.File;

public class Hello {
    public static void main(String[] args) {
        try {
            var z = Ganculate();
            System.out.println(z);
            System.out.println("Hello,World!");
        } catch (ArithmeticException exception) {
            exception.printStackTrace();
        }
    }

    private static int Ganculate() {
        var x =1;
        var y= 1;
        var z = divite(x, y);
        return z;
    }

    private static int divite(int x, int y) {
        var z = x / y;
        return z;
    }

}
