package frc.robot.util;
import java.awt.geom.Point2D;

public class Point extends Point2D {
    double X;
    double Y;

    public Point(Double x, Double y) {
        super();
    }
    
    public double getX() {
        return X;
    }
        
    public double getY() {
        return Y;
    }
        
    public void setLocation(double x, double y) {
        X = x;
        Y = y;
    }
}
