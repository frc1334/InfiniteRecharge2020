/*----------------------------------------------------------------------------

Author: Rico Zhu and Emily DiLauro                Date: January 28th, 2020

IndexerSubsystem Class

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import frc.robot.utils.Constants;
import frc.robot.utils.CANSparkMaxPIDWrapper;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexerSubsystem extends SubsystemBase implements Subsystem {

  // The motor at the front of the hopper. Feeds and centers the balls via a mechanum base
  CANSparkMaxPIDWrapper Feeder;

  public IndexerSubsystem() {

    // Initialize the feeder motor on the IndexerSubsystem
    Feeder = new CANSparkMaxPIDWrapper(RobotMap.Feeder, 1);

    // Configure the PID tuning values for the feeder
    Feeder.setPIDValues(Constants.kIndexerP, Constants.kIndexerI, Constants.kIndexerD, Constants.kIndexerFF, 0);

    // Configure the peak output ranges for the feeder
    Feeder.setPIDOutputRange(Constants.kIndexerMinOutput, Constants.kIndexerMaxOutput);

  }

  // This void method will set a velocity PID target to the Feeder motor
  public void setIndexerVelocity (double setpoint) {
    Feeder.setPIDVelocity(setpoint);
  }

}
