package Model;

public record ContactData(String middlename, String lastname, String nickname, String mobile,String firstname) {

    public ContactData(){
        this("","","","","");
    }

    public ContactData withName(String lastname) {
        return new ContactData(this.middlename, lastname,this.nickname,this.mobile,this.firstname);
    }
    public ContactData withMiddleName(String middlename) {
        return new ContactData(middlename, this.lastname,this.nickname,this.mobile,this.firstname);
    }
    public ContactData withNickName(String lastname) {
        return new ContactData(this.middlename, lastname,nickname,this.mobile,this.firstname);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.middlename, this.lastname,this.nickname,mobile,this.firstname);
    }


}