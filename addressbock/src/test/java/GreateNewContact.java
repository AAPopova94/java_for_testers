
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.TestBase;

public class GreateNewContact extends TestBase {

  @Test
  public void CreateNewContact() {
    createContact();
    app.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();

  }

  private void createContact() {
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
  }

}
