package frc.robot.subsystems.beater;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.beater.runBeater;

public class Beater extends Subsystem {
    private TalonSRX leftMotor = new TalonSRX(RobotMap.intakeLeftMotor);
    private TalonSRX rightMotor = new TalonSRX(RobotMap.intakeRightMotor);
    DoubleSolenoid ballCylinder = new DoubleSolenoid(RobotMap.ballCylinderFwd, RobotMap.ballCylinderRev);
    DoubleSolenoid hatchCylinder = new DoubleSolenoid(RobotMap.hatchCylinderFwd, RobotMap.hatchCylinderRev);
    private HatchState hatchState;
    private BallState ballState;
    public Beater() {
        rightMotor.follow(leftMotor);
        rightMotor.setInverted(true);
        leftMotor.configNominalOutputForward(0);
        leftMotor.configNominalOutputReverse(0);
        leftMotor.configPeakOutputForward(RobotMap.peakOutput);
        leftMotor.configPeakOutputReverse(-RobotMap.peakOutput);
        hatchCylinder.set(Value.kForward);
        ballCylinder.set(Value.kForward);
        hatchState = HatchState.ISCLOSED;
        ballState = BallState.BALLRELEASE;
    }
    public HatchState hatchState(){
        return hatchState;
      }
      public BallState ballState(){
        return ballState;
      }
      public void setBallState(BallState ballState) {
        this.ballState= ballState;
      }
      public BallState getBallState() {
        return ballState;
    }
      public void setHatchState(HatchState hatchState) {
        this.hatchState= hatchState;
      }
    public HatchState getHatchState() {
        return hatchState;
    }
    public void runMotor(double power) {
        leftMotor.set(ControlMode.PercentOutput, power);
    }

    public void intakeRelease() {
        ballCylinder.set(Value.kReverse);
    }

    public void intakeGrab() {
        ballCylinder.set(Value.kForward);
    }

    public void ballGrab(){
        ballCylinder.set(Value.kForward);
    }
    public void ballRelease(){
        ballCylinder.set(Value.kReverse);
    }
    public void hatchGrab(){
        hatchCylinder.set(Value.kForward);
    }

    public void hatchRelease(){
        hatchCylinder.set(Value.kReverse);
    }

    public String getStateName(String Position) {
        return Position;
    }
    public void Debug(){
        SmartDashboard.putString("HatchState: ", getHatchState().toString());
        SmartDashboard.putBoolean("Hatch is Closed: ", getHatchState() == HatchState.ISCLOSED);
        SmartDashboard.putString("BallState: ", getBallState().toString());
        SmartDashboard.putBoolean("Ball Grab Ready: ", getBallState() == BallState.BALLRELEASE);
    }

    public void initDefaultCommand() {
        // setDefaultCommand(new changeIntakeState(IntakeState.NOTDEPLOYED));
        setDefaultCommand(new runBeater(0));
    }
}