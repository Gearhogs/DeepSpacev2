package frc.robot.commands.swerve;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetSwerveModuleRotation extends Command {
	
    private double FLRotation;
    private double FRRotation;
    private double BLRotation;
    private double BRRotation;

    public SetSwerveModuleRotation(double FLRotation, double FRRotation, double BLRotation, double BRRotation) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.swerveDrive);
        this.FLRotation = FLRotation;
        this.FRRotation = FRRotation;
        this.BLRotation = BLRotation;
        this.BRRotation = BRRotation;
    }

    // Called once when the command executes
    protected void initialize() {
        Robot.swerveDrive.SetAllModules(FLRotation, FRRotation, BLRotation, BRRotation);
    
    }
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }
    protected void interrupted() {
    }
}
