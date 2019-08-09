package src.单例模式;

public class HungrySingleton {
    //加载的时候就产生了实例对象
    private static HungrySingleton Instanse = new HungrySingleton();

    private HungrySingleton() {
    }
    // 返回实例对象
    public static HungrySingleton getInstanse() {
        return Instanse;
    }

    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstanse();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(HungrySingleton.getInstanse());
            }).start();
        }
    }
}
