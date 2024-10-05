package tests;

import Model.ContactData;
import Model.GroupData;
import org.junit.jupiter.api.Test;

public class ContactModificationTest extends TestBase{

        @Test
        void  canModificationContact() {
            if (!app.contacts().isContactPresent()) {
                app.contacts().createContact(new ContactData("Jon", "travolta", "milk", "900000000", "Bell"));
            }
            app.contacts().modifyContact(new ContactData().withName("modified name"));
        }
        }

