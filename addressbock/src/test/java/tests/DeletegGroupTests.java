package tests;

import Model.GroupData;
import org.junit.jupiter.api.Test;


public class DeletegGroupTests extends TestBase {

  @Test
  public void deletegroup() {
    if (app.groups().isGroupPresent()) {
      app.groups().CreateGroup(new GroupData("name", "1", "1")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }
    app.groups().RemoveGroup();
  }

}