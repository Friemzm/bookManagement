package cn.pdsu.bean;


public class BookUser{
    private String id;
    private String name;
    private String author;
    private String classify;
    private String descr;
    private float price;
    private int number;
    private String username;

    public BookUser() {
    }

    public BookUser(String id, String name, String author, String classify, String descr, float price, int number, String username) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.classify = classify;
        this.descr = descr;
        this.price = price;
        this.number = number;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "BookUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", classify='" + classify + '\'' +
                ", descr='" + descr + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", username='" + username + '\'' +
                '}';
    }
}
