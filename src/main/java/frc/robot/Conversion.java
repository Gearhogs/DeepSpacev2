package frc.robot;

public class Conversion {
	double test; 
	//TODO add conversion within function
	public static double DegreesToTicks(double degrees, double ratio) {
				
		double result = ((4096/360*-1.0)/ratio)*degrees;
		return result;
		
	}
	
	public static double TicksToDegrees(double ticks, double ratio) {
		double degrees = (ticks)/((4096/360*-1.0)/ratio);
		return degrees;
	}
}
