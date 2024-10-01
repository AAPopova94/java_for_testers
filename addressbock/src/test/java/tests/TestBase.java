package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

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

    protected void createContact() {
       if (!app.isElementPresent(By.name("firstname"))){
           app.driver.findElement(By.linkText("add new")).click();//- то что сохраняет изменения
       }
      app.driver.findElement(By.name("firstname")).click();app.driver.findElement(By.name("firstname")).sendKeys("Anna");
      app.driver.findElement(By.name("middlename")).click();
      app.driver.findElement(By.name("middlename")).sendKeys("Jon");
      app.driver.findElement(By.name("lastname")).click();
      app.driver.findElement(By.name("lastname")).sendKeys("Popova");
      app.driver.findElement(By.name("nickname")).click();
      app.driver.findElement(By.name("nickname")).sendKeys("AnnLis");
      app.driver.findElement(By.name("mobile")).click();
      app.driver.findElement(By.name("mobile")).sendKeys("900000000");
      app.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
      app.driver.get("http://localhost/addressbook/index.php");

    }

    protected boolean isContactPresent() {
      return app.isElementPresent(By.name("selected[]"));
    }

    protected void removeContact() {
      app.driver.findElement(By.name("selected[]")).click();
      app.driver.findElement(By.id("content")).click();
      app.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    }
}
