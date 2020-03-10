/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.verticalfeeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TimedFeed extends CommandBase {

  // The initiation time stamp
  double startTime;
  // The total running time period (in seconds)
  double runTime;

  public TimedFeed(double time) {
    addRequirements(Robot.VerticalFeederSubsystem);
    runTime = time * 1000;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.VerticalFeederSubsystem.setVerticalFeederVoltage(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.VerticalFeederSubsystem.setVerticalFeederVoltage(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    // Check to see if the running period has elapsed the entire designated running period (from constructor)
    if ((System.currentTimeMillis() - startTime) >= runTime) {
      return true;
    }

    return false;

  }
}
