import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class GroupCreationTests extends TestBase { //extends TestBase -  наследование класса

    @Test
    public void canCreateGroup() {
        OpenGroupPage(); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        CreateGoup("groupname", "1","2"); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }


    @Test
    public void canCreateGroupWithEmptyName() {
        driver.findElement(By.linkText("groups")).click();
        CreateGoup("", "","");//мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }
}
