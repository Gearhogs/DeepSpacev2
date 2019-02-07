package frc.robot.commands.arm;
import frc.robot.Robot;
import frc.robot.subsystems.arm.ArmState;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.arm.*;
/**
 *
 */
public class runLowerArm extends Command {
    
    private Boolean isDone = false;
    private double power;
    
	public runLowerArm(double power) {
        super("RunLowerArm");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.intake);
        this.power = power;
    }
    protected void initialize() {

    }
    protected void execute() {
        Robot.arm.runLowerArm(power);
    }
    protected boolean isFinished() {
        return isDone;
    }
}
