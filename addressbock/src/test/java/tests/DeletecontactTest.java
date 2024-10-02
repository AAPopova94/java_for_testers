package tests;

import Model.ContactData;
import org.junit.jupiter.api.Test;


public class DeletecontactTest extends TestBase {

  @Test
  public void deletecontact() {
    if (!app.contacts().isContactPresent()){
      app.contacts().createContact(new ContactData("Jon", "travolta", "milk", "900000000","Bell"));
    }
    app.contacts().removeContact();
  }


}
