/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.turret;

import frc.robot.Robot;
import frc.robot.utils.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurretAutoTracking extends CommandBase {

  double trackPoint = 0.0;

  public TurretAutoTracking() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.TurretSubsystem);
    addRequirements(Robot.LimelightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("SECOND INIT");
    trackPoint = Robot.TurretSubsystem.getTurretPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // Get the current horizontal displacement
    double xDisplacement = Robot.LimelightSubsystem.getXDisplacement();

    System.out.println("xDisplacement: " + Robot.LimelightSubsystem.getXDisplacement());

    // Increment / Decrement the tradk point 64
    //trackPoint += (xDisplacement) * Constants.TurretTicksPerDegree;
    trackPoint += (xDisplacement) * 64;

    Robot.TurretSubsystem.setTurretPosition(trackPoint);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.TurretSubsystem.turretPercentOutput(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if (Robot.TurretSubsystem.inRange(trackPoint)) {
      return true;
    }

    return false;

  }

}
