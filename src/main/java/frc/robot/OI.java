/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// import frc.robot.subsystems.arm.IntakeState;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.arm.*;
import frc.robot.commands.beater.*;
import frc.robot.commands.swerve.CrabDrive;
import frc.robot.commands.swerve.SetSwerveModuleRotation;
import frc.robot.subsystems.arm.ArmState;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick leftJoystick = new Joystick(0);
	Joystick rightJoystick = new Joystick(1);
	Joystick controller = new Joystick(2);
	
	Button switchToCrab = new JoystickButton(leftJoystick, 1);
	Button setRotationTo90 = new JoystickButton(rightJoystick,2);
	Button setRotationTo0 = new JoystickButton(rightJoystick, 3);
	// Button resetArmToZero = new JoystickButton(leftJoystick, 12);
	// Button setHomeLift = new JoystickButton(rightJoystick, 5);
	// Button setHomeIntake = new JoystickButton(rightJoystick, 6);
	Button stage1 = new JoystickButton(controller, 1);
	Button ballPickup = new JoystickButton(controller, 2);
	Button stage2 = new JoystickButton(controller, 3);
	Button starting = new JoystickButton(controller, 4);
	Button toggleBall = new JoystickButton(controller, 5);
	Button intakeBallGrab = new JoystickButton(controller, 6);
	Button ballAdjust = new JoystickButton(controller, 7);
	Button intakeBallRelease = new JoystickButton(controller, 8);
	Button toggleArmMode = new JoystickButton(controller, 9);
	Button toggleHatch = new JoystickButton(controller, 10);
	Button ballStation = new JoystickButton(controller, 11);
	Button hatchStation = new JoystickButton(controller, 12);
	// Button hatchStation = new JoystickButton(controller, 0);
	// Button rocketBall2 = new JoystickButton(controller, 0);
	// Button rocketBall3 = new JoystickButton(controller, 0);
	// Button cargoBall1 = new JoystickButton(controller, 0);
	// Button cargoBall2 = new JoystickButton(controller, 0);
	// Button cargoBall3 = new JoystickButton(controller, 0);
	// Button cargoHatch = new JoystickButton(controller, 0);
	// Button rocketHatch1 = new JoystickButton(controller, 0);
	// Button rocketHatch2 = new JoystickButton(controller, 0);
	// Button rocketHatch3 = new JoystickButton(controller, 0);
	
	public OI() {
		switchToCrab.whenPressed(new CrabDrive());
		setRotationTo90.whenPressed(new SetSwerveModuleRotation(90, -90, 90, -90));
		setRotationTo0.whenPressed(new SetSwerveModuleRotation(0,0,0,0));
		// resetArmToZero.whenPressed(new resetZero());
		//setHomeLift.whileHeld(new armHomeSensor(Robot.arm.getliftArm(), false));
		//setHomeIntake.whileHeld(new armHomeSensor(Robot.arm.getintakeArm(), true));

		// intakeBallGrab.whileHeld(new runBeater(-.2));
		// intakeBallRelease.whileHeld(new runBeater(.2));
		// toggleArmMode.whenPressed(new toggleArmMode());

		// toggleHatch.whenPressed(new toggleHatch());
		// toggleBall.whenPressed(new toggleBall());

		// ballPickup.whenPressed(new setArm(ArmState.BALLPICKUP));
		// starting.whenPressed(new setArm(ArmState.STARTING));
		// stage1.whenPressed(new setArm(ArmState.STAGE1));
		// stage2.whenPressed(new setArm(ArmState.STAGE2));
		// hatchStation.whenPressed(new setArm(ArmState.HATCHSTATION));
		// ballStation.whenPressed(new setArm(ArmState.BALLSTATION));
		
		// ballGround.whenPressed(new setArm(ArmState.BALLGROUND));
		// rocketBall1.whenPressed(new setArm(ArmState.ROCKETBALL1));
		// jointToggle.whenPressed(); Create Toggle for Joint Controls, when this button is pressed, use left triggers for up and down
		//downIntakeJoint.whenPressed(new runintakeArm(-1));
		//downLiftJoint.whenPressed(new runliftArm(-1));
	}
	

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}
	public Joystick getRightJoystick() {
		return rightJoystick;
	}
	public double getAngle(Joystick joystick) {
		return -joystick.getDirectionDegrees();
	}
	public double getMagnitude(Joystick joystick) {
		return Math.sqrt((joystick.getX() * joystick.getX()) + (joystick.getY() * joystick.getY()));
	}
	public double getX(Joystick joystick) {
		return joystick.getX();
	}
	public double getLeftThumbY() {
		return controller.getRawAxis(1);
	}
	public double getRightThumbY() {
		return controller.getRawAxis(3);
	}
	public void Debug() {
    	SmartDashboard.putNumber("Magnitude = ", getMagnitude(leftJoystick));
    	SmartDashboard.putNumber("Angle = ", getAngle(leftJoystick));
    	SmartDashboard.putNumber("x: ", leftJoystick.getX());
    	SmartDashboard.putNumber("y: ", leftJoystick.getY());
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
