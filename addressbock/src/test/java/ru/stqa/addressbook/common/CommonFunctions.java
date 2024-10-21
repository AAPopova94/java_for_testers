package ru.stqa.addressbook.common;

import java.util.Random;

public class CommonFunctions {
    //возвращает рандомное имя
    public static  String randomString(int n){
        var rnd = new Random();
        var result = "";
        for (int i =0; i < n; i++){
            result = result +(char) ('a' + rnd.nextInt(26));//преобразовали рандомное заполнение данных
        }

        return result;
    }
}
