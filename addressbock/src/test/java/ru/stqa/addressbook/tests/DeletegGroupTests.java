package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.Model.GroupData;
import ru.stqa.addressbook.manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;


public class DeletegGroupTests extends TestBase {

  @Test
  public void deletegroup() {
    if (app.groups().getCount() == 0) {
      app.groups().CreateGroup(new GroupData("", "name", "1", "1")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }
    var oldGroups = app.groups().getList();
    var rnd = new Random(); //рандомайзер цифр
    var index = rnd.nextInt(oldGroups.size()); //случайным образом выбор элемента из списка групп
    app.groups().RemoveGroup(oldGroups.get(index)); //удаление группы с конкретным индексом
    var newGrouos = app.groups().getList();
    var expectedList = new ArrayList<>(oldGroups); //временное убежище для списка групп
    expectedList.remove(index); // а тут мы из временного списка удалили конкретную группу по индексу
    Assertions.assertEquals(newGrouos, expectedList); //размер нового списка на единицу меньше размера старого списка
  }

  @Test
  void  canRemoveAllGroupsAtOnse () {
    if (app.groups().getCount() == 0) {
      app.groups().CreateGroup(new GroupData("", "name", "1", "1")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }
    app.groups().removeAllGroups();
    Assertions.assertEquals(0, app.groups().getCount());

  }

}
