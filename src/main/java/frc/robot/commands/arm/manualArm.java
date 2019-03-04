package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class manualArm extends Command {
    private Boolean isDone = false;

    public manualArm() {
        super();
        requires(Robot.arm);
    }

    protected void initialize() {

    }

    protected void execute() {
        switch (Robot.arm.getControlMode()) {
        case INVERSEKINEMATICS:
            break;
        case FORWARDKINEMATICS:
            break;
        case LEVEL:
            break;
        case DIRECTANGLE:
            break;
        case PERCENTOUTPUT:
            Robot.arm.runliftArm(Robot.oi.getLeftThumbY());
            Robot.arm.runintakeArm(Robot.oi.getRightThumbY());
            break;
        default:

            break;
        }
    }

    protected boolean isFinished() {
        return isDone;
    }
}
