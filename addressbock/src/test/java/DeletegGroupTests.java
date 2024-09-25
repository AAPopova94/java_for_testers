import Model.GroupData;
import org.junit.jupiter.api.Test;


public class DeletegGroupTests extends TestBase {

  @Test
  public void deletegroup() {
    app.OpenGroupPage(); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    if (app.isGroupPresent()) {
      app.CreateGoup(new GroupData("name", "1", "1")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }
    app.RemoveGroup();
  }

}
