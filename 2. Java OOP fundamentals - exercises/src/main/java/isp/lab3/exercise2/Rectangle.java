package isp.lab3.exercise2;

public class Rectangle {
    private int length = 2;
    private int width = 1;
    private String color = "red";

    public Rectangle(){}

    public Rectangle(int l, int w){
        length = l;
        width = w;
        System.out.println("Rectangle created with " + length + " " + width);
    }

    public Rectangle(int l, int w, String c){
        length = l;
        width = w;
        color = c;
        System.out.println("Rectangle created with " + length + " " + width + " " + color);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getPerimeter(){
        return ((2 * length) + (2 * width));
    }

    public int getArea(){
        return (length * width);
    }
}
