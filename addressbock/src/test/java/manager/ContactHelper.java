package manager;

import Model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends  HelperBase{



    public ContactHelper(ApplicationManager manager){
        super(manager);
    }


    public void createContact(ContactData contact) {
        openPageCreateContact();
        fillConactForm(contact);
        clickForCreate();
        returnToContactPage();

    }

    public boolean isContactPresent() {
      return manager.isElementPresent(By.name("selected[]"));
    }

    public void removeContact() {
        deleteContact();
    }
    public void modifyContact(ContactData modifiedContact) {
        // OpenContactPage();
        initcontactModification();
        fillConactForm(modifiedContact);
        submitContactModification();
        returnToContactPage();
    }


    /////отсюда - вспомогашки

    private void openPageCreateContact() {
        if (!manager.isElementPresent(By.name("firstname"))){
            click(By.linkText("add new"));
        }
    }


    private void clickForCreate() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }


    private void deleteContact() {
        click(By.name("selected[]"));
        click(By.id("content"));
        click(By.xpath("//input[@value=\'Delete\']"));
    }


    private void returnToContactPage() {
        click(By.linkText("home page"));

    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void fillConactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("mobile"), contact.mobile());
    }


    private void initcontactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

}
