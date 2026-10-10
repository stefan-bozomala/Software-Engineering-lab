package isp.lab3.exercise2;

public class MainOfExercise2 {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        System.out.println("Rectangle " + rectangle1 + " " + rectangle1.getLength() + " " + rectangle1.getWidth() + " " + rectangle1.getColor()) ;
        Rectangle rectangle2 = new Rectangle(3,2);
        Rectangle rectangle3 = new Rectangle(4, 3, "yellow");
        System.out.println("length " + rectangle1.getLength());
        System.out.println("width " + rectangle1.getWidth());
        System.out.println("color " + rectangle1.getColor());
        System.out.println("perimeter " + rectangle1.getPerimeter());
        System.out.println("area " + rectangle1.getArea());
    }

}