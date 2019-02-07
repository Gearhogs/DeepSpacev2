package frc.robot.commands.arm;
import frc.robot.Robot;
import frc.robot.util.Point;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.arm.*;
/**
 *
 */
public class changeArmPosition extends Command {
    
    private Boolean isDone = true;
    private Point P;
    private ArmState armState;

    public changeArmPosition(ArmState armState){
        this.armState = armState;
    }
    public Point getPoint(){
        switch(armState){
            case BALLPICKUP:
            P.setLocation(0,0);
            return P;
            case BALLSTATION:
            P.setLocation(0,0);
            return P;
            case BALLGROUND:
            P.setLocation(0,0);
            return P;
            case HATCHSTATION:
            P.setLocation(0,0);
            return P;
            case ROCKETBALL1:
            P.setLocation(0,0);
            return P;
            case ROCKETBALL2:
            P.setLocation(0,0);
            return P;
            case ROCKETBALL3:
            P.setLocation(0,0);
            return P;
            case CARGOBALL1:
            P.setLocation(0,0);
            return P;
            case CARGOBALL2:
            P.setLocation(0,0);
            return P;
            case CARGOBALL3:
            P.setLocation(0,0);
            return P;
            case CARGOHATCH:
            P.setLocation(0,0);
            return P;
            case ROCKETHATCH1:
            P.setLocation(0,0);
            return P;
            case ROCKETHATCH2:
            P.setLocation(0,0);
            return P;
            case ROCKETHATCH3:
            P.setLocation(0,0);
            return P;
            default: 
            return null;
        
        }
    }
    protected void initialize() {
    }
    
    protected void execute() {
        Robot.arm.setEndEffectorPoint(getPoint());
    }

    protected boolean isFinished() {
        return isDone;
    }
}