package tests;

import Model.GroupData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase { //extends manager.TestBase -  наследование класса

    @Test
    public void canCreateGroup() {
        int groupCount = app.groups().getCount();
        app.groups().CreateGroup(new GroupData("name", "1", "2")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount +1, newGroupCount);

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
