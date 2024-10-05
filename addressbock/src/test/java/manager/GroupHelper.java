package manager;

import Model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper {
    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager){
        this.manager = manager;
    }

    public void OpenGroupPage() {
        if (! manager.isElementPresent(By.name("new"))) {
            manager.driver.findElement(By.linkText("groups")).click();
        }
    }

    public boolean isGroupPresent() {
        OpenGroupPage();
      return !manager.isElementPresent(By.linkText("selected[]"));
    }

    public void RemoveGroup() {
        OpenGroupPage();
        manager.driver.findElement(By.linkText("groups")).click();
        selectGroup();
        manager.driver.findElement(By.name("delete")).click();
        returnToGroupsPage();

    }

    public void CreateGroup(GroupData group) {
        OpenGroupPage();
        manager.driver.findElement(By.name("new")).click();
        fillGroupForm(group);
        manager.driver.findElement(By.name("submit")).click();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData modifiedGroup) {
        OpenGroupPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();

    }

    private void returnToGroupsPage() {
        manager.driver.findElement(By.linkText("group page")).click();//тут могут быть проблемки
    }

    private void submitGroupModification() {
        manager.driver.findElement(By.name("update")).click();
    }

    private void fillGroupForm(GroupData group) {
        manager.driver.findElement(By.name("group_name")).click();
        manager.driver.findElement(By.name("group_name")).sendKeys(group.name());
        manager.driver.findElement(By.name("group_header")).click();
        manager.driver.findElement(By.name("group_header")).sendKeys(group.header());
        manager.driver.findElement(By.name("group_footer")).click();
        manager.driver.findElement(By.name("group_footer")).sendKeys(group.footer());
    }

    private void initGroupModification() {
        manager.driver.findElement(By.name("edit")).click();
    }

    private void selectGroup() {
        manager.driver.findElement(By.name("selected[]")).click();

    }
}
