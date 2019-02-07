package frc.robot.commands.arm;
import frc.robot.Robot;
import frc.robot.util.Point;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.arm.*;

public class changeIntakeState extends Command {
    
    private Boolean isDone = true;

    private IntakeState intakeState;

    public changeIntakeState(IntakeState intakeState){
        this.intakeState = intakeState;
    }
    public String getIntakeState(){
        switch(intakeState){
            case NOTDEPLOYED:
            return "Not Deployed";
            case DEPLOYED:
            return "Intake Deployed";
            case OBJECTNONE:
            return "No Objects Held";
            case ISHACHET:
            return "Hachet Held";
            case HACHETRELEASE:
            return "Hachet Released";
            case ISBALL:
            return "Ball Held";
            case BALLRELEASE:
            return "Ball Released";
            default:
            return "Null";
        }
    }
    protected void initialize() {
        
    }
    
    protected void execute() {
        Robot.intake.getStateName(getIntakeState());
    }

    protected boolean isFinished() {
        return isDone;
    }
}