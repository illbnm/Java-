package src.单例模式;

public class DCL {
    int a = 10;
    int b = 20;
    private static volatile DCL Instance = null;

    private DCL() {
        a = 200;
        b = 300;
    }

    public static DCL getInstance() {
        if (null == Instance) {
            synchronized (DCL.class) {
                if (null == Instance) {
                    Instance = new DCL();

                }
            }
        }
        return Instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(DCL.getInstance());
                ;
            }).start();
            ;
        }
    }

}
