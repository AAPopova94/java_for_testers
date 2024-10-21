package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.Model.ContactData;
import ru.stqa.addressbook.Model.GroupData;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class createNewContact extends TestBase {

  public static List<ContactData> contactProvider() throws IOException {
   var result = new ArrayList<ContactData>();

      var json = Files.readString(Paths.get("contacts.json"));
      ObjectMapper mapper = new ObjectMapper();
      var value = mapper.readValue(json, new TypeReference<List<ContactData>>(){});
      result.addAll(value);
      return  result;
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
