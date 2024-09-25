import Model.GroupData;
import manager.ApplicationManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class GroupCreationTests extends TestBase { //extends TestBase -  наследование класса

    @Test
    public void canCreateGroup() {
        app.OpenGroupPage(); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        app.CreateGoup(new GroupData("name", "1", "2")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }


    @Test
    public void canCreateGroupWithEmptyName() {
        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        app.CreateGoup(new GroupData());//мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        app.CreateGoup(new GroupData().withName("Some name"));//конструкция позволяет вызвать конкретный заполненный параметр из метода с пустыми параметрами
    }
}
