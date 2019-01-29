package frc.robot.commands.arm;
import frc.robot.Robot;
import frc.robot.subsystems.arm.ArmState;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.arm.*;
/**
 *
 */
public class armAuto extends Command {
    
    private Boolean isDone = false;
    private ArmState armState;

    public armAuto(){
        requires(Robot.arm);
    }
    protected void initialize() {
        switch(armState){
            case STARTING:
            //Insert Code
            break;
            case BALLPICKUP:
            //Insert Code
            break;
            case BALLSTATION:
            //Insert Code
            break;
            case BALLGROUND:
            //Insert Code
            break;
            case HATCHSTATION:
            //Insert Code
            break;
            case ROCKETBALL:
            //Insert Code
            break;
            case CARGOBALL1:
            //Insert Code
            break;
            case CARGOBALL2:
            //Insert Code
            break;
            case CARGOBALL3:
            //Insert Code
            break;
            case CARGOHATCH1:
            //Insert Code
            break;
            case CARGOHATCH2:
            //Insert Code
            break;
            case CARGOHATCH3:
            //Insert Code
            break;
            case ROCKETHATCH1:
            //Insert Code
            break;
            case ROCKETHATCH2:
            //Insert Code
            break;
            case ROCKETHATCH3:
            //Insert Code
            break;
            default:
            //Insert Code
            break;


        }
    }
    protected void execute() {
    }
    protected boolean isFinished() {
        return isDone;
    }
}
