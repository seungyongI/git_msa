package bank;

public class BankAccountMain {

//    public static void checkMyBalance() {}

    public static void main(String[] args) {
        System.out.println("시작");

        //constructor
        BankAccount park = new BankAccount("박길동","1234","850511",15000);
        BankAccount yoon = new BankAccount("윤길동","4567","950511",16000);

//        park.initAccount("1234","850511",15000);
//        yoon.initAccount("4567","950511",16000);

        park.cmb();
        yoon.cmb();

        park.deposit(3000);
        yoon.deposit(4000);

        park.cmb();
        yoon.cmb();

        park.withdraw(10000);
        yoon.withdraw(12000);

        park.cmb();
        yoon.cmb();

        System.out.println("끝");
    }
}