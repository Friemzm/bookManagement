package cn.pdsu.bean;

public class Book {
    private String id;
    private String name;
    private String author;
    private String classify;
    private String descr;
    private float price;

    public Book() {
    }

    public Book(String id, String name, String author, String classify, String descr, float price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.classify = classify;
        this.descr = descr;
        this.price = price;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", classify='" + classify + '\'' +
                ", descr='" + descr + '\'' +
                ", price=" + price +
                '}';
    }
}
