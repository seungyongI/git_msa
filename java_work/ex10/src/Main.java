import aa.CalSecond;

public class Main {

    public static void main(String[] args) {
        CalSecond calSecond = new CalSecond();

        int retValue = calSecond.inputNumber();
        System.out.println(retValue);

        String resultValue = calSecond.calculate(retValue);
        System.out.println(resultValue);

//        System.out.println(calSecond.inputNumber());

//        CalSecond calSecond2 = calSecond;
//
//        System.out.println(calSecond);
//        System.out.println(calSecond2);

    }
}