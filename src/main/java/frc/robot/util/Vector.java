package frc.robot.util;

public class Vector {
    Point myPoint;

    public Vector() {
        myPoint.setLocation(0, 0);
    }
    public Vector(Double x, Double y) {
        myPoint.setLocation(x,y);
    }
    public Vector(Point p) {
        myPoint.setLocation(p);
    }
    public Vector(Point p1, Point p2) {
        myPoint.setLocation(p2.getX()-p1.getX(), p2.getY()-p1.getY());
    }

    public Double getLength() {
        Double x = myPoint.getX();
        Double y = myPoint.getY();

        return Math.sqrt((x*x)+(y*y));
    }
    public Vector getUnitVector() {
        Double length = this.getLength();
        if (length == 0) {
            return null;
        }
        Double newX = length/myPoint.getX();
        Double newY = length/myPoint.getY();

        return new Vector(newX,newY);
    }
    public Double getX() {
        return myPoint.getX();
    }
    public Double getY() {
        return myPoint.getY();
    }
}
