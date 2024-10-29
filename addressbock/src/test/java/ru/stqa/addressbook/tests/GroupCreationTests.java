package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.Model.GroupData;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
        var json = "";
        try (var reader = new FileReader("groups.json");
        var breader = new BufferedReader(reader)
        ) {
            var line = breader.readLine();
            while (line != null){
                json = json + line;
                line = breader.readLine();
            }

        }
        //var json = Files.readString(Paths.get("groups.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<GroupData>>(){});
        result.addAll(value);
        return  result;
    }
    public static List<GroupData> singleRandomGroup() throws IOException {
        return  List.of(new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withFooter(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(10)));
    }



        @ParameterizedTest
    @MethodSource("singleRandomGroup")
    public void canCreateGroup(GroupData group) {
        var oldGroups = app.jdbc().getGroupList();
        app.groups().CreateGroup(group); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        var newGroups = app.jdbc().getGroupList();
        Comparator<GroupData> compareById = (o1, o2) -> {//заложенная функция .sort((o1, o2) сортирует списки
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));//то что в скобках так расписывается, потому что у нас не числа, а строки
        };
        newGroups.sort(compareById);
        var maxId = newGroups.get(newGroups.size() -1).id();

        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(maxId));
        expectedList.sort(compareById); // отсортировали старый список по ИД, чтоб цифры совпали
        Assertions.assertEquals(newGroups, expectedList);

        var newUiGroups = app.groups().getList(); /// дописать проверку сравнения старого списка из бд и нового из интерфейса

    }
}
