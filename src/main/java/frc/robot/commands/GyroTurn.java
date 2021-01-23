/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.GyroTurnPID;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class GyroTurn extends PIDCommand {
  /**
   * Creates a new GyroTurn.
   */
  public GyroTurn(DriveSubsystem driveSubsystem, double targetAngle) {
   
    super(
        // The controller that the command will use
        new PIDController(GyroTurnPID.kP, GyroTurnPID.kI, GyroTurnPID.kD),
        // This should return the measurement
        driveSubsystem :: getAngle,
        // This should return the setpoint (can also be a constant)
        targetAngle,
        // This uses the output
        output -> {
          // Use the output here
          driveSubsystem.drive(0, output, false);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
    // Configure additional PID options by calling `getController` here.
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}