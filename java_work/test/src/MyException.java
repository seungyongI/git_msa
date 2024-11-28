public class MyException extends RuntimeException{
    @Override
    public String getMessage() {
        return "숫자는 입력 불가입니다.";
    }

    public MyException() {
        super("숫자는 입력 불가 입니다.");
    }
}
