package frc.robot.commands.beater;

import frc.robot.Robot;
import frc.robot.util.Point;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.beater.*;

public class changeBeaterState extends Command {

    private Boolean isDone = true;

    private BeaterState beaterState;

    public changeBeaterState(BeaterState beaterState) {
        this.beaterState = beaterState;
    }

    public String getBeaterState() {
        switch (beaterState) {
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
        Robot.beater.getStateName(getBeaterState());
    }

    protected boolean isFinished() {
        return isDone;
    }
}