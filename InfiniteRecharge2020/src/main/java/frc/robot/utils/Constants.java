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
    public static final double ksVolts = 0.123;
    public static final double kvVoltSecondsPerMeter = 4.05;
    public static final double kaVoltSecondsSquaredPerMeter = 0.523;

    // Drivetrain trajectory following configurations
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kTrackwidthMeters = 0.8898063852139512;
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(kTrackwidthMeters);

    // Drivetrain RamseteCommand constants
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;

    // Drivetrain Velocity constanrs
    public static final double kPDriveVel = 5e-6;

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
    public static final double kTurretTolerance = 18;

    // Launcher Subsytem Constants

    // Launcher velocity PID tune values
    public static final double kLauncherP = 0.54; // 0.96, 0.75, 0.64, 0.58
    public static final double kLauncherI = 3e-4; // 9e-5
    public static final double kLauncherD = 12.6; // 12.6
    public static final double kLauncherFF = 0.0;

    // Launcher velocity output range
    public static final double kLauncherMinOutput = -1;
    public static final double kLauncherMaxOutput = 1;

    // Accelerator Wheel Subsystem Constants

    // Accelerator Wheel velocity PID tune values
    public static final double kAcceleratorWheelP = 4.8;
    public static final double kAcceleratorWheelI = 9e-4;
    public static final double kAcceleratorWheelD = 0.6;
    public static final double kAcceleratorWheelFF = 0.0;

    // Accelerator Wheel velocity output range
    public static final double kAcceleratorWheelMinOutput = -1;
    public static final double kAcceleratorWheelMaxOutput = 1;

    // Climber PID tune values

    // ClimberUp
    public static final double kClimberUpP = 1.2;
    public static final double kClimberUpI = 0.0;
    public static final double kClimberUpD = 0.0;
    public static final double kClimberUpFF = 0.0;

    // ClimberUp
    public static final double kClimberDownP = 0.0;
    public static final double kClimberDownI = 0.0;
    public static final double kClimberDownD = 0.0;
    public static final double kClimberDownFF = 0.0;

    // ClimberUp PID Position Output range
    public static final double kClimberUpMinOutput = -0.35;
    public static final double kClimberUpMaxOutput = 0.35;

    // ClimberDown PID Position Output range
    public static final double kClimberDownMinOutput = -1;
    public static final double kClimberDownMaxOutput = 1;

    // Climber PID Tolerance
    public static final double kClimbUpTolerance = 200.0;
    public static final double kClimbDownTolerance = 200.0;

}
