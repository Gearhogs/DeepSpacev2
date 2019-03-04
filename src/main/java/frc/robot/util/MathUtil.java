package frc.robot.util;
import static java.lang.Math.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class MathUtil {
    public static Double[] InverseKinematics(Point myPoint, double length1, double length2){
        // Vector myVector = new Vector(myPoint);
        Double x = myPoint.getX();
        Double y = myPoint.getY();
        Double[] angles = new Double[2];
        angles[0] = -((length1 * sin(toRadians(angles[1]))) * x + (length1 + length2 * cos(toRadians(angles[1])))) / (length2*sin(toRadians(angles[1])) * y + (length1 + length2 * cos(toRadians(angles[1])) * x));
        angles[1] = acos(((x*x) + (x*x) - (length1 * length1) - (length2 * length2)) / (2 * length1 * length2));
        return angles;
    }
    public static Point ForwardKinematics(Double angle1, Double angle2, double length1, double length2){
        Point myPoint = new Point();
        myPoint.setLocation(length1 * cos(angle1) + length2 * cos(angle1 + angle2), length1 * sin(angle1) + length2 * sin(angle1 + angle2));
        return myPoint;
    }
    public static int DegreesToTicks(Double degrees, Double ratio) {
        SmartDashboard.putNumber("Degres", degrees);
        SmartDashboard.putNumber("Ratio", ratio);		
		int result = (int) (((4096/360)/ratio)*degrees);
		return result;	
	}
	public static double TicksToDegrees(double ticks, double ratio) {
		double degrees = (ticks)/((4096/360)/ratio);
		return degrees;
    }
    public static double AdcToDegrees(int adc){
        double degrees = (adc)/((1023 / 360) - (RobotMap.liftLevelADC/(1023/360)));
        return degrees;
    }
    public static int DegreesToAdc(Double degrees){
        int result = (int) (((1023/360)) * degrees + RobotMap.liftLevelADC);
        return result;
    }
    public static double XAxisToDegrees(){
        double degrees = (Robot.oi.getX(Robot.oi.getRightJoystick())* 360); 
        return degrees;
    }
}
