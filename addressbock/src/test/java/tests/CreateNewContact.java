package tests;

import Model.ContactData;
import org.junit.jupiter.api.Test;

public class CreateNewContact extends TestBase {

  @Test
  public void CreateNewContact() {
    app.createContact(new ContactData("Jon", "travolta", "milk", "900000000","Bell"));

  }

  @Test
  public void canCreateNewContactWithEmptyName() {
    app.createContact(new ContactData());

  }

  @Test
  public void canCreateNewContactWithOnlyName() {
    app.createContact(new ContactData().withName("Anna"));

  }

}
