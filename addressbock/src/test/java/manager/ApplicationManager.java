package manager;

import Model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public  WebDriver driver;// прямая ссылка на глобальный браузер, используемый в тестах
    private LoginHelper session;// прямая сылка в класс со всеми методами, связаными с логином
    private GroupHelper groups;

    public void init() {
        if (driver == null) {
          driver = new ChromeDriver();
          Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
          driver.get("http://localhost/addressbook/index.php");
          driver.manage().window().setSize(new Dimension(1641, 979));
            session().login("admin", "secret",this);
        }
    }

    public  LoginHelper session(){
        if(session == null){
            session = new LoginHelper(this);
        }
        return session;
     }

    public  GroupHelper groups(){
        if(groups == null){
            groups = new GroupHelper(this);
        }
        return groups;
    }

    public boolean isElementPresent(By locator) {
      try {
        driver.findElement(locator);
        return true;
      } catch (NoSuchElementException exception) {
        return false;
      }
    }


    public void createContact(ContactData contact) {
      if (!isElementPresent(By.name("firstname"))){
           driver.findElement(By.linkText("add new")).click();//- то что сохраняет изменения
       }
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        driver.findElement(By.name("middlename")).click();
      driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
      driver.findElement(By.name("nickname")).click();
      driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
      driver.findElement(By.name("mobile")).click();
      driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
      driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
      driver.get("http://localhost/addressbook/index.php");

    }

    public boolean isContactPresent() {
      return isElementPresent(By.name("selected[]"));
    }

    public void removeContact() {
      driver.findElement(By.name("selected[]")).click();
      driver.findElement(By.id("content")).click();
      driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    }
}
