package Bank;

public class BankCard {
    private int id;
    private int passwd;
    private int money;
    public BankCard(int id,int passwd){
        this.passwd =passwd;
        this.id = id;
        this.money = 0;
    }
    public void saveMoney(int money){
        this.money+=money;
    }
    public void withdraw(int money){
        if(this.money >= money) {
            this.money -= money;
        }else{
            System.out.println("取款失败");
        }
    }

    public int getId() {
        return id;
    }
    public int getMoney(){
        return money;
    }

    public int getPasswd() {
        return passwd;
    }
}
