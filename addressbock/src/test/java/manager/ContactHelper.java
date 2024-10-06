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

    public void removeContact() {
        chooseContact();
        deleteContact();
    }

    private void chooseContact() {
        click(By.name("selected[]"));
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
        click(By.id("content"));
        click(By.xpath("//input[@value=\'Delete\']"));
        click(By.linkText("home"));
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

    public int getCount() {
        return manager.driver.findElements(By.name("selected[]")).size();

    }

    public void removeAllContacts() {
        selectAllContact();
        deleteContact();
    }

    private void selectAllContact() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox :checkboxes){
            checkbox.click();
        }
    }
}
