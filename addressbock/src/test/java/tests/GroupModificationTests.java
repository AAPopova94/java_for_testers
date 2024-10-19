package tests;

import Model.GroupData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTests extends TestBase {

    @Test
    void  canModificationGroup(){
        if (app.groups().getCount() ==0) {
            app.groups().CreateGroup(new GroupData("", "name", "1", "1")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        }
        var oldGroups = app.groups().getList();
        var rnd = new Random(); //рандомайзер цифр
        var index = rnd.nextInt(oldGroups.size());
        var testData = new GroupData().withName("modified name");
        app.groups().modifyGroup(oldGroups.get(index), testData);
        var newGroups = app.groups().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
        Comparator<GroupData> compareById = (o1, o2) -> {//заложенная функция .sort((o1, o2) сортирует списки
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));//то что в скобках так расписывается, потому что у нас не числа, а строки
        };
        newGroups.sort(compareById); // отсортировали новый список по ИД, чтоб цифры совпали
        expectedList.sort(compareById); // отсортировали старый список по ИД, чтоб цифры совпали
        Assertions.assertEquals(newGroups, expectedList);
    }
}
