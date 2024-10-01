
import Model.ContactData;
import org.junit.jupiter.api.Test;
import tests.TestBase;


public class DeletecontactTest extends TestBase {

  @Test
  public void deletecontact() {
    if (!isContactPresent()){
      createContact(new ContactData("Jon", "travolta", "milk", "900000000","Bell"));
    }
    removeContact();
  }


}
