package manager;

import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

///если захочу изменить условия -надо будет в скобках методов прописать имена переменных, как в CreateGoup
public class TestBase {

    public static ApplicationManager app; //прямая ссылка на другой класс

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "firefox"));

    }

    //возвращает рандомное имя
    public static  String randomString(int n){
        var rnd = new Random();
        var result = "";
        for (int i =0; i < n; i++){
            result = result +(char) ('a' + rnd.nextInt(26));//преобразовали рандомное заполнение данных
        }

        return result;
    }


    ///Возвращает рандомный файл из директории файлов
    public static String randomFile(String dir){
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }

}
