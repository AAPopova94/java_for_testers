package tests;

import Model.ContactData;
import Model.GroupData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CreateNewContact extends TestBase {

  public static List<ContactData> contactProvider() {
    var result = new ArrayList<ContactData>(List.of(
            new ContactData(),
            new ContactData("Jon", "travolta", "milk", "900000000","Bell")),
            new ContactData().withName("Anna")));
    int i;
    for (i = 0; i < 5; i++){
      result.add(new ContactData(randomString(i), randomString(i), randomString(i), randomString(i)));
    }
    return result;
  }

  @Test
  public void CreateNewContact() {
    int contactCount = app.contacts().getCount();
    app.contacts().createContact(new ContactData("Jon", "travolta", "milk", "900000000","Bell"));
    int newContactCount = app.contacts().getCount();
    Assertions.assertEquals(contactCount + 1, newContactCount);
  }


  @Test
  public void canCreateNewContactWithOnlyName() {
    app.contacts().createContact(new ContactData().withName("Anna"));

  }

  @ParameterizedTest
  @MethodSource("contactProvider")
  public void canCreateMultipleContact(ContactData contact) {
    int contactCount = app.contacts().getCount();
    app.contacts().createContact(contact);
    int newContactCount = app.contacts().getCount();
    Assertions.assertEquals(contactCount + 1, newContactCount);

  }


}
