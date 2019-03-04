package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.arm.Mode;

public class resetZero extends Command {
    private Boolean isDone = true;

    public resetZero() {
        super();
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.arm.resetZero();
    }

    protected boolean isFinished() {
        return isDone;
    }
}