package tests;

import Model.GroupData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData(),
                new GroupData().withName("Some name"),
                new GroupData("", "group name", "group Header", "group Footer"),
                new GroupData("", "groupname", "123","456")));
        int i;
        for (i = 0; i < 5; i++){
            result.add(new GroupData().withName(randomString(i)).withFooter(randomString(i)).withHeader(randomString(i))); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        }
        return  result;
    }


    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroup(GroupData group) {
        var oldGroups = app.groups().getList();
        app.groups().CreateGroup(group); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        var newGroups = app.groups().getList();
        Comparator<GroupData> compareById = (o1, o2) -> {//заложенная функция .sort((o1, o2) сортирует списки
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));//то что в скобках так расписывается, потому что у нас не числа, а строки
        };
        newGroups.sort(compareById);
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newGroups.get(newGroups.size() -1).id()).withFooter("").withHeader(""));
        expectedList.sort(compareById); // отсортировали старый список по ИД, чтоб цифры совпали
        Assertions.assertEquals(newGroups, expectedList);

    }
}
