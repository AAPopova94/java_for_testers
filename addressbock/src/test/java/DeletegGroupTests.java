
import Model.GroupData;
import org.junit.jupiter.api.Test;


public class DeletegGroupTests extends TestBase  {

  @Test
  public void deletegroup() {
    OpenGroupPage(); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    if (isGroupPresent()) {
      CreateGoup(new GroupData("name", "1", "1")); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
    }
    RemoveGroup();
  }

}
