package manager;

import Model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public static WebDriver driver; // прямая ссылка на глобальный браузер, используемый в тестах

    public void init() {
        if (driver == null) {
          driver = new ChromeDriver();
          Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
          driver.get("http://localhost/addressbook/index.php");
          driver.manage().window().setSize(new Dimension(1641, 979));
          driver.findElement(By.name("user")).sendKeys("admin");
          driver.findElement(By.name("pass")).click();
          driver.findElement(By.name("pass")).sendKeys("secret");
          driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    public boolean isElementPresent(By locator) {
      try {
        driver.findElement(locator);
        return true;
      } catch (NoSuchElementException exception) {
        return false;
      }
    }

    public void CreateGoup(GroupData group) {
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(group.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(group.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(group.footer());
        driver.findElement(By.name("submit")).click();
    }

    public void OpenGroupPage() {
        if (! isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
    }

    public boolean isGroupPresent() {
      return !isElementPresent(By.linkText("selected[]"));
    }

    public void RemoveGroup() {
      driver.findElement(By.linkText("groups")).click();
      driver.findElement(By.name("selected[]")).click();
      driver.findElement(By.name("delete")).click();
    }
}
