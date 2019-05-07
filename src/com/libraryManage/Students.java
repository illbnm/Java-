package src.com.libraryManage;

public class Students {
    Student[] student;
    int size = 0;

    public Students() {
        student = new Student[10];
    }

    public int isExist(int ID) {   //判断重复
        for (int i = 0; i < size; i++) {
            if (student[size].getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public boolean Register(int ID, int passwd) {

        if (isExist(ID) >= 0) {
            return false;
        } else {
            student[size].setID(ID);
            student[size].setPasswd(passwd);
            size++;
            return true;
        }
    }

    public boolean LogIn(int ID, int value) {
        int ID_i = isExist(ID);
        if (ID_i >= 0 && student[ID_i].getPasswd() == value) {
            return true;
        }
        return false;
    }

}
