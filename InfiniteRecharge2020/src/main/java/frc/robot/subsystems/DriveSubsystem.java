/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import frc.robot.utils.Constants;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase implements Subsystem {

  // The 4 drive Spark Maxs. 1s are used for the forward facing motor, and 2s are the backwards facing ones
  CANSparkMax Left1 = new CANSparkMax(RobotMap.Left1, MotorType.kBrushless);
  CANSparkMax Left2 = new CANSparkMax(RobotMap.Left2, MotorType.kBrushless);
  CANSparkMax Right1 = new CANSparkMax(RobotMap.Right1, MotorType.kBrushless);
  CANSparkMax Right2 = new CANSparkMax(RobotMap.Right2, MotorType.kBrushless);

  // The MotorController groups for the left and right side of the drivetrain
  SpeedControllerGroup LeftControllerGroup = new SpeedControllerGroup(Left1, Left2);
  SpeedControllerGroup RightControllerGroup = new SpeedControllerGroup(Right1, Right2);

  // The left and right side encoders (configured on SparkMax to be alternative encoder on Brushless mode)
  CANEncoder LeftEncoder;
  CANEncoder RightEncoder;
  
  // The NavX-MXP Gyroscope (Kuailabs)
  AHRS Gyro;

  // The differential drivetrain (Tank/West Coast) used on bot. Used for auto calculations
  DifferentialDrive DifferentialDriveTrain = new DifferentialDrive(LeftControllerGroup, RightControllerGroup);

  // The Odometry module (for calculating 2D positions) of the robot
  DifferentialDriveOdometry Odometry;

  // Gear shift DoubleSolenoid
  DoubleSolenoid gearShift = new DoubleSolenoid(RobotMap.GearShiftLow, RobotMap.GearShiftHigh);

  public DriveSubsystem() {

    // Enable follower on the 2 follower CANSpark Maxs
    Left2.follow(Left1);
    Right2.follow(Right1);

    // Invert one side of the drivetrain
    Left1.setInverted(false);
    Right1.setInverted(true);

    // Reset the encoders to start at position 0
    LeftEncoder.setPosition(0);
    RightEncoder.setPosition(0);

    // Initialize the encoders
    LeftEncoder = Left1.getEncoder();
    RightEncoder = Right1.getEncoder();

    // Initialize the gyro
    try {
      Gyro = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException ex) {
			System.out.println("Error instantiating NavX-MXP");
		}

  }

  // This double method returns the distance travelled by the left side of the drivetrain
  public double getLeftDistance () {
    return Constants.kDistancePerTick * (LeftEncoder.getPosition() / LeftEncoder.getCountsPerRevolution());
  }

  // This double method returns the distance travelled by the right side of the drivetrain
  public double getRightDistance () {
    return Constants.kDistancePerTick * (RightEncoder.getPosition() / RightEncoder.getCountsPerRevolution());
  }

  // This DifferentialDriveWheelSpeeds method returns the average wheel velocities (wheel speeds) f the left and right sides of the drivetrain as a new DifferentialDriveWheelSpeeds object. Used to simplify kinematics calculations
  public DifferentialDriveWheelSpeeds getAverageVelocity () {
    return new DifferentialDriveWheelSpeeds(LeftEncoder.getVelocity(), RightEncoder.getVelocity());
  }

  // This double method returns the heading angle of the Gyroscope (the direction/angle the bot is facing in respect to the field)
  public double getGyroAngleHeading () {
    return Gyro.getAngle();
  }

  // This Pose2D method returns the current calculated position of the robot (2D position from Bird's eye view)
  public Pose2d getFieldPosition () {
    return Odometry.getPoseMeters();
  }

  // This void method allows for voltage based differential driving (used in auto for trapezoidal motino profiling)
  public void TankDriveVoltage (double left, double right) {

    // Set the voltage drive for the left and right sides of the drivetrain
    LeftControllerGroup.setVoltage(left);
    RightControllerGroup.setVoltage(right);

    // Feed that voltage to the drivetrain
    DifferentialDriveTrain.feed();

  }

  // This void method would enable Tank Drive on the 4 Spark Maxs by applying the parameter left and right percent power values. This is called by Arcade Drive
  public void TankDrive (double left, double right) {

    // Multiply the left and right voltage factors to limit it to 70%
    left *= 0.75;
    right *= 0.75;

    // Set the left CANSparkMaxs to the left side drivetrain value
    Left1.set(left);
    Left2.set(left);

    // Set the right CANSparkMaxs to the right side drivetrain value
    Right1.set(right);
    Right2.set(right);

  }

  // This void method would enable Arcade Drive on the 4 Spark Maxs by calling Tank Drive with adjusted speed and turn values
  public void ArcadeDrive (double speed, double turn) {
    TankDrive(speed - turn, - speed - turn);
  }

  @Override
  public void periodic () {
    // Update the odometry module periodically with new positional values from the encoders and the gyro
    Odometry.update(Rotation2d.fromDegrees(getGyroAngleHeading()), getLeftDistance(), getRightDistance());
  }

  // This void method toggles the gear shift
  public void toggleGearShift () {

    // Read the current value of the gear shift; reverse it
    if (gearShift.get().equals(Value.kForward)) {
      gearShift.set(Value.kReverse);
    } else if (gearShift.get().equals(Value.kReverse)) {
      gearShift.set(Value.kForward);
    }

  }

}
