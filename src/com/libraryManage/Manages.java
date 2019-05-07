package src.com.libraryManage;

public class Manages {
    Manage []manages ;
    int size;
    public Manages(){
        manages = new Manage[10];
    }
    public int isExist(int ID) {   //判断重复
        for (int i = 0; i < size; i++) {
            if (manages[size].getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public boolean Register(int ID, int passwd) {

        if (isExist(ID) >= 0) {
            return false;
        } else {
            manages[size].setID(ID);
            manages[size].setPasswd(passwd);
            size++;
            return true;
        }
    }

    public boolean LogIn(int ID, int value) {
        int ID_i = isExist(ID);
        if (ID_i >= 0 && manages[ID_i].getPasswd() == value) {
            return true;
        }
        return false;
    }
}
