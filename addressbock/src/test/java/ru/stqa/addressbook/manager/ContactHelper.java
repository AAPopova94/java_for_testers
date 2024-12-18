package ru.stqa.addressbook.manager;

import ru.stqa.addressbook.Model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends  HelperBase{



    public ContactHelper(ApplicationManager manager){
        super(manager);
    }


    public void createContact(ContactData contact) {
        openPageCreateContact();
        fillContactForm(contact);
        clickForCreate();
        returnToContactPage();

    }

    public void removeContact(ContactData contact) {
        chooseContact(contact);
        deleteContact();
    }

    private void chooseContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public void modifyContact(ContactData modifiedContact, ContactData contact) {
        // OpenContactPage();
        initcontactModification(contact);
        fillContactForm(modifiedContact);
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

    private void fillContactForm(ContactData contact) {
        if (!"".equals(contact.photo())){
            attach(By.name("photo"), contact.photo());
        }
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("mobile"), contact.mobile());
    }


    private void initcontactModification(ContactData contact) {
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

    public List<ContactData> getList() {
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.name("entry"));//так можно искать элементы по имени (тут - спан групп)
        for (var tr : trs){
            var name = tr.findElements(By.tagName("td")).get(1).getText();
            var checkbox = tr.findElement(By.name("selected[]"));//ищем все чекбоксы по элементу Селект в спане Групп)
            var id = checkbox.getAttribute("value"); // тут ищем ИД у всех найденных выше атрибутово со значеием value (А там на сайте имена зашиты)
            contacts.add(new ContactData().withId(id).withLastName(name));

        }
        return contacts;
    }
}
