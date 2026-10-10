package isp.lab3.exercise4;

public class MainOfExercise4 {
    public static void main(String[] args) {

        MyPoint point0 = new MyPoint();
        MyPoint point1 = new MyPoint(1,2,3);

        System.out.println("Distance " + point0.toString() + " -> " + point1.toString() + " = " + point0.distance(point1));
    }
}
