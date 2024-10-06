package tests;

import Model.GroupData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DeletegGroupTests extends TestBase {

  @Test
  public void deletegroup() {
    if (app.groups().getCount() == 0) {
      app.groups().CreateGroup(new GroupData("name", "1", "1")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }
    int groupCount = app.groups().getCount();
    app.groups().RemoveGroup();
    int newGroupCount = app.groups().getCount();
    Assertions.assertEquals(groupCount -1, newGroupCount);
  }

  @Test
  void  canRemoveAllGroupsAtOnse () {
    if (app.groups().getCount() == 0) {
      app.groups().CreateGroup(new GroupData("name", "1", "1")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }
    app.groups().removeAllGroups();
    Assertions.assertEquals(0, app.groups().getCount());

  }

}
