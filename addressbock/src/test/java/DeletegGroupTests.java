
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

import java.util.NoSuchElementException;

public class DeletegGroupTests {
  private WebDriver driver;


  @BeforeEach
  public void setUp() {
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

  private boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException exception) {
      return false;
    }
  }
  @AfterEach
  public void tearDown() {
    driver.findElement(By.linkText("Logout")).click();
    driver.quit();
  }


  @Test
  public void deletegroup() {
    if (!isElementPresent(By.name("new"))) {
      driver.findElement(By.linkText("groups")).click();
    }
    driver.findElement(By.linkText("groups")).click();
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.name("delete")).click();
  }
}
