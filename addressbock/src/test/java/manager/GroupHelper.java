package manager;

import Model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class GroupHelper extends HelperBase{

    public GroupHelper(ApplicationManager manager){
        super(manager);
    }

    public void OpenGroupPage() {
        if (! manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public void RemoveGroup(GroupData group) {
        OpenGroupPage();
        selectGroup(group);
        deleteGroups();
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
        selectGroup(null);
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();

    }
///////отсюда - вспомогашки
    private void deleteGroups() {
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

    private void selectGroup(GroupData group) {
        click(By.cssSelector(String.format("input[value='%s']", group.id())));

    }

    public int getCount() {
        OpenGroupPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllGroups() {
        OpenGroupPage();
        selectAllGroups();
        deleteGroups();
    }

    private void selectAllGroups() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public List<GroupData> getList() {
        var groups = new ArrayList<GroupData>();
        var spans = manager.driver.findElements(By.cssSelector("span.group"));//так можно искать элементы по имени (тут - спан групп)
        for (var span : spans){
            var name = span.getText();
            var checkbox = span.findElement(By.name("selected[]"));//ищем все чекбоксы по элементу Селект в спане Групп)
            var id = checkbox.getAttribute("value"); // тут ищем ИД у всех найденных выше атрибутово со значеием value (А там на сайте имена зашиты)
            groups.add(new GroupData().withId(id).withName(name));

        }
        return groups;
    }
}
