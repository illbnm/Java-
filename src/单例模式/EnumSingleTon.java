package src.单例模式;

public enum EnumSingleTon {
    INSTANCE ;

    public  static  EnumSingleTon getInstance(){
        return  INSTANCE;
    }
}
