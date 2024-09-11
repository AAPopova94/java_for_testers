package ru.stqa.geometry.figures;

public class Square
{////// две нижние фунции private  double side и  public  Square(double side), чтобы заработал кусок в тестах
    private  double side; //тут нужно явно указывать какой тип данных будем передавать (дробное число стороны квадрата),
    //тут private, потому что это один раз внутри класса юзаем, ниже

    public  Square(double side) {
        this.side = side; //  первый side - это свойство объекта (выше), второй - параметр вызываемой фунции (сторона)
    }//тут паблик, потому что будем из другого файла вызывать ,, this.side - типа это свойство

    public static void printSquareArea(Square s) {
        String text = String.format("площадь квадрата со стороной %f = %f ", s.side, s.Area());
        System.out.println(text);
   }


    public double Area() {
        return this.side * this.side;
    };

    public double perimeter() {
        return  4 * this.side;
    }
}
