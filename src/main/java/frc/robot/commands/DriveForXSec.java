/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForXSec extends CommandBase {
  /**
   * Creates a new DriveForXSec.
   */
  DriveSubsystem driveSubsystem;
  double endTime;
  double currentTime;

  public DriveForXSec(DriveSubsystem driveSubsystem, double endTime) {
    // Use addRequirements() here to declare subsystem dependencies.
  this.driveSubsystem = driveSubsystem;
  this.endTime = endTime;
  addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    currentTime = System.currentTimeMillis();
    endTime = currentTime + endTime;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.drive(0.5, 0, false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() >= endTime;
  }
}
