package tests;

import Model.ContactData;
import Model.GroupData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class DeletecontactTest extends TestBase {

  @Test
  public void deletecontact() throws InterruptedException {
    if (app.contacts().getCount()== 0){
      app.contacts().createContact(new ContactData("", "Jon", "travolta", "milk", "900000000","Bell"));
    }
    var oldContact = app.contacts().getList();
    var rnd = new Random();
    var index = rnd.nextInt(oldContact.size());
    app.contacts().removeContact(oldContact.get(index));
    TimeUnit.SECONDS.sleep(1);
    var newContact = app.contacts().getList();
    var expectedList = new ArrayList<>(oldContact);
    expectedList.remove(index);
    Assertions.assertEquals(newContact, expectedList);
  }

  @Test
  void removeAllContact(){
    if (app.contacts().getCount()== 0){
      app.contacts().createContact(new ContactData("", "Jon", "travolta", "milk", "900000000","Bell"));
    }
    app.contacts().removeAllContacts();
    Assertions.assertEquals(0, app.contacts().getCount());
  }


}
