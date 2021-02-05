/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
  NetworkTableInstance netTable = NetworkTableInstance.getDefault();
  NetworkTable visionTable = netTable.getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");
  NetworkTableEntry targetPoseEntry = visionTable.getEntry("targetPose");
  NetworkTableEntry yawEntry =  visionTable.getEntry("yawEntry");
  
  /** 
   * Creates a new VisionSubsystem.
   */
  public VisionSubsystem() {

  }

  public double getTargetDistance() {
    double[] defaultPose = {0, 0, 0};
    double[] targetPose = targetPoseEntry.getDoubleArray(defaultPose);
    return targetPose[0];
   }

  public double getAngle(){
    double[] defaultPose = {0, 0, 0};
    double[] targetPose = targetPoseEntry.getDoubleArray(defaultPose);
    return targetPose[2];
   }

   public double getTargetX() {
     return yawEntry.getDouble(0);
   }

   

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
