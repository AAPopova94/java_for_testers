package tests;

import Model.ContactData;
import Model.GroupData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTest extends TestBase {

        @Test
        void  canModificationContact() {
            if (app.contacts().getCount() == 0) {
                app.contacts().createContact(new ContactData("", "Jon", "travolta", "milk", "900000000", "Bell"));
            }
            var oldContact = app.contacts().getList();
            var rnd = new Random();
            var index = rnd.nextInt(oldContact.size());
            var testData = new ContactData().withName("modified name");
            app.contacts().modifyContact(oldContact.get(index), testData);
            var newContact = app.contacts().getList();
            var expectedList = new ArrayList<>(oldContact);
            expectedList.set(index, testData.withId(oldContact.get(index).id()));
            Comparator<ContactData> compareById = (o1, o2) -> {//заложенная функция .sort((o1, o2) сортирует списки
                return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));//то что в скобках так расписывается, потому что у нас не числа, а строки
            };
            newContact.sort(compareById); // отсортировали новый список по ИД, чтоб цифры совпали
            expectedList.sort(compareById);
            Assertions.assertEquals(newContact, expectedList);
        }
        }

