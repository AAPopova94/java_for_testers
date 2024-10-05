package manager;

import Model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase{

    public GroupHelper(ApplicationManager manager){
        super(manager);
    }

    public void OpenGroupPage() {
        if (! manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public boolean isGroupPresent() {
        OpenGroupPage();
      return !manager.isElementPresent(By.linkText("selected[]"));
    }

    public void RemoveGroup() {
        OpenGroupPage();
        selectGroup();
        deleteGroup();
        returnToGroupsPage();

    }

    public void CreateGroup(GroupData group) {
        OpenGroupPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
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
///////отсюда - вспомогашки
    private void deleteGroup() {
        click(By.name("delete"));
    }



    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }



    private void returnToGroupsPage() {
        click(By.linkText("group page"));//тут могут быть проблемки
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup() {
        click(By.name("selected[]"));

    }
}
