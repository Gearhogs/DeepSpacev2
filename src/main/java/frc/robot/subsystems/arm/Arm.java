/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.arm;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.arm.manualArm;
import frc.robot.util.Joint;
import frc.robot.util.MathUtil;
import frc.robot.util.Point;
import frc.robot.util.Vector;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Arm extends Subsystem {
  private Joint liftArm;
  private Joint intakeArm;
  private TalonSRX rightArm1;
  private ControlMode controlMode;
  private Mode mode;
  private ArmState armState;
  
  public Arm(){
    liftArm = new Joint(RobotMap.leftArm1, RobotMap.liftArmRatio);
    intakeArm = new Joint(RobotMap.arm2, RobotMap.intakeArmRatio);
    rightArm1 = new TalonSRX(RobotMap.rightArm1);

    rightArm1.configFactoryDefault();

    rightArm1.follow(liftArm.getMotor());
    rightArm1.setInverted(InvertType.OpposeMaster);

    liftArm.getMotor().configOpenloopRamp(1);    
    intakeArm.getMotor().configOpenloopRamp(1);
    
    rightArm1.configNominalOutputForward(0);
    rightArm1.configNominalOutputReverse(0);
    rightArm1.configPeakOutputForward(RobotMap.peakOutput);
    rightArm1.configPeakOutputReverse(-RobotMap.peakOutput);
    

    liftArm.getMotor().setInverted(true);
    liftArm.getMotor().configClearPositionOnLimitR(true, 0);

    intakeArm.getMotor().configClearPositionOnLimitF(true, 0);
    
    intakeArm.getMotor().setInverted(InvertType.InvertMotorOutput);
    intakeArm.getMotor().configPeakOutputForward(.4);
    intakeArm.getMotor().configPeakOutputReverse(-.4);

    liftArm.setVector(new Vector(0.0, 32.0));
    intakeArm.setVector(new Vector(0.0, 11.5));

    liftArm.setSensorPhase(true);
    intakeArm.setSensorPhase(true);

    liftArm.configSoftLimits(RobotMap.liftArmLowerLimit, RobotMap.liftArmUpperLimit);
    intakeArm.configSoftLimits(-11000, 0);

    liftArm.setSoftLimit(true);
    liftArm.configLimitSwitchReverse();
    liftArm.setPID(0.0, 0.0, 0.0, 0.0);
    intakeArm.setPID(0.0, 0.0, 0.0, 0.0);
    
    liftArm.setMotionMagic(500, 500);
    intakeArm.setMotionMagic(800, 1200);

    controlMode = ControlMode.PERCENTOUTPUT;
    mode = Mode.MANUAL;
    armState = ArmState.DEFAULT;
  }
  

  public ControlMode getControlMode() {
    return controlMode;
  }
  public Mode getMode(){
    return mode;
  }
  public ArmState getArmState(){
    return armState;
  }
  public void setArmState(ArmState armState) {
    this.armState = armState;
  }
  public void setMode(Mode mode) {
    this.mode = mode;
  }
  public void setControlMode(ControlMode controlMode) {
    this.controlMode = controlMode;
  }
  public Joint getliftArm() {
    return liftArm;
  }
  public Joint getintakeArm() {
    return intakeArm;
  }
  public void SetJointAngles(Double liftArmAngle, Double intakeArmAngle) {
    liftArm.setTargetPos(MathUtil.DegreesToAdc(liftArmAngle));
    intakeArm.setTargetPos(MathUtil.DegreesToTicks(intakeArmAngle, RobotMap.intakeArmRatio));
  }
  public void SetJointAngles(State intakeState, State liftState) {
    liftArm.setTargetAdc(liftState.getAdc());
    intakeArm.setTargetPos(intakeState.getTicks());
  }
  public void SetliftArmAngle(State liftState){
    liftArm.setTargetPos(liftState.getAdc());
  }
  public void SetintakeArmAngle(State intakeState){
    intakeArm.setTargetPos(intakeState.getTicks());
  }
  public void SetliftArmAngle(Double liftArmAngle){
    liftArm.setTargetAdc(MathUtil.DegreesToAdc(liftArmAngle));
  }
  public void SetintakeArmAngle(Double intakeArmAngle){
    intakeArm.setTargetPos(MathUtil.DegreesToTicks(intakeArmAngle, RobotMap.intakeArmRatio));
  }
  // public void resetAngles(){
  //   liftArm.setTargetAngle(-45.0);
  //   intakeArm.setTargetAngle(45.0);
  // }
  public Point getEndEffectorPoint() {
    Point p = MathUtil.ForwardKinematics(liftArm.getCurrentAngle(), intakeArm.getCurrentAngle(), liftArm.getLength(), intakeArm.getLength());
    return p;
  }
  public void setEndEffectorPoint(Point p) {
    Double[] angles = new Double[2];
    angles = MathUtil.InverseKinematics(p, liftArm.getLength(), intakeArm.getLength());
    SetJointAngles(angles[0], angles[1]);
  }
  public void runliftArm(Double power){
    liftArm.runMotor(power);
  } 
  public void runintakeArm(Double power){
    intakeArm.runMotor(power);
  }
  public void resetZero(){
    // liftArm.setAnalogPosition(600);
    intakeArm.setRelativePosition(0);
    liftArm.setSoftLimit(true);
    intakeArm.setSoftLimit(true);
  }
  public int getAbsolutePosition() {
    return liftArm.getAnalogPosition();
  }
  public void Debug() {
    SmartDashboard.putData("Arm: ", this);
    liftArm.Debug("Lift Arm");
    intakeArm.Debug("Intake Arm");
    SmartDashboard.putString("Arm State", getArmState().toString());
  }

  public void initDefaultCommand() {
    //setDefaultCommand(new changeArmPosition(ArmState.STARTING));
    setDefaultCommand(new manualArm());
  }
}
