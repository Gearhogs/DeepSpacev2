package frc.robot.commands.beater;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.beater.HatchState;

/**
 *
 */
public class toggleHatch extends Command {
    private Boolean isDone = true;

	public toggleHatch() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.beater);
    }

    // Called once when the command executes

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        switch(Robot.beater.getHatchState()){
            case ISOPEN:
            Robot.beater.setHatchState(HatchState.ISCLOSED);
            Robot.beater.hatchRelease();
            break;
            case ISCLOSED:
            Robot.beater.setHatchState(HatchState.ISOPEN);
            Robot.beater.hatchGrab();
            break;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
