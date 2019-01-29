package frc.robot.util;
import static java.lang.Math.*;

public class Vector {
    Point myPoint;

    public Vector() {
        myPoint.setLocation(0, 0);
        myPoint.setPolarLocation(0, 0);
    }
    public Vector(Double x, Double y) {
        myPoint.setLocation(x,y);
        myPoint.setPolarLocation(x,y);
    }
    public Vector(Point p, boolean isCartesian) {
        if (isCartesian) {
            myPoint.setLocation(p);
        }
        else {
            myPoint.setPolarLocation(p);
        }
    }
    public Vector(Point p1, Point p2) {
        myPoint.setLocation(p2.getX()-p1.getX(), p2.getY()-p1.getY());
        myPoint.setPolarLocation(p2.getR()-p1.getR(), p2.getT()-p1.getT());
    }

    public Double getLength() {
        Double x = myPoint.getX();
        Double y = myPoint.getY();

        return sqrt((x*x)+(y*y));
    }
    public Vector getUnitVector() {
        Double length = this.getLength();
        if (length == 0) {
            return null;
        }
        Double newX = myPoint.getX()/length;
        Double newY = myPoint.getY()/length;

        return new Vector(newX, newY);
    }
    public Double getX() {
        return myPoint.getX();
    }
    public Double getY() {
        return myPoint.getY();
    }
}
