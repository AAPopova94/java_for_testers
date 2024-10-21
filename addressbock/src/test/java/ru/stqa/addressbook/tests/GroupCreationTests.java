package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.Model.GroupData;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("groups.json"), new TypeReference<List<GroupData>>(){});
        result.addAll(value);
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
