/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.turret;

import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurretPIDPosition extends CommandBase implements Command {

  double setpoint;

  public TurretPIDPosition(double setpoint) {
    this.setpoint = setpoint;
    addRequirements(Robot.TurretSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.TurretSubsystem.setTurretPosition(setpoint);  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.TurretSubsystem.setTurretPosition(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Robot.TurretSubsystem.inRange(setpoint)) { 
      return true;
    }
    return false;
  }

  public void setNewSetpoint (double nSetpoint) {
    setpoint = nSetpoint;
  }

}
