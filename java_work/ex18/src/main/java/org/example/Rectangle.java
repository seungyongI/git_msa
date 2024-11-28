package org.example;

public class Rectangle {

    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int square() {
        return width * height;
    }

    public void show() {
        System.out.println("(" + x + "," + y + ")에서 크기가 " + width * height + "인 사각형");
    }

    public boolean contains(Rectangle r) {
        if (x + width > r.x + r.width && y + height > r.y + r.height) {
            return true;
        } else return false;
    }
}
