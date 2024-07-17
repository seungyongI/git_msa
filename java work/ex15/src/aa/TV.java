package aa;

public class TV {

    private String brand;
    private int year;
    private int inch;

    public TV() {
    }

    public TV(String b, int y, int in) {
        this.brand = b;
        this.year = y;
        this.inch = in;
    }


    public void show() {
        System.out.println(brand+"에서 만든 "+year+"년형 "+inch+"인치 TV");
    }
}
