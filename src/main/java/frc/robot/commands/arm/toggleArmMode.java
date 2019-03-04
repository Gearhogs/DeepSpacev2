package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.arm.Mode;

public class toggleArmMode extends Command {
    private Boolean isDone = true;
    private autoArm autoArmCommand;
    private manualArm manualArmCommand;

    public toggleArmMode() {
        super();
        requires(Robot.arm);
        autoArmCommand = new autoArm();
        manualArmCommand = new manualArm();
    }

    protected void initialize() {

    }

    protected void execute() {
        switch(Robot.arm.getMode()){
            case MANUAL:
            Robot.arm.setMode(Mode.AUTO);
            autoArmCommand.start();
            break;
            case AUTO: 
            Robot.arm.setMode(Mode.MANUAL);
            manualArmCommand.start();
            break;
            default:
            break;
        }
    }

    protected boolean isFinished() {
        return isDone;
    }
}