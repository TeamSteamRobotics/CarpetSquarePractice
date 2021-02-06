/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.VisionSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class RedB extends SequentialCommandGroup {
  /**
   * Creates a new RedB.
   */
  public RedB(DriveSubsystem driveSubsystem, VisionSubsystem visionSubsystem) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new DriveDistance(driveSubsystem, 10*Math.sqrt(2)),
      new TurnForXSec(driveSubsystem, 50/*insert~90 degrees */),
      new GyroTurn(driveSubsystem, visionSubsystem.getAngle()),
      new DriveDistance(driveSubsystem, visionSubsystem.getTargetDistance()),
      new GyroTurn(driveSubsystem, 45) //or approximate 45 degrees with turnforxsec if it saves time


    );
  }
}
