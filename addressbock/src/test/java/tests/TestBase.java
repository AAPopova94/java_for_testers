package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

///если захочу изменить условия -надо будет в скобках методов прописать имена переменных, как в CreateGoup
public class TestBase {

    public static ApplicationManager app; //прямая ссылка на другой класс

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init();

    }

}
