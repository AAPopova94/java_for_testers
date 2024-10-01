package tests;

import Model.ContactData;
import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

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

    protected void createContact(ContactData contact) {
      if (!app.isElementPresent(By.name("firstname"))){
           app.driver.findElement(By.linkText("add new")).click();//- то что сохраняет изменения
       }
        app.driver.findElement(By.name("firstname")).click();
        app.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        app.driver.findElement(By.name("middlename")).click();
      app.driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
      app.driver.findElement(By.name("lastname")).click();
      app.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
      app.driver.findElement(By.name("nickname")).click();
      app.driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
      app.driver.findElement(By.name("mobile")).click();
      app.driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
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
