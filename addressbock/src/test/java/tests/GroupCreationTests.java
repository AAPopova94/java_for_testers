package tests;

import Model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class GroupCreationTests extends TestBase { //extends tests.TestBase -  наследование класса

    @Test
    public void canCreateGroup() {
        app.groups().CreateGroup(new GroupData("name", "1", "2")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }


    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().CreateGroup(new GroupData());//мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().CreateGroup(new GroupData().withName("Some name"));//конструкция позволяет вызвать конкретный заполненный параметр из метода с пустыми параметрами
    }
}
