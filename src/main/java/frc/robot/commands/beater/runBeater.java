package frc.robot.commands.beater;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class runBeater extends Command {

	
	private double power;
    
	public runBeater(double power) {
        super("Run Beater");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.beater);
        this.power = power;
    }

    // Called once when the command executes

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.beater.runMotor(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}