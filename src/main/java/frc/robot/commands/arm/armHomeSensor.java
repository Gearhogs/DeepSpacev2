package frc.robot.commands.arm;

import frc.robot.Robot;
import frc.robot.util.Joint;
import frc.robot.util.Point;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.arm.*;

public class armHomeSensor extends Command {

    private Boolean isDone = false;
    private Joint myJoint;
    private Boolean isForward;

    public armHomeSensor(Joint myJoint, Boolean isForward) {
        this.myJoint = myJoint;
        this.isForward = isForward;
        this.isDone = false;
        requires(Robot.arm);
    }

    protected void initialize() {
        isDone = false;
    }

    protected void execute() {
    
        if (isForward) {
            if (myJoint.getMotor().getSensorCollection().isFwdLimitSwitchClosed()) {
                myJoint.stopMotor();
                isDone = true;
            } else {
                myJoint.runMotor(0.35);
            }
        } else {
            if (myJoint.getMotor().getSensorCollection().isRevLimitSwitchClosed()) {
                myJoint.stopMotor();
                isDone = true;
            } else {
                myJoint.runMotor(-0.2);
            }
        }
    }

    protected void end() {
        myJoint.stopMotor();
    }

    protected void interrupted() {
        myJoint.stopMotor();
    }

    protected boolean isFinished() {
        return isDone;
    }
}
