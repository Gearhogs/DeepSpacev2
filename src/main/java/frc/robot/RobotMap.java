/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.util.MathUtil;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static double defaultRampRate = 0;
	public static double peakOutput = 0.7;
	public static Double liftArmRatio = 0.0694;
	public static Double intakeArmRatio = 0.2272;
	public static double swerveRatio = .2666;
	public static int liftLevelADC = 600;
	public static int liftArmLowerLimit = MathUtil.DegreesToAdc(-70.0);
	public static int liftArmUpperLimit = MathUtil.DegreesToAdc(60.0);
	public static int intakeArmLowerLimit = MathUtil.DegreesToAdc(-15.0);
	public static int intakeArmUpperLimit = MathUtil.DegreesToAdc(45.0);
	//Drive
	public static int frontLeftDriveMotor = 1;
	public static int frontLeftRotateMotor = 11;
	public static int frontRightDriveMotor = 2;
	public static int frontRightRotateMotor = 12;
	public static int backLeftDriveMotor = 3;
	public static int backLeftRotateMotor = 13;
	public static int backRightDriveMotor = 4;
	public static int backRightRotateMotor = 14;
	
	//Arm
	public static int leftArm1 = 15;
	public static int rightArm1 = 16;
	public static int arm2 = 17;
	
	//Gripper
	public static int intakeLeftMotor = 18;
	public static int intakeRightMotor = 19;
	
	//Pneumatics
	public static int ballCylinderFwd = 0;
	public static int ballCylinderRev = 1;
	public static int hatchCylinderFwd = 2;
	public static int hatchCylinderRev = 3;
	
	//Sensors
	public static int gyro = 41;
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
