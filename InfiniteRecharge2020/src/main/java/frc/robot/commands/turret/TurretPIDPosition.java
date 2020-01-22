/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.turret;

import frc.robot.Robot;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class TurretPIDPosition implements Command {

  double setpoint;

  public TurretPIDPosition(double setpoint) {
    this.setpoint = setpoint;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("INITIALIZE");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Robot.TurretSubsystem.setTurretPosition(setpoint);
    System.out.println("EXECUTING");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /*
     * if (Robot.TurretSubsystem.inRange(setpoint)) { return true; }
     */
    return false;
  }

  @Override
  public Set<Subsystem> getRequirements() {
    // TODO Auto-generated method stub
    return null;
  }

}
