package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager){
        super(manager);
    }
    public void login(String user, String password, ApplicationManager applicationManager) {
        type(By.name("user"), user);
        click(By.name("pass"));
        type(By.name("pass"), password);
        click(By.xpath("//input[@value=\'Login\']"));
    }
}
