
import Model.ContactData;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class CreateNewContact extends TestBase {

  @Test
  public void CreateNewContact() {
    createContact(new ContactData("Jon", "travolta", "milk", "900000000","Bell"));

  }

  @Test
  public void canCreateNewContactWithEmptyName() {
    createContact(new ContactData());

  }

  @Test
  public void canCreateNewContactWithOnlyName() {
    createContact(new ContactData().withName("Anna"));

  }

}
