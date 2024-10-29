package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {
    public  WebDriver driver;// прямая ссылка на глобальный браузер, используемый в тестах
    private LoginHelper session;// прямая сылка в класс со всеми методами, связаными с логином
    private GroupHelper groups;
    private ContactHelper contacts;
    private  JdbcHelper jdbc;

    private Properties properties;

    public void init(String Browser, Properties properties) {
        this.properties = properties;
        if (driver == null) {
            if("firefox".equals(Browser)){
                driver = new FirefoxDriver();
            }else if("chrome".equals(Browser)){
                    driver = new ChromeDriver();
            }else {
                throw  new IllegalArgumentException(String.format("Unknown browser %s", Browser));
            }


            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
          driver.get(properties.getProperty("web.baseUrl"));
          driver.manage().window().setSize(new Dimension(1641, 979));
            session().login(properties.getProperty("web.username"), properties.getProperty("web.password"),this);
        }
    }

    public  LoginHelper session(){
        if(session == null){
            session = new LoginHelper(this);
        }
        return session;
     }

    public  GroupHelper groups(){
        if(groups == null){
            groups = new GroupHelper(this);
        }
        return groups;
    }

    public  ContactHelper contacts(){
        if(contacts == null){
            contacts = new ContactHelper(this);
        }
        return contacts;
    }

    public  JdbcHelper jdbc(){
        if(jdbc == null){
            jdbc = new JdbcHelper(this);
        }
        return jdbc;
    }

    public boolean isElementPresent(By locator) {
      try {
        driver.findElement(locator);
        return true;
      } catch (NoSuchElementException exception) {
        return false;
      }
    }


}
