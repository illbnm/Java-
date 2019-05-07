package src.com.libraryManage;

public class Manage extends Prople {
    private int ID;
    private int Passwd;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPasswd() {
        return Passwd;
    }

    public void setPasswd(int passwd) {
        Passwd = passwd;
    }

    public Manage(String name, int age) {
        super(name, age);
    }
}
