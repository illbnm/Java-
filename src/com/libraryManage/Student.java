package src.com.libraryManage;

public class Student extends Prople {
    private int Grade;
    private int ID;
    private int Passwd;

    public Student(String name, int age, int Grade) {
        super(name, age);
        this.Grade = Grade;
    }

    public int getGrade() {
        return Grade;
    }

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

    public void setGrade(int grade) {
        Grade = grade;
    }
}
