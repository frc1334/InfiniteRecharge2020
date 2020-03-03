/*----------------------------------------------------------------------------

Author: Rico Zhu                                Date: February 19th, 2020

FieldRelativeTurretPosition Command

This Command will set have an instant swing to the field-relative TurretPosition.

This is used in tandem (preceeding) with the Vision Turret Command afterwards
to have a more fluent Vision Turret Tracker.

------------------------------------------------------------------------------*/

package frc.robot.commands.turret;

import frc.robot.Robot;
import frc.robot.utils.Constants;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class FieldRelativeTurretPosition extends CommandBase implements Command {

  // This is the setpoint for the new Turret encoder position
  double setpoint;

  double initAngle = 28.0;

  public FieldRelativeTurretPosition() {
    // TurretSubsystem is used for TurretPosition Control; DriveSubsystem is used for field relative Gyro value fetching
    addRequirements(Robot.DriveSubsystem);
    addRequirements(Robot.TurretSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    /* Algorithm:

      Configuration: Robot is assumed to be in a starting configuration of directly in front of target, turret facing target (actual config tbd)

      1. Find current angle and compute difference from start (assumed to be 0 degrees)
      2. Retrieve current Turret position
      3. Calculate current Turret aim direction (in angle) with the drivetrain/gyro direction to find current Turret orientation relative to the field
      4. Calculate setpoint Turret position from aim position and starting target position (assumed to be 0 degrees)

    */

    // Retrieve the current robot/drivetrain angle (i.e., where the robot/drivetrain is facing)
    double dtAngle = Robot.DriveSubsystem.getGyroAngleHeading() - initAngle;

    if (dtAngle >= 180) {
      dtAngle = dtAngle - 360;
    }

    // Retrieve the current Turret position and calculate the angle from -180 --> +180 from that
    //double turretAngle = (Robot.TurretSubsystem.getTurretPosition()) / (Constants.TurretTicksPerDegree);
    double turretAngle = (Robot.TurretSubsystem.getTurretPosition()) / (64);

    // Find the sum of the angles to determine the relative field position of the Turret in terms of angle degrees
    double frTurretAngle = dtAngle + turretAngle;

    // Find the movement requirement of the angle of the Turret (Difference from field relative target angle of 0.0 to the current angle)
    double angleDifference = 0.0 - frTurretAngle;

    System.out.println("frTurretAngle: " + frTurretAngle);
    System.out.println("angleDifference:" + angleDifference);

    // Update setpoint (normal to the target)
    setpoint = Robot.TurretSubsystem.getTurretPosition() + (angleDifference * (Constants.TurretTicksPerDegree));
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.TurretSubsystem.setTurretPosition(setpoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Robot.TurretSubsystem.turretPercentOutput(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }

}
