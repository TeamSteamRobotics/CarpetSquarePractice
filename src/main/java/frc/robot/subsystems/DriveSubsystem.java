/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  //WPI_TalonSRX leftBack = new WPI_TalonSRX(0);
  WPI_VictorSPX rightBack = new WPI_VictorSPX(0);
  WPI_TalonSRX rightFront = new WPI_TalonSRX(1);
  //WPI_TalonSRX rightBack = new WPI_TalonSRX(2);
  WPI_VictorSPX leftBack = new WPI_VictorSPX(2);
  WPI_TalonSRX leftFront = new WPI_TalonSRX(3);

  SpeedControllerGroup left = new SpeedControllerGroup(leftFront, leftBack);
  SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightBack);

  DifferentialDrive diffDrive = new DifferentialDrive(left, right);
  Timer timer = new Timer();
  AHRS gyro = new AHRS();
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    /*leftFront.setSensorPhase(true);
    rightFront.setSensorPhase(true);
    diffDrive.setSafetyEnabled(false);*/
   // right.setInverted(true);

  }


  public void drive(double speed, double turn, boolean squareInputs){
    diffDrive.arcadeDrive(speed, turn, squareInputs);
  }

 /* public double getDistance() {
    return DriveConstants.feetPerTick *(leftFront.getSelectedSensorPosition() - rightFront.getSelectedSensorPosition())/2.0;
  } */

  //For autonomous practice only
  public void turnRight() {
    left.set(.25);
    right.set(0);
  }
  public void turnLeft() {
    left.set(0);
    right.set(.25);
  }
  public void goForward(double seconds) {
    while(timer.get() < seconds) {
      diffDrive.arcadeDrive(0.5, 0);
    }
    
  //End of autonomous practice methods

  }

  public double getAngle() {
    return gyro.getAngle();
  }
  
  public void resetGyro() {
    gyro.reset();
  }

  public void stop(){
    leftBack.set(0);
    leftFront.set(0);
    rightBack.set(0);
    rightFront.set(0);
  }
  /*public void resetEncoders() {
    leftFront.setSelectedSensorPosition(0);
    rightFront.setSelectedSensorPosition(0);
  } */


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }



}
