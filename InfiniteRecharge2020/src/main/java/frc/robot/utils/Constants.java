/*----------------------------------------------------------------------------

Author: Rico Zhu                Date: January 13th, 2019

Constants Class

This class would act as a dictionary for all "definitions". Definitions are
custom pre-set values to specific variables.

------------------------------------------------------------------------------*/

package frc.robot.utils;

public class Constants {

    // The definitions for the CANSparkMaxPIDWrapper class mode declarations
    public static final int kPositionMode = 0;
    public static final int kVelocityMode = 1;
    public static final int kSmartMotionMode = 2;

    // Turret Subsytem Constants

    // Turret positional PID tune values
    public static final double kTurretP = 4.2; // 4.2
    public static final double kTurretI = 7.735e-8; // 7.7e-8
    public static final double kTurretD = 0.85; // 0.85
    public static final double kTurretFF = 0.0;

    // Turret positional conversion factor
    public static final double kTurretPositionalConversionFactor = 2048;

    // Turret postisional output range
    public static final double kTurretMinOutput = -0.6;
    public static final double kTurretMaxOutput = 0.6;

    // Turret tolerance levels
    public static final double kTurretTolerance = 164;

    // Launcher Subsytem Constants

    // Launcher positional PID tune values
    public static final double kLauncherP = 0.0;
    public static final double kLauncherI = 0.0;
    public static final double kLauncherD = 0.0;
    public static final double kLauncherFF = 0.0;

    // Launcher postiional output range
    public static final double kLauncherMinOutput = -1;
    public static final double kLauncherMaxOutput = 1;

}
