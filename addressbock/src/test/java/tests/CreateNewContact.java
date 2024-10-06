package tests;

import Model.ContactData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateNewContact extends TestBase {

  @Test
  public void CreateNewContact() {
    int contactCount = app.contacts().getCount();
    app.contacts().createContact(new ContactData("Jon", "travolta", "milk", "900000000","Bell"));
    int newContactCount = app.contacts().getCount();
    Assertions.assertEquals(contactCount + 1, newContactCount);
  }

  @Test
  public void canCreateNewContactWithEmptyName() {
    app.contacts().createContact(new ContactData());

  }

  @Test
  public void canCreateNewContactWithOnlyName() {
    app.contacts().createContact(new ContactData().withName("Anna"));

  }

}
