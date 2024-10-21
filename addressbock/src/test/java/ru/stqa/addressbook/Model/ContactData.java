package ru.stqa.addressbook.Model;

public record ContactData(String id, String middlename, String lastname, String nickname, String mobile, String firstname, String photo) {

    public ContactData(){
        this("", "","","","","","");
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.middlename, this.lastname,this.nickname,this.mobile,this.firstname, this.photo);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.middlename, lastname,this.nickname,this.mobile,this.firstname, this.photo);
    }
    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.id, middlename, this.lastname,this.nickname,this.mobile,this.firstname, this.photo);
    }
    public ContactData withNickName(String nickname) {
        return new ContactData(this.id, this.middlename, this.lastname, nickname,this.mobile,this.firstname, this.photo);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.middlename, this.lastname,this.nickname,mobile,this.firstname, this.photo);
    }
    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, this.middlename, this.lastname,this.nickname,this.mobile,firstname, this.photo);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.middlename, this.lastname,this.nickname,this.mobile, this.firstname,photo);
    }


}