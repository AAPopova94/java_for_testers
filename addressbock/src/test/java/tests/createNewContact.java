package tests;

import Model.ContactData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class createNewContact extends TestBase {

  public static List<ContactData> contactProvider() {
   var result = new ArrayList<ContactData>(List.of(
        new ContactData(),
           new ContactData("", "Jon", "travolta", "milk", "900000000","Bell","src/test/resources/images/hd1.png"),
            new ContactData().withLastName("Anna")));

    int i;
    for (i = 0; i < 5; i++){
      result.add(new ContactData()
              .withLastName(randomString(i))
              .withMiddleName(randomString(i))
              .withNickName(randomString(i))
              .withMobile(randomString(i))
              .withPhoto(""));
    }
    return result;
  }



  @ParameterizedTest
  @MethodSource("contactProvider")
  public void canCreateMultipleContact(ContactData contact) {
    int contactCount = app.contacts().getCount();
    app.contacts().createContact(contact);
    int newContactCount = app.contacts().getCount();
    Assertions.assertEquals(contactCount + 1, newContactCount);

  }

  @Test
    void CreateContact(){
      var contact = new ContactData()
              .withFirstName("c photo")
              .withPhoto(randomFile("src/test/resources/images")); //возврат любого файла из директории рандом
      app.contacts().createContact(contact);


  }

    @Test
    void CreateContact1(){
        var contact = new ContactData()
                .withFirstName("cphoto");
        app.contacts().createContact(contact);
  }



}
