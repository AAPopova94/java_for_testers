package ru.stqa.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import ru.stqa.addressbook.Model.ContactData;
import ru.stqa.addressbook.Model.GroupData;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.ArrayList;

public class Generator {

    //будем использовать параметр для подтянутой нами зависимости новой
    //параметры мы указали в конфигурации при запуске теста
    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--output", "-o"})
    String output;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--count", "-c"})
    int count;

    //Функция main внутри класса, потому что мы будем его вызывать постоянно
    public  static  void main(String[] args) {
        var generator = new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run(); // создать новый генератор и запустить
    }

    private void run() {
        var data = generate();
        save(data);
    }

    private Object generate(){
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)){
            return generateContacts();
        } else {
            throw new IllegalArgumentException("неизвестный тип данных" + type);
        }
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>();
        int i;
        for (i = 0; i < count; i++){
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i))
                    .withFooter(CommonFunctions.randomString(i))
                    .withHeader(CommonFunctions.randomString(i))); //мы вынесли этот код с помощью рефактор - пулл мемберс ап
        }
        return  result;
    }

    private Object generateContacts() {
        var result = new ArrayList<ContactData>();
        int i;
        for (i = 0; i < 5; i++){
            result.add(new ContactData()
                    .withLastName(CommonFunctions.randomString(i))
                    .withMiddleName(CommonFunctions.randomString(i))
                    .withNickName(CommonFunctions.randomString(i))
                    .withMobile(CommonFunctions.randomString(i))
                    .withPhoto(""));
        }
        return result;
    }


    private  void save(Object data){

    }
}
