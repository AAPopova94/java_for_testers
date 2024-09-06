public class geometry {
    public static void main(String[] args) {
        printSquareArea(7.7);
        printSquareArea(5.0);
        printSquareArea(3.2);

        printRectagleArea(3.0, 5.0);
    }

    private static void printRectagleArea(double a, double b) {
        System.out.println("площадь прямоугольника со сторонами " + a + " и " + b +" = " + rectagleArea(a, b));
    }

    private static double rectagleArea(double a, double b) {
        return  a * b;
    }

    static void printSquareArea(double a) {
       System.out.println("площадь квадрата со стороной " + a + " = " + squareArea(a));
   }

    private static double squareArea(double a) {
        return a * a;
    }
}
