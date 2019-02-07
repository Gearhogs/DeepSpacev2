package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.arm.changeIntakeState;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
public class Intake extends Subsystem {
    private TalonSRX leftMotor = new TalonSRX(RobotMap.intakeLeftMotor);
    private TalonSRX rightMotor = new TalonSRX(RobotMap.intakeRightMotor);
	DoubleSolenoid leftCylinder = new DoubleSolenoid(RobotMap.topCylinderFwd, RobotMap.topCylinderRev);
    DoubleSolenoid rightCylinder = new DoubleSolenoid(RobotMap.bottomCylinderFwd, RobotMap.bottomCylinderRev);
    public Intake(){
        rightMotor.follow(leftMotor);
        rightMotor.setInverted(true);
    }
    public void runMotor(double power) {
		leftMotor.set(ControlMode.PercentOutput, power);
    }
    public void intakeRelease() {
		leftCylinder.set(Value.kForward);
        rightCylinder.set(Value.kReverse);
    }
    public void intakeGrab() {
		leftCylinder.set(Value.kReverse);
		rightCylinder.set(Value.kForward);
    }
    public String getStateName(String Position) {
        return Position;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new changeIntakeState(IntakeState.NOTDEPLOYED));
    }
}