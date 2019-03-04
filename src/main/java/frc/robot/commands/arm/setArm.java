package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.arm.ArmState;
import frc.robot.subsystems.beater.BallState;

public class setArm extends Command {
    private Boolean isDone = true;
    ArmState state;

    public setArm(ArmState state) {
        this.state = state;
    }

    protected void initialize() {
        // if(Robot.beater.getBallState() == BallState.BALLGRAB){
        //     if(Robot.arm.getArmState() != ArmState.STARTING){
        //         //Runs nothing
        //     }
        // }
        Robot.arm.setArmState(state);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isDone;
    }
}
