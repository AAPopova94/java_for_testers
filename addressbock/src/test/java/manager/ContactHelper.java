package manager;

import Model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper {

    private final ApplicationManager manager;


    public ContactHelper(ApplicationManager manager){
        this.manager = manager;
    }


    public void createContact(ContactData contact) {
      if (!manager.isElementPresent(By.name("firstname"))){
          manager.driver.findElement(By.linkText("add new")).click();//- то что сохраняет изменения
       }
        fillConactForm(contact);
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        //manager.driver.get("http://localhost/addressbook/index.php");
        returnToContactPage();

    }

    public boolean isContactPresent() {
      return manager.isElementPresent(By.name("selected[]"));
    }

    public void removeContact() {
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.id("content")).click();
        manager.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    }

    public void modifyContact(ContactData modifiedContact) {
       // OpenContactPage();
        initcontactModification();
        fillConactForm(modifiedContact);
        submitContactModification();
        returnToContactPage();
    }

    private void returnToContactPage() {
        manager.driver.findElement(By.linkText("home page")).click();//тут могут быть проблемки

    }

    private void submitContactModification() {
        manager.driver.findElement(By.name("update")).click();
    }

    private void fillConactForm(ContactData contact) {
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        manager.driver.findElement(By.name("nickname")).click();
        manager.driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
    }

    private void initcontactModification() {
        manager.driver.findElement(By.xpath("//img[@alt='Edit']")).click();//тут могут быть проблемки
    }
}
