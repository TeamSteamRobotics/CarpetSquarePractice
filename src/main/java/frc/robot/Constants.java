/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class GyroTurnPID {
        public static final double kP = .9 / 69.0;
        public static final double kI = .5 / 75;
        public static final double kD = 2.0 / 690.0;   
    }

    public static final class DriveConstants {
        public static final double feetPerTick = 7.168135E-5;
    }


}
