/*----------------------------------------------------------------------------

Author: Rico Zhu                Date: January 13th, 2019

Constants Class

This class would act as a dictionary for all "definitions". Definitions are
custom pre-set values to specific variables.

------------------------------------------------------------------------------*/

package frc.robot.utils;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

public class Constants {

    // The definitions for the CANSparkMaxPIDWrapper class mode declarations
    public static final int kPositionMode = 0;
    public static final int kVelocityMode = 1;
    public static final int kSmartMotionMode = 2;

    // Turret Conversion Constants
    
    // The motor ticks for a 270 degree rotation on the main turret
    public static final double Turret270SparkTicks = 97230.625;
    // The emprical values for  a 270 degree rotation on the Turret encoder value multiplied by (4/3)
    public static final double Turret360SparkTicks = Turret270SparkTicks * (4.0/3.0);
    // The number of ticks on the TurretMotor 
    public static final double TurretTicksPerDegree = Turret360SparkTicks / 360.0;

    // Drive Subsystem Constants
    
    // This defines the conversion factor from encoder ticks to meters for both sides of the drivetrain
    public static final double kDistancePerTick = 1.0;

    // This defines the resolution of the drive Alternate Encoders
    public static final int kAltEndoerCPR = 8192;

    // This defines the voltage constraints for the drivetrain
    public static final double ksVolts = 0.0;
    public static final double kvVoltSecondsPerMeter = 0.0;
    public static final double kaVoltSecondsSquaredPerMeter = 0.0;

    // Drivetrain trajectory following configurations
    public static final double kMaxSpeedMetersPerSecond = 0.0;
    public static final double kMaxAccelerationMetersPerSecondSquared = 0.0;
    public static final double kTrackwidthMeters = 0.0;
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(kTrackwidthMeters);

    // Drivetrain RamseteCommand constants
    public static final double kRamseteB = 0.0;
    public static final double kRamseteZeta = 0.0;

    // Drivetrain Velocity constanrs
    public static final double kPDriveVel = 0.0;

    // Turret Subsytem Constants

    // Turret positional PID tune values
    public static final double kTurretP = 4.2; // 4.2
    public static final double kTurretI = 7.735e-8; // 7.735e-8
    public static final double kTurretD = 0.85; // 0.85
    public static final double kTurretFF = 0.0;

    // Turret positional conversion factor
    public static final double kTurretPositionalConversionFactor = 2048;

    // Turret postisional output range
    public static final double kTurretMinOutput = -0.6;
    public static final double kTurretMaxOutput = 0.6;

    // Turret tolerance levels
    public static final double kTurretTolerance = 124;

    // Launcher Subsytem Constants

    // Launcher velocity PID tune values
    public static final double kLauncherP = 0.0;
    public static final double kLauncherI = 0.0;
    public static final double kLauncherD = 0.0;
    public static final double kLauncherFF = 0.0;

    // Launcher velocity output range
    public static final double kLauncherMinOutput = -1;
    public static final double kLauncherMaxOutput = 1;

    // Accelerator Wheel Subsystem Constants

    // Accelerator Wheel velocity PID tune values
    public static final double kAcceleratorWheelP = 0.0;
    public static final double kAcceleratorWheelI = 0.0;
    public static final double kAcceleratorWheelD = 0.0;
    public static final double kAcceleratorWheelFF = 0.0;

    // Accelerator Wheel velocity output range
    public static final double kAcceleratorWheelMinOutput = -1;
    public static final double kAcceleratorWheelMaxOutput = 1;

}
