package bai1;

import java.util.Scanner;

public class HinhChuNhat {
    private double length;
    private double width;

    public HinhChuNhat(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public String toString() {
        return "Chiều dài: " + length + "\nChiều rộng: " + width
                + "\nDiện tích: " + getArea() + "\nChu vi: " + getPerimeter();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chiều dài: ");
        double length = sc.nextDouble();
        System.out.print("Nhập chiều rộng: ");
        double width = sc.nextDouble();

        HinhChuNhat hcn = new HinhChuNhat(length, width);
        System.out.println(hcn.toString());
    }
}
