package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.subsystems.arm.StateConstants;
import frc.robot.subsystems.arm.*;
import frc.robot.commands.arm.setArm;

public class autoArm extends Command {
    private Boolean isDone = false;

    public autoArm() {
        super();
        requires(Robot.arm);
    }

    protected void initialize() {

    }

    protected void execute() {

        switch(Robot.arm.getArmState()) {
            case STARTING:
            Robot.arm.SetliftArmAngle(StateConstants.STARTING_LIFT);
            // new WaitCommand(1);
            Robot.arm.SetintakeArmAngle(StateConstants.STARTING_INTAKE);
            Robot.arm.SetJointAngles(StateConstants.STARTING_INTAKE, StateConstants.STARTING_LIFT);
            break;
            case DEFAULT:
            Robot.arm.SetJointAngles(StateConstants.DEFAULT_INTAKE, StateConstants.DEFAULT_LIFT);
            break;
            case BALLPICKUP:
            Robot.arm.SetJointAngles(StateConstants.BALLPICKUP_INTAKE, StateConstants.BALLPICKUP_LIFT);
            break;
            case BALLSTATION:
            Robot.arm.SetJointAngles(StateConstants.BALLSTATION_INTAKE, StateConstants.BALLSTATION_LIFT);
            break;
            case HATCHSTATION:
            Robot.arm.SetJointAngles(StateConstants.HATCHSTATION_INTAKE, StateConstants.HATCHSTATION_LIFT);
            break;
            case STAGE1:
            Robot.arm.SetJointAngles(StateConstants.STAGE1_INTAKE, StateConstants.STAGE1_LIFT);
            break;
            case STAGE2:
            Robot.arm.SetJointAngles(StateConstants.STAGE2_INTAKE, StateConstants.STAGE2_LIFT);
            break;
            case STAGE3:
            Robot.arm.SetJointAngles(StateConstants.STAGE3_INTAKE, StateConstants.STAGE3_LIFT);
            break;
            // case DEFAULT:
            // Robot.arm.SetJointAngles(StateConstants.DEFAULT_INTAKE, StateConstants.DEFAULT_LIFT);
            // break;
            // case STARTING:
            // Robot.arm.SetJointAngles(StateConstants.STARTING_INTAKE, StateConstants.STARTING_LIFT);
            // break;
            // case BALLPICKUP:
            // Robot.arm.SetJointAngles(StateConstants.BALLPICKUP_INTAKE, StateConstants.BALLPICKUP_LIFT);
            // break;
            // case BALLSTATION:
            // Robot.arm.SetJointAngles(StateConstants.BALLSTATION_INTAKE, StateConstants.BALLSTATION_LIFT);
            // break;
            // case BALLGROUND:
            // Robot.arm.SetJointAngles(StateConstants.BALLGROUND_INTAKE, StateConstants.BALLGROUND_LIFT);
            // break;
            // case HATCHSTATION:
            // Robot.arm.SetJointAngles(StateConstants.HATCHSTATION_INTAKE, StateConstants.HATCHSTATION_LIFT);
            // break;
            // case ROCKETBALL1:
            // Robot.arm.SetJointAngles(StateConstants.ROCKETBALL1_INTAKE, StateConstants.ROCKETBALL1_LIFT);
            // break;
            // case ROCKETBALL2:
            // Robot.arm.SetJointAngles(StateConstants.ROCKETBALL2_INTAKE, StateConstants.ROCKETBALL2_LIFT);
            // break;
            // case ROCKETBALL3:
            // Robot.arm.SetJointAngles(StateConstants.ROCKETBALL3_INTAKE, StateConstants.ROCKETBALL3_LIFT);
            // break;
            // case CARGOBALL1:
            // Robot.arm.SetJointAngles(StateConstants.CARGOBALL1_INTAKE, StateConstants.CARGOBALL1_LIFT);
            // break;
            // case CARGOBALL2:
            // Robot.arm.SetJointAngles(StateConstants.CARGOBALL2_INTAKE, StateConstants.CARGOBALL2_LIFT);
            // break;
            // case CARGOBALL3:
            // Robot.arm.SetJointAngles(StateConstants.CARGOBALL3_INTAKE, StateConstants.CARGOBALL3_LIFT);
            // break;
            // case CARGOHATCH:
            // Robot.arm.SetJointAngles(StateConstants.CARGOHATCH_INTAKE, StateConstants.CARGOHATCH_LIFT);
            // break;
            // case ROCKETHATCH1:
            // Robot.arm.SetJointAngles(StateConstants.ROCKETHATCH1_INTAKE, StateConstants.ROCKETHATCH1_LIFT);
            // break;
            // case ROCKETHATCH2:
            // Robot.arm.SetJointAngles(StateConstants.ROCKETHATCH2_INTAKE, StateConstants.ROCKETHATCH2_LIFT);
            // break;
            // case ROCKETHATCH3:
            // Robot.arm.SetJointAngles(StateConstants.ROCKETHATCH3_INTAKE, StateConstants.ROCKETHATCH3_LIFT);
            // break;
            default:
            break;
        } 
    }

    protected boolean isFinished() {
        return isDone;
    }
}
