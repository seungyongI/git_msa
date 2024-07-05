public class Main {
    public static void main(String[] args) {
//        alt + 1 프로젝트 경로
//        alt insert 파일 생성
//        ctrl e 최근 파일 찾기
//        ctrl alt L 한 줄 삭제
//        ctrl F4 창 닫기

//      1 + (1+2) + (1+2+3) ...(1+2+3+4+...+10)
//        의 결과를 출력하여라
//        i = 0일 때 j가 0에서 0+1까지 반복해라
// shift f6 파일 이름 변경

        int sum = 0;

        for (int i = 0; i < 10; i++) {

            for (int j = 1; j < i + 1; j++) {
                System.out.println("j=" + j);
                sum = sum + j;
            }
            System.out.println("sum=" + sum);
        }
        System.out.println("sum=" + sum);

    }
}