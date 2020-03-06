/*----------------------------------------------------------------------------

Author: Rico Zhu and Emily DiLauro                Date: January 28th, 2020

IndexerSubsystem Class

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class IndexerSubsystem extends SubsystemBase implements Subsystem {

  // The motor controlling the accelerator wheel. Feeds the balls into the Turret/Shooter
  TalonFX Feeder;

  public IndexerSubsystem() {
    // Initialize the feeder motor on the IndexerSubsystem
    Feeder = new TalonFX(RobotMap.Feeder);
  }

  // This void method will set a voltage target to the Feeder motor
  public void setIndexerVoltage (double voltage) {
    Feeder.set(ControlMode.PercentOutput, voltage);
  }

}
