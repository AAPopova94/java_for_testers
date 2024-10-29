package ru.stqa.addressbook.manager;

import ru.stqa.addressbook.Model.ContactData;
import ru.stqa.addressbook.Model.GroupData;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper extends HelperBase {
    public JdbcHelper (ApplicationManager manager){
        super(manager);
    }

    public List<GroupData> getGroupList() {
        var groups = new ArrayList<GroupData>();
        //соединение с бд , сохраняем результат в переменную conn
        try ( var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
              var statement = conn.createStatement();
              var result = statement.executeQuery("SELECT group_id,group_name, group_header, group_footer FROM group_list");
        ){
;/////while -цикл, который анализирует каждую строчку, пока не закончится
       while (result.next()){
           groups.add(new GroupData()
                   .withId(result.getString("group_id"))
                   .withFooter(result.getString("group_footer"))
                   .withName(result.getString("group_name"))
                   .withHeader(result.getString("group_header"))
           );
       }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    public List<ContactData> getContactList() {
        var contacts = new ArrayList<ContactData>();
        //соединение с бд , сохраняем результат в переменную conn
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = conn.createStatement()
        ) {
            var result = statement.executeQuery("SELECT • FROM users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
}
