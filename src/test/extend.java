package test;

public class extend {
    static class p {
        p() {
            System.out.println("farher" + "的静态变量");
        }

    }


    static class S {
        S() {
            System.out.println("son的静态变量");
        }

    }
    static  class get{
        get(){
            System.out.println("father的实例变量");

        }    }
        static class put{
        put(){
            System.out.println("son的实例变量");
        }
        }
    static class father {
        static p a = new p();
        get b = new get();

        father() {
            System.out.println("father的构造方法");
        }

        static {
            System.out.println("father静态块");
        }

        {
            System.out.println("father实例块");
        }
        public void add() {
            System.out.println("father的普通方法");
        }

    }
    static class son extends father {
        static S b = new S();
            put a = new put();
        son() {
            System.out.println("son的构造方法");
        }

        static {
            System.out.println("son静态块");
        }

        {
            System.out.println("son实例块");
        }

        public void print() {
            System.out.println("son的方法");
        }

    }
    public static void main(String[] args) {
        son s = new son();
        s.print();
    }
}
