/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.arm;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.util.Joint;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Arm extends Subsystem {
  private Joint upperArm;
  private Joint lowerArm;
    // double l1 = 0; //length 1
    // double l2 = 0; //length 2
    // double angle1 = 0;
    // double angle2 = 0;
    // double y1 = math.sin(angle1) * l1; //opposite
    // double x1 = l1 / y1; //adjacent
    // double angleT = Math.acos(x / math.sqrt((x1 * x1) + (y1 * y1)));
    // double endEffector = Point(x1, y1);
  public Arm(){
    upperArm = new Joint();
    lowerArm = new Joint();
    upperArm.setCurrentAngle(-45.0);
    lowerArm.setCurrentAngle(45.0);
  }

  public void initDefaultCommand() {
    
  }
}
