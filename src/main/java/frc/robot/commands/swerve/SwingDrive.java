package frc.robot.commands.swerve;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.swerve.SwervePosition;
import frc.robot.subsystems.swerve.SwingCalculations;

/**
 *
 */
public class SwingDrive extends Command {

    public SwingDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.swerveDrive);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 
    	if (Robot.oi.getMagnitude(Robot.oi.getLeftJoystick()) < .1) {
    		Robot.swerveDrive.SetAllModules(0, 0, 0, 0);
    		Robot.swerveDrive.stopDrive();
        }
    	else {
    		Robot.swerveDrive.SwingDrive(Robot.oi.getAngle(Robot.oi.getRightJoystick()), Robot.oi.getMagnitude(Robot.oi.getLeftJoystick()));
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
