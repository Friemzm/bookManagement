package cn.pdsu.bean;

public class Controller {
    private String contname;
    private String password;

    public Controller() {
    }

    public Controller(String contname, String password) {
        this.contname = contname;
        this.password = password;
    }

    public String getContname() {
        return contname;
    }

    public void setContname(String contname) {
        this.contname = contname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "contname='" + contname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
