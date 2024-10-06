package tests;

import Model.GroupData;
import manager.TestBase;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    void  canModificationGroup(){
        if (app.groups().getCount() ==0) {
            app.groups().CreateGroup(new GroupData("name", "1", "1")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        }
        app.groups().modifyGroup(new GroupData().withName("modified name"));
    }
}
