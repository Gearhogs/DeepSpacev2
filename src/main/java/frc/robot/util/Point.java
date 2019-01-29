package frc.robot.util;
import java.awt.geom.Point2D;
import static java.lang.Math.*;

public class Point extends Point2D {
    double X;
    double Y;
    double R; //Radius
    double T; //Theta
    
    public Point() {
        super();
    }
    
    public double getR(){
        return R;
    }

    public double getT(){
        return T;
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
        convertToPolar();
    }

    public void setPolarLocation(double r, double t) {
        R = r;
        T = t;
        convertToCartesian();
    }
    
    private void convertToPolar() {
        R = sqrt((X * X) + (Y * Y));
        T = atan(Y / X);
    }
    private void convertToCartesian() {
        X = R * cos(toRadians(T));
        Y = R * sin(toRadians(T));
    }

	public void setPolarLocation(Point p) {
	}
}
