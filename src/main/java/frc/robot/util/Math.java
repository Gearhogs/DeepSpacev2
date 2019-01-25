package frc.robot.util;
import java.lang.*;

public class Math {
    
    public Double[] InverseKinematics(Point myPoint, double length1, double length2){
        Vector myVector = new Vector(myPoint);
        Double x = myPoint.getX();
        Double y = myPoint.getY();
        Double[] angles = new Double[1];
        angles[0] = -((length1 * Math.sin(angles[1])) * x + (length1 + length2 * Math.cos(angles[1]))) / (length2*sin(angles[1]) * y + (length1 + length2 * cos(angles[1]) * x));
        angles[1] = Math.acos(((x*x) + (x*x) - (length1 * length1) - (length2 * length2)) / (2 * length1 * length2));
        return angles;
    }
}
