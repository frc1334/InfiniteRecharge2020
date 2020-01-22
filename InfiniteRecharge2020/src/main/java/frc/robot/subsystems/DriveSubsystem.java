/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  // The 4 drive Spark Maxs. 1s are used for the forward facing motor, and 2s are the backwards facing ones
  CANSparkMax Left1;
  CANSparkMax Left2;
  CANSparkMax Right1;
  CANSparkMax Right2;

  public DriveSubsystem() {

    // Initialize the 4 drive Spark Maxs with their respective channel values in RobotMap
    Left1 = new CANSparkMax(RobotMap.Left1, MotorType.kBrushless);
    Left2 = new CANSparkMax(RobotMap.Left2, MotorType.kBrushless);
    Right1 = new CANSparkMax(RobotMap.Right1, MotorType.kBrushless);
    Right2 = new CANSparkMax(RobotMap.Right2, MotorType.kBrushless);

  }

  // This void method would enable Tank Drive on the 4 Spark Maxs by applying the parameter left and right percent power values. This is called by Arcade Drive
  public void TankDrive (double left, double right) {

    // Multiply the left and right voltage factors to limit it to 70%
    left *= 0.7;
    right *= 7;

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

}
