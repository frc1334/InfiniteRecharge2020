/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climber;

import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimbDownPosition extends CommandBase implements Command {
  /**
   * Creates a new ClimbDownPosition.
   */

  double setpoint;

  public ClimbDownPosition(double setpoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.ClimberSubsystem);
    this.setpoint = setpoint;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.ClimberSubsystem.setClimberDownPosition(setpoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if (Robot.ClimberSubsystem.inRangeClimbDown(setpoint)) {
      return true;
    }

    return false;

  }

}
