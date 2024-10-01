
import org.junit.jupiter.api.Test;
import tests.TestBase;


public class DeletecontactTest extends TestBase {

  @Test
  public void deletecontact() {
    if (!isContactPresent()){
      createContact();
    }
    removeContact();
  }


}
