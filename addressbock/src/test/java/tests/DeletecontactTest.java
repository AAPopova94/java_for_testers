package tests;

import Model.ContactData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class DeletecontactTest extends TestBase {

  @Test
  public void deletecontact() throws InterruptedException {
    if (app.contacts().getCount()== 0){
      app.contacts().createContact(new ContactData("Jon", "travolta", "milk", "900000000","Bell"));
    }
    int contactCount = app.contacts().getCount();
    app.contacts().removeContact();
    TimeUnit.SECONDS.sleep(1);
    int newContactCount = app.contacts().getCount();
    Assertions.assertEquals(contactCount -1, newContactCount);
  }

  @Test
  void removeAllContact(){
    if (app.contacts().getCount()== 0){
      app.contacts().createContact(new ContactData("Jon", "travolta", "milk", "900000000","Bell"));
    }
    app.contacts().removeAllContacts();
    Assertions.assertEquals(0, app.contacts().getCount());
  }


}
