package Model;

public record GroupData(String name, String header, String footer) {

    public GroupData(){
        this("","",""); //эта конструкция позволяет по умолчанию передавать
        // пустые параметры и их не надо будет прописывать
    }

    public GroupData withName(String name) {
        return new GroupData(name, this.header, this.footer); //чтобы новую переменную задать, подтягивая старые переменные пустые
    }
    public GroupData withHeader(String header) {
        return new GroupData(this.name, header, this.footer);
    }
    public GroupData withFooter(String footer) {
        return new GroupData(this.name, this.header, footer);
    }
}