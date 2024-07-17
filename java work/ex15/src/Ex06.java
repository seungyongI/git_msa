public class Ex06 {

    public static void main(String[] args) {
        //StringBuilder를 쓰면 속도가 빠르다.
        //짧은 String은 속도 차이가 없어서
        //String 사용하면 됨.
        StringBuilder sb = new StringBuilder();
        sb.append("asdf");
        sb.append("asdf");

        System.out.println(sb);

        sb.delete(0,2);
        System.out.println(sb);

        sb.replace(0,5,"kkk");
        System.out.println(sb);

        sb.append("asdf");
        sb.reverse();
        System.out.println(sb);

    }
}
