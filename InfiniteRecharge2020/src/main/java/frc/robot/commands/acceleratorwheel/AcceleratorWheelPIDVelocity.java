/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.acceleratorwheel;

import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AcceleratorWheelPIDVelocity extends CommandBase implements Command {
  
  double velocity;

  public AcceleratorWheelPIDVelocity (double velocity) {
    this.velocity = velocity;
    addRequirements(Robot.AcceleratorWheelSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.AcceleratorWheelSubsystem.setAcceleratorWheelVelocity(velocity);
    //Robot.AcceleratorWheelSubsystem.setAcceleratorWheelPercent(1.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.AcceleratorWheelSubsystem.setAcceleratorWheelPercent(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
