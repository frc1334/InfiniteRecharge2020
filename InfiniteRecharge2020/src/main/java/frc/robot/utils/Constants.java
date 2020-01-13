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
    public static final double kTurretP = 0.0;
    public static final double kTurretI = 0.0;
    public static final double kTurretD = 0.0;
    public static final double kTurretFF = 0.0;

    // Turret positional conversion factor
    public static final double kTurretPositionalConversionFactor = 360;

    // Turret postiional output range
    public static final double kTurretMinOutput = -1;
    public static final double kTurretMaxOutput = 1;

}
