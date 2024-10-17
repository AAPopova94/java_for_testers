package Model;

public record ContactData(String id, String middlename, String lastname, String nickname, String mobile, String firstname) {

    public ContactData(){
        this("", "","","","","");
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.middlename, this.lastname,this.nickname,this.mobile,this.firstname);
    }

    public ContactData withName(String lastname) {
        return new ContactData(this.id, this.middlename, lastname,this.nickname,this.mobile,this.firstname);
    }
    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.id, middlename, this.lastname,this.nickname,this.mobile,this.firstname);
    }
    public ContactData withNickName(String lastname) {
        return new ContactData(this.id, this.middlename, lastname,nickname,this.mobile,this.firstname);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.middlename, this.lastname,this.nickname,mobile,this.firstname);
    }


}