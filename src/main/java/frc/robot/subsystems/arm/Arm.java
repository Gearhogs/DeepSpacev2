/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.util.Joint;
import frc.robot.util.MathUtil;
import frc.robot.util.Vector;
import frc.robot.util.Point;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Arm extends Subsystem {
  private Joint upperArm;
  private Joint lowerArm;


  public Arm(){
    upperArm = new Joint(RobotMap.upperArmMotor);
    lowerArm = new Joint(RobotMap.lowerArmMotor);

    upperArm.setVector(new Vector(0.0, 5.0));
    lowerArm.setVector(new Vector(0.0, 5.0));
  }
  
  public void SetJointAngles(Double UpperArmAngle, Double LowerArmAngle){
    upperArm.setTargetAngle(UpperArmAngle);
    lowerArm.setTargetAngle(LowerArmAngle);
  }
  public void SetUpperArmAngle(Double UpperArmAngle){
    upperArm.setTargetAngle(UpperArmAngle);
  }
  public void SetLowerArmAngle(Double LowerArmAngle){
    lowerArm.setTargetAngle(LowerArmAngle);
  }
  public void resetAngles(){
    upperArm.setTargetAngle(-45.0);
    lowerArm.setTargetAngle(45.0);
  }
  public Point getEndEffectorPoint() {
    Point p = MathUtil.ForwardKinematics(upperArm.getCurrentAngle(), lowerArm.getCurrentAngle(), upperArm.getLength(), lowerArm.getLength());
    return p;
  }
  public void setEndEffectorPoint(Point p) {
    Double[] angles = new Double[2];
    angles = MathUtil.InverseKinematics(p, upperArm.getLength(), lowerArm.getLength());
    SetJointAngles(angles[0], angles[1]);
  }
  public void initDefaultCommand() {
    
  }
}
