
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.TestBase;


public class DeletecontactTest extends TestBase {

  @Test
  public void deletecontact() {
    app.driver.findElement(By.xpath("//tr[4]/td/input")).click();
    app.driver.findElement(By.id("content")).click();
    app.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
  }
}
