package src.classClone;

class Door implements Cloneable {
    String name;

    Door(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Door D = (Door) super.clone();
        return D;
    }
}


public class Car implements Cloneable {
    String name;
    int id;
    Door door;

    public Car(String name, int id) {
        this.name = name;
        this.id = id;
        door = new Door("车门");

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Car C = (Car) super.clone();    //向下造型
        C.door = (Door) this.door.clone(); //深度拷贝

        return C;
    }
}
