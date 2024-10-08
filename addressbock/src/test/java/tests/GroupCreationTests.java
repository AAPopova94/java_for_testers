package tests;

import Model.GroupData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;



public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData(),
                new GroupData().withName("Some name"),
                new GroupData("group name", "group Header", "group Footer"),
                new GroupData("groupname", "123","456")));
        int i;
        for (i = 0; i < 5; i++){
            result.add(new GroupData(randomString(i), randomString(i), randomString(i))); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        }
        return  result;
    }


    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroup(GroupData group) {
        int groupCount = app.groups().getCount();
        app.groups().CreateGroup(group); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);

    }
}
