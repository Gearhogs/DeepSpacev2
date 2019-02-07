/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.arm.changeArmPosition;
import frc.robot.commands.arm.runIntake;
import frc.robot.commands.swerve.SetSwerveModuleRotation;
import frc.robot.subsystems.arm.ArmState;
import frc.robot.subsystems.arm.IntakeState;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.arm.*;
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
	Button intakeBallRelease = new JoystickButton(controller, 1);
	Button intakeBallGrab = new JoystickButton(controller, 4);
	Button liftUp= new JoystickButton(controller, 6); // Right-Top Trigger on Controller
	Button liftDown= new JoystickButton(controller, 8); // Right Trigger on Controller
	Button liftUpperJoint = new JoystickButton(controller, 5);
	Button downUpperJoint = new JoystickButton(controller, 7);
	Button liftLowerJoint = new JoystickButton(controller, 5);
	Button downLowerJoint = new JoystickButton(controller, 7);
	Button jointToggle = new JoystickButton(controller, 9);
	// Button ballPickup = new JoystickButton(controller, 0);
	// Button ballStation = new JoystickButton(controller, 0);
	// Button ballGround = new JoystickButton(controller, 0);
	// Button hatchStation = new JoystickButton(controller, 0);
	// Button rocketBall1 = new JoystickButton(controller, 0);
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
		//switchToCrab.whenPressed(new CrabDrive());
		setRotationTo90.whenPressed(new SetSwerveModuleRotation(4096*5));
		setRotationTo0.whenPressed(new SetSwerveModuleRotation(0));
		intakeBallGrab.whenPressed(new runIntake(-1));
		intakeBallRelease.whenPressed(new runIntake(1));

		// jointToggle.whenPressed(); Create Toggle for Joint Controls, when this button is pressed, use left triggers for up and down
		liftLowerJoint.whenPressed(new runLowerArm(1));
		liftUpperJoint.whenPressed(new runUpperArm(1));
		//downLowerJoint.whenPressed(new runLowerArm(-1));
		//downUpperJoint.whenPressed(new runUpperArm(-1));

		// ballGround.whenPressed(new changeArmPosition(ArmState.BALLGROUND));
		// ballPickup.whenPressed(new changeArmPosition(ArmState.BALLPICKUP));
		// ballStation.whenPressed(new changeArmPosition(ArmState.BALLSTATION));
		// rocketBall1.whenPressed(new changeArmPosition(ArmState.ROCKETBALL1));
		// rocketBall2.whenPressed(new changeArmPosition(ArmState.ROCKETBALL2));
		// rocketBall3.whenPressed(new changeArmPosition(ArmState.ROCKETBALL3));
		// cargoBall1.whenPressed(new changeArmPosition(ArmState.CARGOBALL1));
		// cargoBall2.whenPressed(new changeArmPosition(ArmState.CARGOBALL2));
		// cargoBall3.whenPressed(new changeArmPosition(ArmState.CARGOBALL3));
		// cargoHatch.whenPressed(new changeArmPosition(ArmState.CARGOHATCH));
		// rocketHatch1.whenPressed(new changeArmPosition(ArmState.ROCKETHATCH1));
		// rocketHatch2.whenPressed(new changeArmPosition(ArmState.ROCKETHATCH2));
		// rocketHatch3.whenPressed(new changeArmPosition(ArmState.ROCKETHATCH3));
	}
	
	public Joystick getLeftJoystick() {
		return leftJoystick;
	}
	public Joystick getRightJoystick() {
		return rightJoystick;
	}
	public double getAngle(Joystick joystick) {
		return joystick.getDirectionDegrees();
	}
	public double getMagnitude(Joystick joystick) {
		return Math.sqrt((joystick.getX() * joystick.getX()) + (joystick.getY() * joystick.getY()));
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
