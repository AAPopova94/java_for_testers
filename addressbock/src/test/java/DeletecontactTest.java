
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.TestBase;


public class DeletecontactTest extends TestBase {

  @Test
  public void deletecontact() {
    if (!app.isElementPresent(By.name("selected[]"))){
      app.driver.findElement(By.linkText("add new")).click();
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
    app.driver.findElement(By.name("selected[]")).click();
    app.driver.findElement(By.id("content")).click();
    app.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
  }


}
