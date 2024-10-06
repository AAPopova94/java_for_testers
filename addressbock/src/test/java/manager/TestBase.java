package manager;

import org.junit.jupiter.api.BeforeEach;

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
    public String randomString(int n){
        var rnd = new Random();
        var result = "";
        for (int i =0; i < n; i++){
            result = result +(char) ('a' + rnd.nextInt(26));//преобразовали рандомное заполнение данных
        }

        return result;
    }

}
