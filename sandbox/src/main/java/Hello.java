public class Hello {
    public static void main(String[] args) {

            var x =1;
            var y= 1;
            if (y == 0){
                System.out.println("Деление на 0 запрещено");
            } else {
                var z = divite(x, y);
                System.out.println("Hello,World!");
            }
    }

    private static int divite(int x, int y) {
        var z = x / y;
        return z;
    }

}
