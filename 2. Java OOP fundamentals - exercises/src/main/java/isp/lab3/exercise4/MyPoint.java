package isp.lab3.exercise4;

import static java.lang.Math.sqrt;

public class MyPoint {
    int x, y ,z;

    public MyPoint(){
        x=y=z=0;
    }

    public MyPoint(int valx, int valy, int valz){
        x=valx;
        y=valy;
        z=valz;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setXYZ(int valx, int valy, int valz){
        x=valx;
        y=valy;
        z=valz;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public int distance(int valx, int valy, int valz){
           return ((int) sqrt( ( (valx - x) * (valx - x)) + ((valy - y) * (valy - y)) + ((valz - z) * (valz - z)) ) );
    }

    public int distance(MyPoint point) {
        return ( (int) sqrt( ( (point.x - x) * (point.x - x)) +
                       ( (point.y - y) * (point.y - y)) +
                       ( (point.z - z) * (point.z - z))
                     )
               );
    }
}
